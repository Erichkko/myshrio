package com.wl.myshrio.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.wl.myshrio.Enum.EnumCode;
import com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog;
import com.wl.myshrio.model.dto.RolePermisDto;
import com.wl.myshrio.model.dto.UserInfoDto;
import com.wl.myshrio.service.LoginLogService;
import com.wl.myshrio.service.LoginService;
import com.wl.myshrio.service.RolePermissionService;
import com.wl.myshrio.utils.LocalDateUtil;
import com.wl.myshrio.utils.ResultUtil;
import com.wl.myshrio.utils.UUIDUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginLogService loginLogService;

    @Autowired
    RolePermissionService rolePermissionService;

    @Override
    public String login(String name, String pwd,HttpSession session, HttpServletRequest request) {
        UsernamePasswordToken upToken = new UsernamePasswordToken(name, pwd);
        Subject subject = SecurityUtils.getSubject();
        subject.login(upToken);

        UserInfoDto userInfoDto = (UserInfoDto) subject.getPrincipal();
        session.setAttribute("user", userInfoDto);

        // 登录日志
        SysLoginLog loginLog = new SysLoginLog();
        loginLog.setId(UUIDUtil.getUUID());
        loginLog.setUid(userInfoDto.getId());
        loginLog.setLogintime(LocalDateUtil.date2LocalDateTime(new Date()));
        loginLog.setLoginip(request.getRemoteAddr());
        loginLog.setLogintotal(loginLogService.findVisitCountByUserId(userInfoDto.getId())); // 登录总次数
        loginLogService.insert(loginLog);


        // 一级 模块
        List<RolePermisDto> parentList = rolePermissionService.findRolesPermisByFatherId(null, null);
        List<RolePermisDto> sonList = null;
        List<RolePermisDto> sonssonList = null;
        String rid = userInfoDto.getRoleName().equals("admin") ? null : userInfoDto.getRoleid();

        for (int i = 0; i < parentList.size(); i++) {

            ArrayList<RolePermisDto> trueChildrenList = new ArrayList<>();

            // 二级 页面
            sonList = rolePermissionService.findRolesPermisByFatherId(parentList.get(i).getId(), null);

            for (int k = 0, l = sonList.size(); k < l; k++) {

                // 三级按钮
                sonssonList = rolePermissionService.findRolesPermisByFatherId(sonList.get(k).getId(), rid);
                // 如果按钮级拥有权限说明页面也有权限
                if (!sonssonList.isEmpty()) {
                    sonssonList.size();
                    trueChildrenList.add(sonList.get(k));
                }
            }
            parentList.get(i).setChildren(trueChildrenList);

        }
        userInfoDto.setRolePermis((ArrayList) parentList);
        return ResultUtil.result(EnumCode.OK.getValue(), "登陆成功", JSON.toJSON(userInfoDto));
    }
}
