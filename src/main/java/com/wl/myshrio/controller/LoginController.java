package com.wl.myshrio.controller;

import com.wl.myshrio.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping(value = "LoginApi/v1")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String login(String name, String pass, HttpSession session, HttpServletRequest request){
//        String loginResult = loginService.login("admin", "d477887b0636e5d87f79cc25c99d7dc9", session, request);
        String loginResult = loginService.login(name, pass, session, request);
        log.info("loginResult"+loginResult);
        return loginResult;
    }

    @GetMapping("/login")
    public String login1(String name, String pass, HttpSession session, HttpServletRequest request){
        String loginResult = loginService.login("admin", "d477887b0636e5d87f79cc25c99d7dc9", session, request);
//        String loginResult = loginService.login(name, pass, session, request);
        log.info("loginResult"+loginResult);
        return loginResult;
    }


}
