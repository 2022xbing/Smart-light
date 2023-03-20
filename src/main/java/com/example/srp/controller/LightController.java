package com.example.srp.controller;

import com.example.srp.domian.Light;
import com.example.srp.service.LightService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.srp.utils.Result;

import java.util.List;


@RestController
@RequestMapping("/light")
public class LightController {
    @Resource
    private LightService lightService;

    @PostMapping("/register")
    public Result<Light> registerController(@RequestBody Light newLight) {
        Light light = lightService.registerService(newLight);
        if (light != null) {
            return Result.success(light, "注册成功！");
        } else {
            return Result.error(2, "该路灯已存在！");
        }
    }

    @PostMapping("/getAddress")
    public Result<List<String>> getAddressController() {
        List<String> ret = lightService.getAllAddressService();
        if (ret == null || ret.size() == 0) {
            return Result.error(3, "目前不存在路灯信息");
        } else {
            return Result.success(ret, "查询成功");
        }
    }

    @PostMapping("/getIp")
    public Result<List<String>> getIpController() {
        List<String> ret = lightService.getAllIpService();
        if (ret == null || ret.size() == 0) {
            return Result.error(3, "目前不存在路灯信息");
        } else {
            return Result.success(ret, "查询成功");
        }
    }

    @PostMapping("/getId")
    public Result<List<Long>> getIdController() {
        List<Long> ret = lightService.getAllIdService();
        if (ret == null || ret.size() == 0) {
            return Result.error(3, "目前不存在路灯信息");
        } else {
            return Result.success(ret, "查询成功");
        }
    }
}
