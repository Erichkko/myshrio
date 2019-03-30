package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.Tables;
import com.wl.myshrio.generator.jooq.tables.pojos.SysRole;
import com.wl.myshrio.service.RoleService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    DSLContext dslContext;
    @Override
    public List<SysRole> findAllRoles() {
        List<SysRole> into = dslContext.select().
                from(Tables.SYS_ROLE).fetch().into(SysRole.class);
        return into;
    }
}
