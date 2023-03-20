package com.example.srp.mapper;

import com.example.srp.domian.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    @Select("select * from user where username = #{username} and password = #{password}")
    User findByUsernameAndPassword(String username, String password);

    @Insert("insert into user(username,password) VALUES (#{username},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "uid", keyColumn = "uid")
    void addUser(User user);
}
