package com.example.srp.mapper;

import com.example.srp.domian.Light;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LightDao {
    @Select("select * from light where id = #{id}")
    Light findById(int id);

    @Select("select * from light where ip = #{ip}")
    Light findByIp(String ip);

    @Select("select * from light")
    List<Light> findAll();

    @Select("select * from light where address = #{address}")
    List<Light> findByAddress(String address);


    @Insert("insert into light(ip) VALUES (#{ip})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void save(Light light);
}
