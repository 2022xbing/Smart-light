package com.example.srp.controller;

import com.example.srp.domian.Monitor;
import com.example.srp.service.MonitorService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.srp.utils.Result;

import java.util.List;

@RestController
@RequestMapping("/monitor")
public class MonitorController {
    @Resource
    private MonitorService monitorService;

    @PostMapping("/getIp")
    public Result<List<String>> getIpController() {
        List<String> ret = monitorService.getAllIpService();
        if (ret == null || ret.size() == 0) {
            return Result.error(3, "目前不存在监控信息");
        } else {
            return Result.success(ret, "查询成功");
        }
    }

    @PostMapping("/getId")
    public Result<List<Long>> getIdController() {
        List<Long> ret = monitorService.getAllIdService();
        if (ret == null || ret.size() == 0) {
            return Result.error(3, "目前不存在监控信息");
        } else {
            return Result.success(ret, "查询成功");
        }
    }

    @PostMapping("/register")
    public Result<Monitor> registerController(@RequestBody Monitor newMonitor) {
        // System.out.println(newMonitor);
        Monitor monitor = monitorService.registerService(newMonitor);
        if (monitor != null) {
            return Result.success(monitor, "注册成功！");
        } else {
            return Result.error(2, "该监控已存在！");
        }
    }
}
