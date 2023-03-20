package com.example.srp.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class NettyServer {
    public void start(Integer port) {
        // 主线程组, 用于接受客户端的连接，但是不做任何处理
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // 从线程组, 当boss接受连接并注册被接受的连接到worker时，处理被接受连接的流量
        EventLoopGroup workerGroup = new NioEventLoopGroup(200);
        try {
            //创建服务端的启动对象，设置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            //设置两个线程组boosGroup和workerGroup
            bootstrap.group(bossGroup, workerGroup)
                    //设置服务端通道实现类型
                    .channel(NioServerSocketChannel.class)
                    // 初始化通道对象
                    .childHandler(new ServerChannelInitializer())
                    // 设置线程队列得到连接个数
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    // 设置保持活动连接状态
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // 绑定端口，开始接收进来的连接
            ChannelFuture future = bootstrap.bind(port).sync();
            if (future.isSuccess()) log.info("服务器启动成功，port: {}", port);
            // 断开连接
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭主线程组
            bossGroup.shutdownGracefully();
            // 关闭工作线程组
            workerGroup.shutdownGracefully();
        }
    }
}
