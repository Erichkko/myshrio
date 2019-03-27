/*
 * This file is generated by jOOQ.
*/
package com.wl.myshrio.generator.jooq.tables;


import com.wl.myshrio.generator.jooq.Indexes;
import com.wl.myshrio.generator.jooq.Keys;
import com.wl.myshrio.generator.jooq.Shrio;
import com.wl.myshrio.generator.jooq.tables.records.SysAttributeRecord;

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
public class SysAttribute extends TableImpl<SysAttributeRecord> {

    private static final long serialVersionUID = -211409220;

    /**
     * The reference instance of <code>shrio.sys_attribute</code>
     */
    public static final SysAttribute SYS_ATTRIBUTE = new SysAttribute();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysAttributeRecord> getRecordType() {
        return SysAttributeRecord.class;
    }

    /**
     * The column <code>shrio.sys_attribute.id</code>.
     */
    public final TableField<SysAttributeRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * The column <code>shrio.sys_attribute.name</code>. 属性名称
     */
    public final TableField<SysAttributeRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(32), this, "属性名称");

    /**
     * Create a <code>shrio.sys_attribute</code> table reference
     */
    public SysAttribute() {
        this(DSL.name("sys_attribute"), null);
    }

    /**
     * Create an aliased <code>shrio.sys_attribute</code> table reference
     */
    public SysAttribute(String alias) {
        this(DSL.name(alias), SYS_ATTRIBUTE);
    }

    /**
     * Create an aliased <code>shrio.sys_attribute</code> table reference
     */
    public SysAttribute(Name alias) {
        this(alias, SYS_ATTRIBUTE);
    }

    private SysAttribute(Name alias, Table<SysAttributeRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysAttribute(Name alias, Table<SysAttributeRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.SYS_ATTRIBUTE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysAttributeRecord> getPrimaryKey() {
        return Keys.KEY_SYS_ATTRIBUTE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysAttributeRecord>> getKeys() {
        return Arrays.<UniqueKey<SysAttributeRecord>>asList(Keys.KEY_SYS_ATTRIBUTE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysAttribute as(String alias) {
        return new SysAttribute(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysAttribute as(Name alias) {
        return new SysAttribute(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysAttribute rename(String name) {
        return new SysAttribute(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysAttribute rename(Name name) {
        return new SysAttribute(name, null);
    }
}