package com.example.srp.mapper;

import com.example.srp.domian.LightEnv;
import com.example.srp.utils.LightData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface LightEnvDao {


    @Select("select * from lightenv where id = #{id}")
    List<LightEnv> findById(int id);

    @Select("select * from lightenv where id = #{id} and time between #{startTime} and #{endTime}")
    List<LightEnv> findByIdAndDate(int id, Timestamp startTime, Timestamp endTime);

    @Select("select * from lightenv,light " +
            "where light.address = #{address} " +
            "and light.id = lightenv.id " +
            "and time between #{startTime} and #{endTime}")
    List<LightEnv> findByAddressAndDate(String address, Timestamp startTime, Timestamp endTime);

    @Select("select * from lightenv,light " +
            "where light.ip = #{ip} " +
            "and light.id = lightenv.id " +
            "and time between #{startTime} and #{endTime}")
    List<LightEnv> findByIpAndDate(String ip, Timestamp startTime, Timestamp endTime);

    @Select("select * from lightenv,light " +
            "where light.ip = #{ip} " +
            "and light.id = lightenv.id " +
            "and time = #{time}")
    LightEnv findByIpAndTime(String ip, Timestamp time);

    @Select("select * from lightenv where id = #{id} and time = #{time}")
    LightEnv findByIdAndTime(int id, Timestamp time);

    @Select("select * from lightenv,light " +
            "where light.address = #{address} " +
            "and light.id = lightenv.id " +
            "and time = #{time}")
    LightEnv findByAddressAndTime(String address, Timestamp time);

    // temperature
    @Select("select max(temperature) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    Double findByIdAndDayTemMax(int id, Timestamp date);

    @Select("select min(temperature) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    Double findByIdAndDayTemMin(int id, Timestamp date);

    @Select("select avg(temperature) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    Double findByIdAndDayTemAvg(int id, Timestamp date);

    @Select("select temperature from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time) " +
            "order by time DESC " +
            "limit 1")
    Double findByIdAndDayTemLast(int id, Timestamp date);

    // humidity
    @Select("select max(humidity) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    Double findByIdAndDayHumMax(int id, Timestamp date);

    @Select("select min(humidity) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    Double findByIdAndDayHumMin(int id, Timestamp date);

    @Select("select avg(humidity) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    Double findByIdAndDayHumAvg(int id, Timestamp date);

    @Select("select humidity from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time) " +
            "order by time DESC " +
            "limit 1")
    Double findByIdAndDayHumLast(int id, Timestamp date);

    // ad
    @Select("select max(ad) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    Long findByIdAndDayAdMax(int id, Timestamp date);

    @Select("select min(ad) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    Long findByIdAndDayAdMin(int id, Timestamp date);

    @Select("select avg(ad) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    Double findByIdAndDayAdAvg(int id, Timestamp date);

    @Select("select ad from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time) " +
            "order by time DESC " +
            "limit 1")
    Long findByIdAndDayAdLast(int id, Timestamp date);

    // db
    @Select("select max(db) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    int findByIdAndDayDbMax(int id, Timestamp date);

    @Select("select min(db) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    int findByIdAndDayDbMin(int id, Timestamp date);

    @Select("select avg(db) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    Double findByIdAndDayDbAvg(int id, Timestamp date);

    @Select("select db from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time) " +
            "order by time DESC " +
            "limit 1")
    int findByIdAndDayDbLast(int id, Timestamp date);

    // pm2_5
    @Select("select max(pm2_5) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    Double findByIdAndDayPm2_5Max(int id, Timestamp date);

    @Select("select min(pm2_5) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    Double findByIdAndDayPm2_5Min(int id, Timestamp date);

    @Select("select avg(pm2_5) from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time)")
    Double findByIdAndDayPm2_5Avg(int id, Timestamp date);

    @Select("select pm2_5 from lightenv " +
            "where id = #{id} and TO_DAYS(#{date}) = TO_DAYS(time) " +
            "order by time DESC " +
            "limit 1")
    Double findByIdAndDayPm2_5Last(int id, Timestamp date);

    @Insert("insert into lightenv(id, time, temperature, humidity, ad, db, pm2_5) " +
            "VALUES (" +
            "#{id}," +
            "#{time}," +
            "#{temperature}," +
            "#{humidity}," +
            "#{ad}," +
            "#{db}," +
            "#{pm2_5})")
    void save(LightEnv lightEnv);


}
