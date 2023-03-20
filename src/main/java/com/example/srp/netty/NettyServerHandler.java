package com.example.srp.netty;

import com.example.srp.domian.Light;
import com.example.srp.domian.LightEnv;
import com.example.srp.domian.Monitor;
import com.example.srp.domian.MonitorImg;
import com.example.srp.service.LightEnvService;
import com.example.srp.service.LightService;
import com.example.srp.service.MonitorImgService;
import com.example.srp.service.MonitorService;
import com.example.srp.utils.ImgUtils;
import com.example.srp.utils.SpringJobBeanFactory;
import com.example.srp.utils.TimeUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    public static NettyServerHandler nettyServerHandler;
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static final int MagicNum = 16909060; // 01 02 03 04
    public static final int MsgType = 1; // 信息服务
    public static final int ImgType = 2; // 图片服务


    // 连接
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String ip = insocket.getAddress().getHostAddress();
        // System.out.println(insocket.getAddress());
        log.info("已连接ip:" + ip);
        channelGroup.add(ctx.channel());
        super.channelActive(ctx);
    }


    // 获取信息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String ip = insocket.getAddress().getHostAddress();

        ByteBuf byteMsg = (ByteBuf) msg;
        int magicNum = byteMsg.readInt();
        int type = byteMsg.readInt();
        long time = byteMsg.readLong();
        int length = byteMsg.readInt();
        byte[] data = new byte[length];
        byteMsg.readBytes(data, 0, length);
        log.info("magicNum: {}, type: {}, time: {}, length: {}", magicNum, type, time, length);

        if(magicNum == MagicNum) {
            if(type == MsgType) {
                String dataMsg = new String(data, StandardCharsets.UTF_8);
                log.info("data:{}", dataMsg);
                String[] datas = dataMsg.split(",");
                LightService lightService = SpringJobBeanFactory.getBean(LightService.class);
                assert lightService != null;
                Light light = lightService.getByIp(ip);
                if(light != null) {
                    LightEnv lightEnv = new LightEnv();
                    lightEnv.setId(light.getId().intValue());
                    lightEnv.setTime(new Timestamp(time));
                    lightEnv.setTemperature(Double.parseDouble(datas[0]));
                    lightEnv.setHumidity(Double.parseDouble(datas[1]));
                    lightEnv.setAd(Long.parseLong(datas[2]));
                    lightEnv.setDb(Integer.parseInt(datas[3]));
                    lightEnv.setPm2_5(Double.parseDouble(datas[4]));
                    LightEnvService lightEnvService = SpringJobBeanFactory.getBean(LightEnvService.class);
                    assert lightEnvService != null;
                    lightEnvService.save(lightEnv);
                }
            }
            else if(type == ImgType) {
                MonitorService monitorService = SpringJobBeanFactory.getBean(MonitorService.class);
                assert monitorService != null;
                Monitor monitor = monitorService.getByIp(ip);
                if(monitor != null) {
                    String url = ImgUtils.saveImg(data);
                    MonitorImgService monitorImgService = SpringJobBeanFactory.getBean(MonitorImgService.class);
                    MonitorImg monitorImg = new MonitorImg();
                    monitorImg.setId(monitor.getId().intValue());
                    monitorImg.setTime(new Timestamp(time));
                    assert monitorImgService != null;
                    monitorImg.setUrl(url);
                    monitorImgService.save(monitorImg);
                }
            }
        }
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String ip = insocket.getAddress().getHostAddress();
        log.info(ip + "断开连接");
        channelGroup.remove(ctx.channel());
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 发生异常，关闭通道
        cause.printStackTrace();
        ctx.close();
    }
}
