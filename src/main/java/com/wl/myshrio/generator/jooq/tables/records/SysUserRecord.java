/*
 * This file is generated by jOOQ.
*/
package com.wl.myshrio.generator.jooq.tables.records;


import com.wl.myshrio.generator.jooq.tables.SysUser;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


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
public class SysUserRecord extends UpdatableRecordImpl<SysUserRecord> implements Record8<String, String, String, String, String, LocalDateTime, LocalDateTime, Long> {

    private static final long serialVersionUID = -350009064;

    /**
     * Setter for <code>shrio.sys_user.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>shrio.sys_user.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>shrio.sys_user.head_portraits</code>. 头像
     */
    public void setHeadPortraits(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>shrio.sys_user.head_portraits</code>. 头像
     */
    public String getHeadPortraits() {
        return (String) get(1);
    }

    /**
     * Setter for <code>shrio.sys_user.nickname</code>. 用户昵称
     */
    public void setNickname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>shrio.sys_user.nickname</code>. 用户昵称
     */
    public String getNickname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>shrio.sys_user.email</code>. 邮箱|登录帐号
     */
    public void setEmail(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>shrio.sys_user.email</code>. 邮箱|登录帐号
     */
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>shrio.sys_user.pswd</code>. 密码
     */
    public void setPswd(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>shrio.sys_user.pswd</code>. 密码
     */
    public String getPswd() {
        return (String) get(4);
    }

    /**
     * Setter for <code>shrio.sys_user.create_time</code>. 创建时间
     */
    public void setCreateTime(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>shrio.sys_user.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>shrio.sys_user.last_login_time</code>. 最后登录时间
     */
    public void setLastLoginTime(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>shrio.sys_user.last_login_time</code>. 最后登录时间
     */
    public LocalDateTime getLastLoginTime() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>shrio.sys_user.status</code>. 1:有效，0:禁止登录
     */
    public void setStatus(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>shrio.sys_user.status</code>. 1:有效，0:禁止登录
     */
    public Long getStatus() {
        return (Long) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<String, String, String, String, String, LocalDateTime, LocalDateTime, Long> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<String, String, String, String, String, LocalDateTime, LocalDateTime, Long> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return SysUser.SYS_USER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SysUser.SYS_USER.HEAD_PORTRAITS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SysUser.SYS_USER.NICKNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return SysUser.SYS_USER.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return SysUser.SYS_USER.PSWD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field6() {
        return SysUser.SYS_USER.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field7() {
        return SysUser.SYS_USER.LAST_LOGIN_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return SysUser.SYS_USER.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getHeadPortraits();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getNickname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getPswd();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component6() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component7() {
        return getLastLoginTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component8() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getHeadPortraits();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getNickname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getPswd();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value6() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value7() {
        return getLastLoginTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value2(String value) {
        setHeadPortraits(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value3(String value) {
        setNickname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value4(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value5(String value) {
        setPswd(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value6(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value7(LocalDateTime value) {
        setLastLoginTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value8(Long value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord values(String value1, String value2, String value3, String value4, String value5, LocalDateTime value6, LocalDateTime value7, Long value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysUserRecord
     */
    public SysUserRecord() {
        super(SysUser.SYS_USER);
    }

    /**
     * Create a detached, initialised SysUserRecord
     */
    public SysUserRecord(String id, String headPortraits, String nickname, String email, String pswd, LocalDateTime createTime, LocalDateTime lastLoginTime, Long status) {
        super(SysUser.SYS_USER);

        set(0, id);
        set(1, headPortraits);
        set(2, nickname);
        set(3, email);
        set(4, pswd);
        set(5, createTime);
        set(6, lastLoginTime);
        set(7, status);
    }
}
