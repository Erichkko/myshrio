package com.wl.myshrio.controller;


import com.alibaba.fastjson.JSON;
import com.wl.myshrio.Enum.EnumCode;
import com.wl.myshrio.generator.jooq.tables.pojos.SysRole;
import com.wl.myshrio.generator.jooq.tables.pojos.SysRolePermission;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.dto.RolePermisVo;
import com.wl.myshrio.service.RolePermissionService;
import com.wl.myshrio.service.RoleService;
import com.wl.myshrio.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "RoleApi/v1")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    RolePermissionService rolePermissionService;

    /**
     * 绑定角色下拉框
     *
     * @param vo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/findAllRoles")
    public String findAllRoles(RolePermisVo vo, BindingResult bindingResult) {
        List<SysRole> roles = roleService.findAllRoles();

        if (roles != null && roles.size() > 0) {
            return ResultUtil.result(EnumCode.OK.getValue(), EnumCode.OK.getText(), JSON.toJSON(roles));
        } else {
            return ResultUtil.result(EnumCode.DATA_NULL.getValue(), EnumCode.DATA_NULL.getText());
        }
    }

    @GetMapping(value = "/findRoleByPage")
    public String findRoleByPage(ParamsDto dto) {
        dto.setStartPage(dto.getStartPage() - 1);
        List<SysRole> roles = roleService.findRoleByPage(dto);
        if (roles != null && roles.size() > 0) {
            return ResultUtil.result(EnumCode.OK.getValue(), EnumCode.OK.getText(), JSON.toJSON(roles),roleService.findRoleTotal(dto));
        } else {
            return ResultUtil.result(EnumCode.DATA_NULL.getValue(), EnumCode.DATA_NULL.getText());
        }
    }

    @PostMapping(value = "/addRoles")
    public  String addRoles(SysRole role){
        Integer result = roleService.addRoles(role);
        if (result == 1) {
            return ResultUtil.result(EnumCode.OK.getValue(), EnumCode.OK.getText());
        } else {
            return ResultUtil.result(EnumCode.INTERNAL_SERVER_ERROR.getValue(), EnumCode.INTERNAL_SERVER_ERROR.getText());
        }
    }

    @PostMapping(value = "/delRoles")
    public String delRoles(ParamsDto dto){
        Integer result = roleService.delRoles(dto);
        if (result == 1) {
            return ResultUtil.result(EnumCode.OK.getValue(), EnumCode.OK.getText());
        } else {
            return ResultUtil.result(EnumCode.INTERNAL_SERVER_ERROR.getValue(), EnumCode.INTERNAL_SERVER_ERROR.getText());
        }
    }

    @GetMapping(value = "/findRolesPermisByRole")
    public String findRolesPermisByRole(ParamsDto dto){
        if (null == dto.getId()) {
            return ResultUtil.result(EnumCode.BAD_REQUEST.getValue(), EnumCode.BAD_REQUEST.getText());
        }
        List<SysRolePermission> list = rolePermissionService.findRolesPermisByRole(dto);
        String[] arr = new String[list.size()];
        for (int i = 0,j=list.size(); i < j; i++) {
            arr[i] = list.get(i).getPid();
        }
        return ResultUtil.result(EnumCode.OK.getValue(),EnumCode.OK.getText(), JSON.toJSON(arr));
    }
}
