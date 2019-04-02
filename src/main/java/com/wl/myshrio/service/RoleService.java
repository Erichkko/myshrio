package com.wl.myshrio.service;

import com.wl.myshrio.generator.jooq.tables.pojos.SysRole;
import com.wl.myshrio.model.dto.ParamsDto;

import java.util.List;

public interface RoleService {

    List<SysRole>  findAllRoles();

    List<SysRole> findRoleByPage(ParamsDto dto);

    Integer findRoleTotal(ParamsDto dto);

    Integer addRoles(SysRole role);

    Integer delRoles(ParamsDto dto);
}
