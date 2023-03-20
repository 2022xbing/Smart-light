package com.example.srp.service;

import com.example.srp.domian.Monitor;

import java.util.List;
import java.util.Set;

public interface MonitorService {
    /**
     * 获取所有监控ip
     * @return
     */
    List<String> getAllIpService();

    /**
     * 获取所有监控id
     *
     * @return
     */
    List<Long> getAllIdService();

    /***
     * 注册业务逻辑
     * @param
     * @return
     */
    Monitor registerService(Monitor monitor);

    Monitor getById(int id);

    Monitor getByIp(String ip);
}
