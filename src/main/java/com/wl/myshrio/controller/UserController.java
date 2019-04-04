package com.wl.myshrio.controller;


import com.alibaba.fastjson.JSON;
import com.wl.myshrio.Enum.EnumCode;
import com.wl.myshrio.Enum.EnumRoleType;
import com.wl.myshrio.generator.jooq.tables.pojos.SysUser;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.dto.UserDto;
import com.wl.myshrio.model.vo.UserInfoVo;
import com.wl.myshrio.model.vo.UserVo;
import com.wl.myshrio.service.UserService;
import com.wl.myshrio.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "UserApi/v1")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查询普通用户列表
     *
     * @param dto
     * @return
     */

    @GetMapping(value = "/findUserByPage")
    public String findUserByPage(ParamsDto dto) {
        dto.setStartPage(dto.getStartPage() - 1);
        dto.setType(EnumRoleType.USER.getValue());
        List<UserDto> resultInfo = userService.findUserByPage(dto);
        log.error("resultInfo == " + resultInfo);
        int total = userService.findUserTotal(dto);
        return ResultUtil.result(EnumCode.OK.getValue(), "获取成功！", JSON.toJSON(resultInfo), total);
    }

//
//    @PostMapping(value = "/addUser")
//    public String addUser(String name,String pass,String email,String status,String role) {
//        return "";
//    }


    @PostMapping(value = "/addUser")
    public String addUser(UserVo userVo) {
        return (String) userService.addUser(userVo);
    }

    @PostMapping(value = "/editUserStatus")
    public String editUserStatus(ParamsDto dto){

        return (String) userService.editUserStatus(dto);
    }

    @PostMapping(value = "/delUsers")
    public String delUsers(ParamsDto dto){
        if (StringUtils.isEmpty(dto.getIds()) ||dto.getIds().length==0) {
            return ResultUtil.result(EnumCode.BAD_REQUEST.getValue(), EnumCode.BAD_REQUEST.getText());
        }
        return (String) userService.delUsers(dto);
    }

    @PostMapping(value = "/editUserInfo")
    public String editUserInfo(UserInfoVo sysUser){

        Integer integer = userService.editUserInfo(sysUser);
        if (integer ==1){
            return ResultUtil.result(EnumCode.OK.getValue(), EnumCode.OK.getText());
        }else {
            return ResultUtil.result(EnumCode.EXCPTION_ERROR.getValue(), EnumCode.EXCPTION_ERROR.getText());
        }
    }

}
