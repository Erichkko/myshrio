/*
 * This file is generated by jOOQ.
*/
package com.wl.myshrio.generator.jooq;


import com.wl.myshrio.generator.jooq.tables.SysAttribute;
import com.wl.myshrio.generator.jooq.tables.SysAttributeDetail;
import com.wl.myshrio.generator.jooq.tables.SysLoginLog;
import com.wl.myshrio.generator.jooq.tables.SysOperatingRecord;
import com.wl.myshrio.generator.jooq.tables.SysPermission;
import com.wl.myshrio.generator.jooq.tables.SysRole;
import com.wl.myshrio.generator.jooq.tables.SysRolePermission;
import com.wl.myshrio.generator.jooq.tables.SysUser;
import com.wl.myshrio.generator.jooq.tables.SysUserRole;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in shrio
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>shrio.sys_attribute</code>.
     */
    public static final SysAttribute SYS_ATTRIBUTE = com.wl.myshrio.generator.jooq.tables.SysAttribute.SYS_ATTRIBUTE;

    /**
     * The table <code>shrio.sys_attribute_detail</code>.
     */
    public static final SysAttributeDetail SYS_ATTRIBUTE_DETAIL = com.wl.myshrio.generator.jooq.tables.SysAttributeDetail.SYS_ATTRIBUTE_DETAIL;

    /**
     * The table <code>shrio.sys_login_log</code>.
     */
    public static final SysLoginLog SYS_LOGIN_LOG = com.wl.myshrio.generator.jooq.tables.SysLoginLog.SYS_LOGIN_LOG;

    /**
     * The table <code>shrio.sys_operating_record</code>.
     */
    public static final SysOperatingRecord SYS_OPERATING_RECORD = com.wl.myshrio.generator.jooq.tables.SysOperatingRecord.SYS_OPERATING_RECORD;

    /**
     * The table <code>shrio.sys_permission</code>.
     */
    public static final SysPermission SYS_PERMISSION = com.wl.myshrio.generator.jooq.tables.SysPermission.SYS_PERMISSION;

    /**
     * The table <code>shrio.sys_role</code>.
     */
    public static final SysRole SYS_ROLE = com.wl.myshrio.generator.jooq.tables.SysRole.SYS_ROLE;

    /**
     * The table <code>shrio.sys_role_permission</code>.
     */
    public static final SysRolePermission SYS_ROLE_PERMISSION = com.wl.myshrio.generator.jooq.tables.SysRolePermission.SYS_ROLE_PERMISSION;

    /**
     * The table <code>shrio.sys_user</code>.
     */
    public static final SysUser SYS_USER = com.wl.myshrio.generator.jooq.tables.SysUser.SYS_USER;

    /**
     * The table <code>shrio.sys_user_role</code>.
     */
    public static final SysUserRole SYS_USER_ROLE = com.wl.myshrio.generator.jooq.tables.SysUserRole.SYS_USER_ROLE;
}
