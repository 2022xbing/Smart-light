package com.example.srp.mapper;

import com.example.srp.domian.Monitor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MonitorDao {
    @Select("select * from monitor where id = #{id}")
    Monitor findById(Integer id);

    @Select("select * from monitor where ip = #{ip}")
    Monitor findByIp(String ip);

    @Select("select * from monitor")
    List<Monitor> findAll();

    @Insert("insert into monitor(ip) VALUES (#{ip})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void save(Monitor monitor);
}
