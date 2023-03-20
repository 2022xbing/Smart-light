package com.example.srp;

import com.example.srp.netty.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
@MapperScan("com.example.srp.mapper")
public class SrpApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SrpApplication.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(8087);
    }

}
