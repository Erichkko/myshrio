/*
 * This file is generated by jOOQ.
*/
package com.wl.myshrio.generator.jooq.tables.daos;


import com.wl.myshrio.generator.jooq.tables.SysRolePermission;
import com.wl.myshrio.generator.jooq.tables.records.SysRolePermissionRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class SysRolePermissionDao extends DAOImpl<SysRolePermissionRecord, com.wl.myshrio.generator.jooq.tables.pojos.SysRolePermission, String> {

    /**
     * Create a new SysRolePermissionDao without any configuration
     */
    public SysRolePermissionDao() {
        super(SysRolePermission.SYS_ROLE_PERMISSION, com.wl.myshrio.generator.jooq.tables.pojos.SysRolePermission.class);
    }

    /**
     * Create a new SysRolePermissionDao with an attached configuration
     */
    @Autowired
    public SysRolePermissionDao(Configuration configuration) {
        super(SysRolePermission.SYS_ROLE_PERMISSION, com.wl.myshrio.generator.jooq.tables.pojos.SysRolePermission.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getId(com.wl.myshrio.generator.jooq.tables.pojos.SysRolePermission object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.wl.myshrio.generator.jooq.tables.pojos.SysRolePermission> fetchById(String... values) {
        return fetch(SysRolePermission.SYS_ROLE_PERMISSION.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.wl.myshrio.generator.jooq.tables.pojos.SysRolePermission fetchOneById(String value) {
        return fetchOne(SysRolePermission.SYS_ROLE_PERMISSION.ID, value);
    }

    /**
     * Fetch records that have <code>rid IN (values)</code>
     */
    public List<com.wl.myshrio.generator.jooq.tables.pojos.SysRolePermission> fetchByRid(String... values) {
        return fetch(SysRolePermission.SYS_ROLE_PERMISSION.RID, values);
    }

    /**
     * Fetch records that have <code>pid IN (values)</code>
     */
    public List<com.wl.myshrio.generator.jooq.tables.pojos.SysRolePermission> fetchByPid(String... values) {
        return fetch(SysRolePermission.SYS_ROLE_PERMISSION.PID, values);
    }
}
