package com.example.srp.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DecoderHandler extends ByteToMessageDecoder {
    private static Map<ChannelHandlerContext, String> msgBufMap = new ConcurrentHashMap<>();

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);
        String msg = new String(data, Charset.forName("GBK"));
        out.add(msg);
    }
}
