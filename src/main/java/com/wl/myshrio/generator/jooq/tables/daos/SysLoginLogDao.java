/*
 * This file is generated by jOOQ.
*/
package com.wl.myshrio.generator.jooq.tables.daos;


import com.wl.myshrio.generator.jooq.tables.SysLoginLog;
import com.wl.myshrio.generator.jooq.tables.records.SysLoginLogRecord;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class SysLoginLogDao extends DAOImpl<SysLoginLogRecord, com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog, String> {

    /**
     * Create a new SysLoginLogDao without any configuration
     */
    public SysLoginLogDao() {
        super(SysLoginLog.SYS_LOGIN_LOG, com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog.class);
    }

    /**
     * Create a new SysLoginLogDao with an attached configuration
     */
    public SysLoginLogDao(Configuration configuration) {
        super(SysLoginLog.SYS_LOGIN_LOG, com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getId(com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog> fetchById(String... values) {
        return fetch(SysLoginLog.SYS_LOGIN_LOG.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog fetchOneById(String value) {
        return fetchOne(SysLoginLog.SYS_LOGIN_LOG.ID, value);
    }

    /**
     * Fetch records that have <code>uid IN (values)</code>
     */
    public List<com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog> fetchByUid(String... values) {
        return fetch(SysLoginLog.SYS_LOGIN_LOG.UID, values);
    }

    /**
     * Fetch records that have <code>loginTime IN (values)</code>
     */
    public List<com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog> fetchByLogintime(LocalDateTime... values) {
        return fetch(SysLoginLog.SYS_LOGIN_LOG.LOGINTIME, values);
    }

    /**
     * Fetch records that have <code>loginIP IN (values)</code>
     */
    public List<com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog> fetchByLoginip(String... values) {
        return fetch(SysLoginLog.SYS_LOGIN_LOG.LOGINIP, values);
    }

    /**
     * Fetch records that have <code>loginTotal IN (values)</code>
     */
    public List<com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog> fetchByLogintotal(Integer... values) {
        return fetch(SysLoginLog.SYS_LOGIN_LOG.LOGINTOTAL, values);
    }
}