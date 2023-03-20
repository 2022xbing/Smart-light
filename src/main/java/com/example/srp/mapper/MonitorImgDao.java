package com.example.srp.mapper;

import com.example.srp.domian.MonitorImg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MonitorImgDao {
    @Insert("insert into monitorimg(id, time, url) values (#{id},#{time},#{url})")
    void save(MonitorImg monitorImg);

    @Select("select * from monitorimg where id = #{id} and time = #{time}")
    String findByIdAndTime(MonitorImg monitorImg);
}
