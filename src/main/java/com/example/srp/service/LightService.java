package com.example.srp.service;

import com.example.srp.domian.Light;

import java.util.List;

public interface LightService {
    /**
     * 获取所有路灯ip
     *
     * @return
     */
    List<String> getAllIpService();

    /**
     * 获取所有路灯id
     *
     * @return
     */
    List<Long> getAllIdService();

    /***
     * 获取所有路灯位置
     * @return
     */
    List<String> getAllAddressService();

    /***
     * 注册业务逻辑
     * @param light
     * @return
     */
    Light registerService(Light light);

    /***
     * 通过Id查找
     * @param id
     * @return
     */
    Light getById(int id);

    /***
     * 通过Ip查找
     * @param ip
     * @return
     */
    Light getByIp(String ip);

    /***
     * 通过路灯地址区域查询所有路灯
     * @param address
     * @return
     */
    List<Light> getAllLightByAddressService(String address);
}
