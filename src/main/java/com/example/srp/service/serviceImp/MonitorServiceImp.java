package com.example.srp.service.serviceImp;

import com.example.srp.domian.Monitor;
import com.example.srp.mapper.MonitorDao;
import com.example.srp.service.MonitorService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MonitorServiceImp implements MonitorService {
    @Resource
    private MonitorDao monitorDao;

    @Override
    public List<String> getAllIpService() {
        List<String> ret = new ArrayList<>();
        List<Monitor> get = monitorDao.findAll();
        for (Monitor monitor : get) {
            ret.add(monitor.getIp());
        }
        return ret;
    }

    @Override
    public List<Long> getAllIdService() {
        List<Long> ret = new ArrayList<>();
        List<Monitor> get = monitorDao.findAll();
        for (Monitor monitor : get) {
            ret.add(monitor.getId());
        }
        return ret;
    }

    @Override
    public Monitor registerService(Monitor monitor) {
        if (monitorDao.findByIp(monitor.getIp()) != null) {
            //存在该IP
            return null;
        } else {
            monitorDao.save(monitor);
            // System.out.println(monitor);
            return monitor;
        }
    }

    @Override
    public Monitor getById(int id) {
        return monitorDao.findById(id);
    }

    @Override
    public Monitor getByIp(String ip) {
        return monitorDao.findByIp(ip);
    }
}
