package com.example.cybersecurity_lab4.mapper;

import com.example.cybersecurity_lab4.entity.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface user_mapper {
    @Select("select * from user where name=#{username}")
    user get_user(String username);
    @Update("update user set pwd=#{pwd}")
    int change_pwd(String pwd);
    @Update("update user set hash=#{hash}")
    int change_hash(String hash);
}
