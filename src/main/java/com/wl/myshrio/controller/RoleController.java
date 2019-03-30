package com.wl.myshrio.controller;


import com.alibaba.fastjson.JSON;
import com.wl.myshrio.Enum.EnumCode;
import com.wl.myshrio.generator.jooq.tables.pojos.SysRole;
import com.wl.myshrio.model.dto.RolePermisVo;
import com.wl.myshrio.service.RoleService;
import com.wl.myshrio.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value =  "RoleApi/v1")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 绑定角色下拉框
     *
     * @param vo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/findAllRoles")
    public String findAllRoles(RolePermisVo vo, BindingResult bindingResult) {
        List<SysRole> list = roleService.findAllRoles();

        return ResultUtil.result(EnumCode.OK.getValue(), EnumCode.OK.getText(), JSON.toJSON(list));
    }
}
