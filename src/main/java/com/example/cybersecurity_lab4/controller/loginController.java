package com.example.cybersecurity_lab4.controller;

import com.example.cybersecurity_lab4.crypto.AESUtil;
import com.example.cybersecurity_lab4.crypto.Hashcode;
import com.example.cybersecurity_lab4.entity.user;
import com.example.cybersecurity_lab4.mapper.user_mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class loginController {
    @Resource
    Hashcode hash;
    @Resource
    user_mapper mapper;
    @RequestMapping("/auth")
    @ResponseBody
    public String auth(String username,String code2,String ver){
        user user=mapper.get_user(username);
        System.out.println(ver);
        if(user==null){
            return "error";
        }
        String my_code2= hash.getSha1(user.getHash()+ver);
        if(code2.equals(my_code2)){
            String code1=user.getHash();
            String ack= AESUtil.encrypt(ver,code1.substring(0,16));
            return ack;
        }
        return "error";
    }

}
