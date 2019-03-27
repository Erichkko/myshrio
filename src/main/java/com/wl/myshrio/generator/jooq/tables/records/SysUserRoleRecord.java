/*
 * This file is generated by jOOQ.
*/
package com.wl.myshrio.generator.jooq.tables.records;


import com.wl.myshrio.generator.jooq.tables.SysUserRole;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class SysUserRoleRecord extends UpdatableRecordImpl<SysUserRoleRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = -1552900754;

    /**
     * Setter for <code>shrio.sys_user_role.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>shrio.sys_user_role.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>shrio.sys_user_role.uid</code>. 用户ID
     */
    public void setUid(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>shrio.sys_user_role.uid</code>. 用户ID
     */
    public String getUid() {
        return (String) get(1);
    }

    /**
     * Setter for <code>shrio.sys_user_role.rid</code>. 角色ID
     */
    public void setRid(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>shrio.sys_user_role.rid</code>. 角色ID
     */
    public String getRid() {
        return (String) get(2);
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
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return SysUserRole.SYS_USER_ROLE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SysUserRole.SYS_USER_ROLE.UID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SysUserRole.SYS_USER_ROLE.RID;
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
        return getUid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getRid();
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
        return getUid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getRid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRoleRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRoleRecord value2(String value) {
        setUid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRoleRecord value3(String value) {
        setRid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRoleRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysUserRoleRecord
     */
    public SysUserRoleRecord() {
        super(SysUserRole.SYS_USER_ROLE);
    }

    /**
     * Create a detached, initialised SysUserRoleRecord
     */
    public SysUserRoleRecord(String id, String uid, String rid) {
        super(SysUserRole.SYS_USER_ROLE);

        set(0, id);
        set(1, uid);
        set(2, rid);
    }
}
