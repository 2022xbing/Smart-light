package com.example.srp.service.serviceImp;

import com.example.srp.domian.MonitorImg;
import com.example.srp.mapper.MonitorImgDao;
import com.example.srp.service.MonitorImgService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MonitorImgServiceImp implements MonitorImgService {
    @Resource
    private MonitorImgDao monitorImgDao;

    @Override
    public String getUrl(MonitorImg monitorImg) {
        return null;
    }

    @Override
    public Boolean save(MonitorImg monitorImg) {
        monitorImgDao.save(monitorImg);
        return null;
    }
}
