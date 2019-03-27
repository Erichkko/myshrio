/*
 * This file is generated by jOOQ.
*/
package com.wl.myshrio.generator.jooq.tables.records;


import com.wl.myshrio.generator.jooq.tables.SysOperatingRecord;

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
public class SysOperatingRecordRecord extends UpdatableRecordImpl<SysOperatingRecordRecord> implements Record8<String, String, String, String, String, LocalDateTime, String, String> {

    private static final long serialVersionUID = -760847929;

    /**
     * Setter for <code>shrio.sys_operating_record.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>shrio.sys_operating_record.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>shrio.sys_operating_record.requestUrl</code>. 请求的url
     */
    public void setRequesturl(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>shrio.sys_operating_record.requestUrl</code>. 请求的url
     */
    public String getRequesturl() {
        return (String) get(1);
    }

    /**
     * Setter for <code>shrio.sys_operating_record.remoteAddr</code>. 远程的ip地址
     */
    public void setRemoteaddr(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>shrio.sys_operating_record.remoteAddr</code>. 远程的ip地址
     */
    public String getRemoteaddr() {
        return (String) get(2);
    }

    /**
     * Setter for <code>shrio.sys_operating_record.params</code>. 请求参数
     */
    public void setParams(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>shrio.sys_operating_record.params</code>. 请求参数
     */
    public String getParams() {
        return (String) get(3);
    }

    /**
     * Setter for <code>shrio.sys_operating_record.method</code>. 请示方式
     */
    public void setMethod(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>shrio.sys_operating_record.method</code>. 请示方式
     */
    public String getMethod() {
        return (String) get(4);
    }

    /**
     * Setter for <code>shrio.sys_operating_record.create_time</code>.
     */
    public void setCreateTime(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>shrio.sys_operating_record.create_time</code>.
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>shrio.sys_operating_record.uid</code>. 用户id
     */
    public void setUid(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>shrio.sys_operating_record.uid</code>. 用户id
     */
    public String getUid() {
        return (String) get(6);
    }

    /**
     * Setter for <code>shrio.sys_operating_record.flag</code>. 标识
     */
    public void setFlag(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>shrio.sys_operating_record.flag</code>. 标识
     */
    public String getFlag() {
        return (String) get(7);
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
    public Row8<String, String, String, String, String, LocalDateTime, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<String, String, String, String, String, LocalDateTime, String, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return SysOperatingRecord.SYS_OPERATING_RECORD.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SysOperatingRecord.SYS_OPERATING_RECORD.REQUESTURL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SysOperatingRecord.SYS_OPERATING_RECORD.REMOTEADDR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return SysOperatingRecord.SYS_OPERATING_RECORD.PARAMS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return SysOperatingRecord.SYS_OPERATING_RECORD.METHOD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field6() {
        return SysOperatingRecord.SYS_OPERATING_RECORD.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return SysOperatingRecord.SYS_OPERATING_RECORD.UID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return SysOperatingRecord.SYS_OPERATING_RECORD.FLAG;
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
        return getRequesturl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getRemoteaddr();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getMethod();
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
    public String component7() {
        return getUid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getFlag();
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
        return getRequesturl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getRemoteaddr();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getMethod();
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
    public String value7() {
        return getUid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getFlag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysOperatingRecordRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysOperatingRecordRecord value2(String value) {
        setRequesturl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysOperatingRecordRecord value3(String value) {
        setRemoteaddr(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysOperatingRecordRecord value4(String value) {
        setParams(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysOperatingRecordRecord value5(String value) {
        setMethod(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysOperatingRecordRecord value6(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysOperatingRecordRecord value7(String value) {
        setUid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysOperatingRecordRecord value8(String value) {
        setFlag(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysOperatingRecordRecord values(String value1, String value2, String value3, String value4, String value5, LocalDateTime value6, String value7, String value8) {
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
     * Create a detached SysOperatingRecordRecord
     */
    public SysOperatingRecordRecord() {
        super(SysOperatingRecord.SYS_OPERATING_RECORD);
    }

    /**
     * Create a detached, initialised SysOperatingRecordRecord
     */
    public SysOperatingRecordRecord(String id, String requesturl, String remoteaddr, String params, String method, LocalDateTime createTime, String uid, String flag) {
        super(SysOperatingRecord.SYS_OPERATING_RECORD);

        set(0, id);
        set(1, requesturl);
        set(2, remoteaddr);
        set(3, params);
        set(4, method);
        set(5, createTime);
        set(6, uid);
        set(7, flag);
    }
}