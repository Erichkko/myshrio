/*
 * This file is generated by jOOQ.
*/
package com.wl.myshrio.generator.jooq.tables.records;


import com.wl.myshrio.generator.jooq.tables.SysRole;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class SysRoleRecord extends UpdatableRecordImpl<SysRoleRecord> implements Record4<String, String, String, Integer> {

    private static final long serialVersionUID = -148229541;

    /**
     * Setter for <code>shrio.sys_role.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>shrio.sys_role.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>shrio.sys_role.name</code>. 角色名称
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>shrio.sys_role.name</code>. 角色名称
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>shrio.sys_role.description</code>. 描述
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>shrio.sys_role.description</code>. 描述
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>shrio.sys_role.type</code>. 角色类型  002普通用户 001 超级管理员
     */
    public void setType(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>shrio.sys_role.type</code>. 角色类型  002普通用户 001 超级管理员
     */
    public Integer getType() {
        return (Integer) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return SysRole.SYS_ROLE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SysRole.SYS_ROLE.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SysRole.SYS_ROLE.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return SysRole.SYS_ROLE.TYPE;
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
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getType();
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
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRoleRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRoleRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRoleRecord value3(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRoleRecord value4(Integer value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRoleRecord values(String value1, String value2, String value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysRoleRecord
     */
    public SysRoleRecord() {
        super(SysRole.SYS_ROLE);
    }

    /**
     * Create a detached, initialised SysRoleRecord
     */
    public SysRoleRecord(String id, String name, String description, Integer type) {
        super(SysRole.SYS_ROLE);

        set(0, id);
        set(1, name);
        set(2, description);
        set(3, type);
    }
}
