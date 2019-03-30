package com.wl.myshrio.service;

import com.wl.myshrio.generator.jooq.tables.pojos.SysRole;

import java.util.List;

public interface RoleService {

    List<SysRole>  findAllRoles();
}
