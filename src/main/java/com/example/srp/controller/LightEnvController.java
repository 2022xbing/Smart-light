package com.example.srp.controller;

import com.example.srp.domian.Light;
import com.example.srp.domian.LightEnv;
import com.example.srp.service.LightEnvService;
import com.example.srp.service.LightService;
import com.example.srp.utils.LightData;
import com.example.srp.utils.RequestLightEnv;
import com.example.srp.utils.Result;
import com.example.srp.utils.TimeUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lightEnv")
public class LightEnvController {
    @Resource
    private LightEnvService lightEnvService;
    @Resource
    private LightService lightService;

    @RequestMapping("/save")
    public Result<LightEnv> save(@RequestBody LightEnv lightEnv) {
        lightEnv = lightEnvService.save(lightEnv);
        if(lightEnv == null) {
            return Result.error(200, "");
        }
        else return Result.success(lightEnv);
    }

    @RequestMapping("/gettemdata")
    public Result<LightData<Double>> getTemData(@RequestBody RequestLightEnv requestLightEnv) {
        Light light = lightService.getById(requestLightEnv.getId());
        if(light == null) return Result.error(4, "无该路灯");
        LightData<Double> lightData = lightEnvService.findByIdAndDateTemperature(requestLightEnv.getId(), requestLightEnv.getDate());
        lightData.setAddress(light.getAddress());
        return Result.success(lightData);
    }

    @RequestMapping("/gethumdata")
    public Result<LightData<Double>> getHumData(@RequestBody RequestLightEnv requestLightEnv) {
        Light light = lightService.getById(requestLightEnv.getId());
        if(light == null) return Result.error(4, "无该路灯");
        LightData<Double> lightData = lightEnvService.findByIdAndDateHumidity(requestLightEnv.getId(), requestLightEnv.getDate());
        lightData.setAddress(light.getAddress());
        return Result.success(lightData);
    }

    @RequestMapping("/getaddata")
    public Result<LightData<Long>> getAdData(@RequestBody RequestLightEnv requestLightEnv) {
        Light light = lightService.getById(requestLightEnv.getId());
        if(light == null) return Result.error(4, "无该路灯");
        LightData<Long> lightData = lightEnvService.findByIdAndDateAd(requestLightEnv.getId(), requestLightEnv.getDate());
        lightData.setAddress(light.getAddress());
        return Result.success(lightData);
    }

    @RequestMapping("/getdbdata")
    public Result<LightData<Integer>> getDbData(@RequestBody RequestLightEnv requestLightEnv) {
        Light light = lightService.getById(requestLightEnv.getId());
        if(light == null) return Result.error(4, "无该路灯");
        LightData<Integer> lightData = lightEnvService.findByIdAndDateDb(requestLightEnv.getId(), requestLightEnv.getDate());
        lightData.setAddress(light.getAddress());
        return Result.success(lightData);
    }

    @RequestMapping("/getpmdata")
    public Result<LightData<Double>> getPm2_5Data(@RequestBody RequestLightEnv requestLightEnv) {
        Light light = lightService.getById(requestLightEnv.getId());
        if(light == null) return Result.error(4, "无该路灯");
        LightData<Double> lightData = lightEnvService.findByIdAndDatePm2_5(requestLightEnv.getId(), requestLightEnv.getDate());
        lightData.setAddress(light.getAddress());
        return Result.success(lightData);
    }
}
