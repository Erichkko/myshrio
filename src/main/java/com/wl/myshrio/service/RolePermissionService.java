package com.wl.myshrio.service;

import com.wl.myshrio.model.dto.RolePermisDto;

import java.util.List;

public interface RolePermissionService {
    /**
     * 根据父id\角色id查询角色菜单
     *
     * @author: jwy
     * @date: 2018/1/20
     */
    List<RolePermisDto> findRolesPermisByFatherId(String fatherId, String rid);
}
