package com.example.srp.service.serviceImp;

import com.example.srp.domian.LightEnv;
import com.example.srp.mapper.LightEnvDao;
import com.example.srp.service.LightEnvService;
import com.example.srp.utils.LightData;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.srp.utils.TimeUtils;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class LightEnvServiceImp implements LightEnvService {
    private static int serviceTime = TimeUtils.TenMin;
    private static int serviceDay = TimeUtils.OneDay;
    @Resource
    private LightEnvDao lightEnvDao;

    @Override
    public LightEnv save(LightEnv lightEnv) {
        lightEnvDao.save(lightEnv);
        return lightEnv;
    }

    @Override
    public List<LightEnv> findByCurTime(int id) {
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        Timestamp startTime = TimeUtils.getBefMin(endTime, serviceTime);
        return findByStartTimeAndEndTime(id, startTime, endTime);
    }

    @Override
    public List<LightEnv> findByTime(int id, Timestamp time) {
        Timestamp startTime = TimeUtils.getBefMin(time, serviceTime);
        return findByStartTimeAndEndTime(id, startTime, time);
    }

    @Override
    public List<LightEnv> findByStartTimeAndEndTime(int id, Timestamp startTime, Timestamp endTime) {
        return lightEnvDao.findByIdAndDate(id, startTime, endTime);
    }

    @Override
    public LightData<Double> findByIdAndDateTemperature(int id, Timestamp day) {
        LightData<Double> ret = new LightData<>();
        // System.out.println("id: " + id + ",day: " + day);
        ret.setDataMax(lightEnvDao.findByIdAndDayTemMax(id, day));
        ret.setDataMin(lightEnvDao.findByIdAndDayTemMin(id, day));
        ret.setDataAvg(lightEnvDao.findByIdAndDayTemAvg(id, day));
        ret.setLast(lightEnvDao.findByIdAndDayTemLast(id, day));
        // System.out.println(ret);
        return ret;
    }

    @Override
    public LightData<Double> findByIdAndDateHumidity(int id, Timestamp day) {
        LightData<Double> ret = new LightData<>();
        ret.setDataMax(lightEnvDao.findByIdAndDayHumMax(id, day));
        ret.setDataMin(lightEnvDao.findByIdAndDayHumMin(id, day));
        ret.setDataAvg(lightEnvDao.findByIdAndDayHumAvg(id, day));
        ret.setLast(lightEnvDao.findByIdAndDayHumLast(id, day));
        return ret;
    }

    @Override
    public LightData<Double> findByIdAndDatePm2_5(int id, Timestamp day) {
        LightData<Double> ret = new LightData<>();
        ret.setDataMax(lightEnvDao.findByIdAndDayPm2_5Max(id, day));
        ret.setDataMin(lightEnvDao.findByIdAndDayPm2_5Min(id, day));
        ret.setDataAvg(lightEnvDao.findByIdAndDayPm2_5Avg(id, day));
        ret.setLast(lightEnvDao.findByIdAndDayPm2_5Last(id, day));
        return ret;
    }

    @Override
    public LightData<Long> findByIdAndDateAd(int id, Timestamp day) {
        LightData<Long> ret = new LightData<>();
        ret.setDataMax(lightEnvDao.findByIdAndDayAdMax(id, day));
        ret.setDataMin(lightEnvDao.findByIdAndDayAdMin(id, day));
        ret.setDataAvg(lightEnvDao.findByIdAndDayPm2_5Avg(id, day));
        ret.setLast(lightEnvDao.findByIdAndDayAdLast(id, day));
        return ret;
    }

    @Override
    public LightData<Integer> findByIdAndDateDb(int id, Timestamp day) {
        LightData<Integer> ret = new LightData<>();
        ret.setDataMax(lightEnvDao.findByIdAndDayDbMax(id, day));
        ret.setDataMin(lightEnvDao.findByIdAndDayDbMin(id, day));
        ret.setDataAvg(lightEnvDao.findByIdAndDayPm2_5Avg(id, day));
        ret.setLast(lightEnvDao.findByIdAndDayDbLast(id, day));
        return ret;
    }

    @Override
    public List<LightEnv> findByCurTimeAndIp(String ip) {
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        Timestamp startTime = TimeUtils.getBefMin(endTime, serviceTime);
        return findByStartTimeAndEndTimeAndIp(ip, startTime, endTime);
    }

    @Override
    public List<LightEnv> findByTimeAndIp(String ip, Timestamp time) {
        Timestamp startTime = TimeUtils.getBefMin(time, serviceTime);
        return findByStartTimeAndEndTimeAndIp(ip, startTime, time);
    }

    @Override
    public List<LightEnv> findByStartTimeAndEndTimeAndIp(String ip, Timestamp startTime, Timestamp endTime) {
        return lightEnvDao.findByIpAndDate(ip, startTime, endTime);
    }

    @Override
    public List<LightEnv> findByCurTimeAndAddress(String address) {
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        Timestamp startTime = TimeUtils.getBefMin(endTime, serviceTime);
        return findByStartTimeAndEndTimeAndAddress(address, startTime, endTime);
    }

    @Override
    public List<LightEnv> findByTimeAndAddress(String address, Timestamp time) {
        Timestamp startTime = TimeUtils.getBefMin(time, serviceTime);
        return findByStartTimeAndEndTimeAndAddress(address, startTime, time);
    }

    @Override
    public List<LightEnv> findByStartTimeAndEndTimeAndAddress(String address, Timestamp startTime, Timestamp endTime) {
        return lightEnvDao.findByAddressAndDate(address, startTime, endTime);
    }


}
