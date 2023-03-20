package com.example.srp.domian;

import java.sql.Date;
import java.sql.Timestamp;

public class MonitorImg {
    private int id;
    private Timestamp time;
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
