package com.example.srp.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.ipfilter.RuleBasedIpFilter;
import io.netty.handler.ipfilter.UniqueIpFilter;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 初始化
 */
@Slf4j
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    public static ByteBuf delimiter = Unpooled.copiedBuffer("#".getBytes());

    public static MyIpFilterRule myIpFilterRule = new MyIpFilterRule();

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new UniqueIpFilter()); // 重复ip过滤
        socketChannel.pipeline().addLast(new RuleBasedIpFilter(myIpFilterRule)); // 白名单过滤
        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
        // socketChannel.pipeline().addLast(new DecoderHandler());
        // socketChannel.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
        //        socketChannel.pipeline().addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
        socketChannel.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
        socketChannel.pipeline().addLast(new NettyServerHandler());
    }
}
