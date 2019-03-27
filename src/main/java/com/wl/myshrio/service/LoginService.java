package com.wl.myshrio.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface LoginService {
    String login(String name, String pwd, HttpSession session, HttpServletRequest request);
}
