package com.example.srp.service;


import com.example.srp.domian.LightEnv;
import com.example.srp.utils.LightData;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface LightEnvService {
    /***
     * 插入数据
     * @param lightEnv
     * @return
     */
    LightEnv save(LightEnv lightEnv);

    /***
     * 通过id查找十分钟前到当前时间的数据
     * @param id
     * @return
     */
    List<LightEnv> findByCurTime(int id);

    /***
     * 通过id查找十分钟前到指定时间的数据
     * @param id
     * @return
     */
    List<LightEnv> findByTime(int id, Timestamp time);

    /***
     * 通过id查找指定时间段的数据
     * @param id
     * @param startTime
     * @param endTime
     * @return
     */
    List<LightEnv> findByStartTimeAndEndTime(int id, Timestamp startTime, Timestamp endTime);

    /***
     * 通过id查找指定日期的Temperature数据
     * @param id
     * @param day
     * @return
     */
    LightData<Double> findByIdAndDateTemperature(int id, Timestamp day);

    /***
     * 通过id查找指定日期的Humidity数据
     * @param id
     * @param day
     * @return
     */
    LightData<Double> findByIdAndDateHumidity(int id, Timestamp day);

    /***
     * 通过id查找指定日期的Pm2_5数据
     * @param id
     * @param day
     * @return
     */
    LightData<Double> findByIdAndDatePm2_5(int id, Timestamp day);

    /***
     * 通过id查找指定日期的Ad数据
     * @param id
     * @param day
     * @return
     */
    LightData<Long> findByIdAndDateAd(int id, Timestamp day);

    /***
     * 通过id查找指定日期的Db数据
     * @param id
     * @param day
     * @return
     */
    LightData<Integer> findByIdAndDateDb(int id, Timestamp day);

    /***
     * 通过ip查找十分钟前到当前时间的数据
     * @param ip
     * @return
     */
    List<LightEnv> findByCurTimeAndIp(String ip);

    /***
     * 通过ip查找十分钟前到指定时间的数据
     * @param ip
     * @return
     */
    List<LightEnv> findByTimeAndIp(String ip, Timestamp time);

    /***
     * 通过ip查找指定时间段的数据
     * @param ip
     * @param startTime
     * @param endTime
     * @return
     */
    List<LightEnv> findByStartTimeAndEndTimeAndIp(String ip, Timestamp startTime, Timestamp endTime);

    /***
     * 通过address查找十分钟前到当前时间的数据
     * @param address
     * @return
     */
    List<LightEnv> findByCurTimeAndAddress(String address);

    /***
     * 通过address查找十分钟前到指定时间的数据
     * @param address
     * @return
     */
    List<LightEnv> findByTimeAndAddress(String address, Timestamp time);

    /***
     * 通过address查找指定时间段的数据
     * @param address
     * @param startTime
     * @param endTime
     * @return
     */
    List<LightEnv> findByStartTimeAndEndTimeAndAddress(String address, Timestamp startTime, Timestamp endTime);
}
