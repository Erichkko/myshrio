/*
 * This file is generated by jOOQ.
*/
package com.wl.myshrio.generator.jooq.tables;


import com.wl.myshrio.generator.jooq.Indexes;
import com.wl.myshrio.generator.jooq.Keys;
import com.wl.myshrio.generator.jooq.Shrio;
import com.wl.myshrio.generator.jooq.tables.records.SysOperatingRecordRecord;

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
public class SysOperatingRecord extends TableImpl<SysOperatingRecordRecord> {

    private static final long serialVersionUID = 521359059;

    /**
     * The reference instance of <code>shrio.sys_operating_record</code>
     */
    public static final SysOperatingRecord SYS_OPERATING_RECORD = new SysOperatingRecord();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysOperatingRecordRecord> getRecordType() {
        return SysOperatingRecordRecord.class;
    }

    /**
     * The column <code>shrio.sys_operating_record.id</code>.
     */
    public final TableField<SysOperatingRecordRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>shrio.sys_operating_record.requestUrl</code>. 请求的url
     */
    public final TableField<SysOperatingRecordRecord, String> REQUESTURL = createField("requestUrl", org.jooq.impl.SQLDataType.VARCHAR(255), this, "请求的url");

    /**
     * The column <code>shrio.sys_operating_record.remoteAddr</code>. 远程的ip地址
     */
    public final TableField<SysOperatingRecordRecord, String> REMOTEADDR = createField("remoteAddr", org.jooq.impl.SQLDataType.VARCHAR(255), this, "远程的ip地址");

    /**
     * The column <code>shrio.sys_operating_record.params</code>. 请求参数
     */
    public final TableField<SysOperatingRecordRecord, String> PARAMS = createField("params", org.jooq.impl.SQLDataType.VARCHAR(255), this, "请求参数");

    /**
     * The column <code>shrio.sys_operating_record.method</code>. 请示方式
     */
    public final TableField<SysOperatingRecordRecord, String> METHOD = createField("method", org.jooq.impl.SQLDataType.VARCHAR(255), this, "请示方式");

    /**
     * The column <code>shrio.sys_operating_record.create_time</code>.
     */
    public final TableField<SysOperatingRecordRecord, LocalDateTime> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>shrio.sys_operating_record.uid</code>. 用户id
     */
    public final TableField<SysOperatingRecordRecord, String> UID = createField("uid", org.jooq.impl.SQLDataType.VARCHAR(32), this, "用户id");

    /**
     * The column <code>shrio.sys_operating_record.flag</code>. 标识
     */
    public final TableField<SysOperatingRecordRecord, String> FLAG = createField("flag", org.jooq.impl.SQLDataType.VARCHAR(255), this, "标识");

    /**
     * Create a <code>shrio.sys_operating_record</code> table reference
     */
    public SysOperatingRecord() {
        this(DSL.name("sys_operating_record"), null);
    }

    /**
     * Create an aliased <code>shrio.sys_operating_record</code> table reference
     */
    public SysOperatingRecord(String alias) {
        this(DSL.name(alias), SYS_OPERATING_RECORD);
    }

    /**
     * Create an aliased <code>shrio.sys_operating_record</code> table reference
     */
    public SysOperatingRecord(Name alias) {
        this(alias, SYS_OPERATING_RECORD);
    }

    private SysOperatingRecord(Name alias, Table<SysOperatingRecordRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysOperatingRecord(Name alias, Table<SysOperatingRecordRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.SYS_OPERATING_RECORD_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysOperatingRecordRecord> getPrimaryKey() {
        return Keys.KEY_SYS_OPERATING_RECORD_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysOperatingRecordRecord>> getKeys() {
        return Arrays.<UniqueKey<SysOperatingRecordRecord>>asList(Keys.KEY_SYS_OPERATING_RECORD_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysOperatingRecord as(String alias) {
        return new SysOperatingRecord(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysOperatingRecord as(Name alias) {
        return new SysOperatingRecord(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysOperatingRecord rename(String name) {
        return new SysOperatingRecord(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysOperatingRecord rename(Name name) {
        return new SysOperatingRecord(name, null);
    }
}
