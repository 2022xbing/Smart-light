package com.example.srp.utils;

public class LightData<T>{
    String address;
    T last;
    T dataMax;
    T dataMin;
    Double dataAvg;

    @Override
    public String toString() {
        return "LightData{" +
                "address='" + address + '\'' +
                ", last=" + last +
                ", max=" + dataMax +
                ", min=" + dataMin +
                ", avg=" + dataAvg +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }

    public T getDataMax() {
        return dataMax;
    }

    public void setDataMax(T dataMax) {
        this.dataMax = dataMax;
    }

    public T getDataMin() {
        return dataMin;
    }

    public void setDataMin(T dataMin) {
        this.dataMin = dataMin;
    }

    public Double getDataAvg() {
        return dataAvg;
    }

    public void setDataAvg(Double dataAvg) {
        this.dataAvg = dataAvg;
    }
}
