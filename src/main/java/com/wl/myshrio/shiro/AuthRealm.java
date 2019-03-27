package com.wl.myshrio.shiro;



import com.wl.myshrio.generator.jooq.tables.pojos.SysUser;
import com.wl.myshrio.model.dto.UserInfoDto;
import com.wl.myshrio.service.UserService;
import com.wl.myshrio.utils.LocalDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Slf4j
public class AuthRealm extends AuthorizingRealm {

    /**
     * 用户
     */
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        return null;
    }

    /**
     * @desc: 授权
     *
//     * @date: 2017/12/18
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("======================= 认证登陆 ======================");
        // 获取用户输入的token
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String name = upToken.getUsername();
        String pass = String.valueOf(upToken.getPassword());
        List<UserInfoDto> list = userService.checkUser(name, pass);
        UserInfoDto userInfoDto = null;
        if (null == list || list.isEmpty()) {
            throw new AuthenticationException("账号或密码错误");
        } else if (list.get(0).getState() == 0) {
            /**
             * 账号被禁用
             */
            throw new AuthenticationException("账号已被禁止登陆");
        }else{
            userInfoDto = list.get(0);
            //登录成功
            //更新登录时间 last login time
            SysUser user = new SysUser();
            user.setId(userInfoDto.getId());
            user.setLastLoginTime(LocalDateUtil.date2LocalDateTime(new Date()));
            userService.updateById(user);
        }
        log.info("======================= 登陆成功 ======================");
        return new SimpleAuthenticationInfo(userInfoDto, userInfoDto.getPassword(), getName());

    }
}

