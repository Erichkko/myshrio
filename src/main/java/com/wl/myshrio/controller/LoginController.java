package com.wl.myshrio.controller;

import com.wl.myshrio.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "LoginApi/v1")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String login(String name,String pwd){
//        loginService.login(name,pwd);
//        loginService.login("1","a123456");
        loginService.login("11","d477887b0636e5d87f79cc25c99d7dc9");
        return "";
    }
}
