package com.example.srp.domian;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;


public class LightEnv {

    private int id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp time;              // 时间
    private Double temperature;     // 温度
    private Double humidity;        // 湿度
    private Long ad;                // 亮度
    private int db;                 // 分贝
    private Double pm2_5;           // pm2.5

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Long getAd() {
        return ad;
    }

    public void setAd(Long ad) {
        this.ad = ad;
    }

    public int getDb() {
        return db;
    }

    public void setDb(int db) {
        this.db = db;
    }

    public Double getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(Double pm2_5) {
        this.pm2_5 = pm2_5;
    }
}
