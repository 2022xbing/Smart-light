package com.example.srp.service.serviceImp;

import com.example.srp.domian.Light;
import com.example.srp.mapper.LightDao;
import com.example.srp.service.LightService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LightServiceImp implements LightService {
    @Resource
    private LightDao lightDao;

    @Override
    public List<String> getAllIpService() {
        List<String> ret = new ArrayList<>();
        List<Light> get = lightDao.findAll();
        for (Light light : get) {
            ret.add(light.getIp());
        }
        return ret;
    }

    @Override
    public List<String> getAllAddressService() {
        List<String> ret = new ArrayList<>();
        List<Light> get = lightDao.findAll();
        for (Light light : get) {
            ret.add(light.getAddress());
        }
        return ret;
    }

    @Override
    public List<Long> getAllIdService() {
        List<Long> ret = new ArrayList<>();
        List<Light> get = lightDao.findAll();
        for (Light light : get) {
            ret.add(light.getId());
        }
        return ret;
    }

    @Override
    public Light registerService(Light light) {
        if (lightDao.findByIp(light.getIp()) != null) {
            //存在该IP
            return null;
        } else {
            lightDao.save(light);
            // System.out.println(light);
            return light;
        }
    }

    public Light getById(int id) {
        return lightDao.findById(id);
    }

    @Override
    public Light getByIp(String ip) {
        return lightDao.findByIp(ip);
    }

    @Override
    public List<Light> getAllLightByAddressService(String address) {
        return lightDao.findByAddress(address);
    }
}
