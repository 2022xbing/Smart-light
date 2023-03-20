package com.example.srp.domian;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Light {
    @Id
    private Long id;

    private String ip;
    private String address;

    @Override
    public String toString() {
        return "Light{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
