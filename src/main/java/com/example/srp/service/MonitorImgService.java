package com.example.srp.service;

import com.example.srp.domian.MonitorImg;

public interface MonitorImgService {
    /***
     * 获取图片url
     * @param monitorImg
     * @return
     */
    String getUrl(MonitorImg monitorImg);

    /***
     * 保存图片url
     * @param monitorImg
     * @return
     */
    Boolean save(MonitorImg monitorImg);
}
