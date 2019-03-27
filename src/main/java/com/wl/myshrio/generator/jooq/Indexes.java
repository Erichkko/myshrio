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

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>shrio</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index SYS_ATTRIBUTE_PRIMARY = Indexes0.SYS_ATTRIBUTE_PRIMARY;
    public static final Index SYS_ATTRIBUTE_DETAIL_PRIMARY = Indexes0.SYS_ATTRIBUTE_DETAIL_PRIMARY;
    public static final Index SYS_LOGIN_LOG_PRIMARY = Indexes0.SYS_LOGIN_LOG_PRIMARY;
    public static final Index SYS_OPERATING_RECORD_PRIMARY = Indexes0.SYS_OPERATING_RECORD_PRIMARY;
    public static final Index SYS_PERMISSION_PRIMARY = Indexes0.SYS_PERMISSION_PRIMARY;
    public static final Index SYS_ROLE_PRIMARY = Indexes0.SYS_ROLE_PRIMARY;
    public static final Index SYS_ROLE_PERMISSION_PRIMARY = Indexes0.SYS_ROLE_PERMISSION_PRIMARY;
    public static final Index SYS_USER_PRIMARY = Indexes0.SYS_USER_PRIMARY;
    public static final Index SYS_USER_ROLE_PRIMARY = Indexes0.SYS_USER_ROLE_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index SYS_ATTRIBUTE_PRIMARY = Internal.createIndex("PRIMARY", SysAttribute.SYS_ATTRIBUTE, new OrderField[] { SysAttribute.SYS_ATTRIBUTE.ID }, true);
        public static Index SYS_ATTRIBUTE_DETAIL_PRIMARY = Internal.createIndex("PRIMARY", SysAttributeDetail.SYS_ATTRIBUTE_DETAIL, new OrderField[] { SysAttributeDetail.SYS_ATTRIBUTE_DETAIL.ID }, true);
        public static Index SYS_LOGIN_LOG_PRIMARY = Internal.createIndex("PRIMARY", SysLoginLog.SYS_LOGIN_LOG, new OrderField[] { SysLoginLog.SYS_LOGIN_LOG.ID }, true);
        public static Index SYS_OPERATING_RECORD_PRIMARY = Internal.createIndex("PRIMARY", SysOperatingRecord.SYS_OPERATING_RECORD, new OrderField[] { SysOperatingRecord.SYS_OPERATING_RECORD.ID }, true);
        public static Index SYS_PERMISSION_PRIMARY = Internal.createIndex("PRIMARY", SysPermission.SYS_PERMISSION, new OrderField[] { SysPermission.SYS_PERMISSION.ID }, true);
        public static Index SYS_ROLE_PRIMARY = Internal.createIndex("PRIMARY", SysRole.SYS_ROLE, new OrderField[] { SysRole.SYS_ROLE.ID }, true);
        public static Index SYS_ROLE_PERMISSION_PRIMARY = Internal.createIndex("PRIMARY", SysRolePermission.SYS_ROLE_PERMISSION, new OrderField[] { SysRolePermission.SYS_ROLE_PERMISSION.ID }, true);
        public static Index SYS_USER_PRIMARY = Internal.createIndex("PRIMARY", SysUser.SYS_USER, new OrderField[] { SysUser.SYS_USER.ID }, true);
        public static Index SYS_USER_ROLE_PRIMARY = Internal.createIndex("PRIMARY", SysUserRole.SYS_USER_ROLE, new OrderField[] { SysUserRole.SYS_USER_ROLE.ID }, true);
    }
}