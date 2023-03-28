package com.example.cybersecurity_lab4.controller;

import com.example.cybersecurity_lab4.crypto.Hashcode;
import com.example.cybersecurity_lab4.mapper.user_mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class mainController {
    @Resource
    Hashcode hash;
    @Resource
    user_mapper mapper;
    @RequestMapping("user")
    public String user(){return "user";}
    @RequestMapping("/login")
    public String login(){return "login";}
    @RequestMapping("/change")
    @ResponseBody
    public String change(String new_pwd){
        String code1=hash.getSha1("张雷"+new_pwd);
        mapper.change_pwd(new_pwd);
        mapper.change_hash(code1);
        return "ok";
    }
}
