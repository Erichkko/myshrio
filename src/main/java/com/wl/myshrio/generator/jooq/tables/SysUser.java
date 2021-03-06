/*
 * This file is generated by jOOQ.
*/
package com.wl.myshrio.generator.jooq.tables;


import com.wl.myshrio.generator.jooq.Indexes;
import com.wl.myshrio.generator.jooq.Keys;
import com.wl.myshrio.generator.jooq.Shrio;
import com.wl.myshrio.generator.jooq.tables.records.SysUserRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class SysUser extends TableImpl<SysUserRecord> {

    private static final long serialVersionUID = 1107078552;

    /**
     * The reference instance of <code>shrio.sys_user</code>
     */
    public static final SysUser SYS_USER = new SysUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysUserRecord> getRecordType() {
        return SysUserRecord.class;
    }

    /**
     * The column <code>shrio.sys_user.id</code>.
     */
    public final TableField<SysUserRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * The column <code>shrio.sys_user.head_portraits</code>. 头像
     */
    public final TableField<SysUserRecord, String> HEAD_PORTRAITS = createField("head_portraits", org.jooq.impl.SQLDataType.VARCHAR(255), this, "头像");

    /**
     * The column <code>shrio.sys_user.nickname</code>. 用户昵称
     */
    public final TableField<SysUserRecord, String> NICKNAME = createField("nickname", org.jooq.impl.SQLDataType.VARCHAR(20), this, "用户昵称");

    /**
     * The column <code>shrio.sys_user.email</code>. 邮箱|登录帐号
     */
    public final TableField<SysUserRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR(128), this, "邮箱|登录帐号");

    /**
     * The column <code>shrio.sys_user.pswd</code>. 密码
     */
    public final TableField<SysUserRecord, String> PSWD = createField("pswd", org.jooq.impl.SQLDataType.VARCHAR(32), this, "密码");

    /**
     * The column <code>shrio.sys_user.create_time</code>. 创建时间
     */
    public final TableField<SysUserRecord, LocalDateTime> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "创建时间");

    /**
     * The column <code>shrio.sys_user.last_login_time</code>. 最后登录时间
     */
    public final TableField<SysUserRecord, LocalDateTime> LAST_LOGIN_TIME = createField("last_login_time", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "最后登录时间");

    /**
     * The column <code>shrio.sys_user.status</code>. 1:有效，0:禁止登录
     */
    public final TableField<SysUserRecord, Long> STATUS = createField("status", org.jooq.impl.SQLDataType.BIGINT.defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.BIGINT)), this, "1:有效，0:禁止登录");

    /**
     * Create a <code>shrio.sys_user</code> table reference
     */
    public SysUser() {
        this(DSL.name("sys_user"), null);
    }

    /**
     * Create an aliased <code>shrio.sys_user</code> table reference
     */
    public SysUser(String alias) {
        this(DSL.name(alias), SYS_USER);
    }

    /**
     * Create an aliased <code>shrio.sys_user</code> table reference
     */
    public SysUser(Name alias) {
        this(alias, SYS_USER);
    }

    private SysUser(Name alias, Table<SysUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysUser(Name alias, Table<SysUserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Shrio.SHRIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SYS_USER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysUserRecord> getPrimaryKey() {
        return Keys.KEY_SYS_USER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysUserRecord>> getKeys() {
        return Arrays.<UniqueKey<SysUserRecord>>asList(Keys.KEY_SYS_USER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUser as(String alias) {
        return new SysUser(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUser as(Name alias) {
        return new SysUser(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysUser rename(String name) {
        return new SysUser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysUser rename(Name name) {
        return new SysUser(name, null);
    }
}
