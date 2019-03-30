package com.wl.myshrio.controller;


import com.alibaba.fastjson.JSON;
import com.wl.myshrio.Enum.EnumCode;
import com.wl.myshrio.Enum.EnumRoleType;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.dto.UserDto;
import com.wl.myshrio.service.UserService;
import com.wl.myshrio.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "UserApi/v1")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查询普通用户列表
     * @param dto
     * @return
     */

    @GetMapping(value = "/findUserByPage")
    public String findUserByPage(ParamsDto dto) {
        dto.setStartPage(dto.getStartPage()-1);
        dto.setType(EnumRoleType.USER.getValue());
        List<UserDto> resultInfo = userService.findUserByPage(dto);
        log.error("resultInfo == "+resultInfo);
        int total = userService.findUserTotal(dto);
        return ResultUtil.result(EnumCode.OK.getValue(),"获取成功！",JSON.toJSON(resultInfo),total );
    }
}
