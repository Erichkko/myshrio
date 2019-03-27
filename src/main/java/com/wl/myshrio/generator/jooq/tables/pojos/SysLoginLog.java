/*
 * This file is generated by jOOQ.
*/
package com.wl.myshrio.generator.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Generated;


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
public class SysLoginLog implements Serializable {

    private static final long serialVersionUID = -2051369316;

    private String        id;
    private String        uid;
    private LocalDateTime logintime;
    private String        loginip;
    private Integer       logintotal;

    public SysLoginLog() {}

    public SysLoginLog(SysLoginLog value) {
        this.id = value.id;
        this.uid = value.uid;
        this.logintime = value.logintime;
        this.loginip = value.loginip;
        this.logintotal = value.logintotal;
    }

    public SysLoginLog(
        String        id,
        String        uid,
        LocalDateTime logintime,
        String        loginip,
        Integer       logintotal
    ) {
        this.id = id;
        this.uid = uid;
        this.logintime = logintime;
        this.loginip = loginip;
        this.logintotal = logintotal;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public LocalDateTime getLogintime() {
        return this.logintime;
    }

    public void setLogintime(LocalDateTime logintime) {
        this.logintime = logintime;
    }

    public String getLoginip() {
        return this.loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    public Integer getLogintotal() {
        return this.logintotal;
    }

    public void setLogintotal(Integer logintotal) {
        this.logintotal = logintotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SysLoginLog (");

        sb.append(id);
        sb.append(", ").append(uid);
        sb.append(", ").append(logintime);
        sb.append(", ").append(loginip);
        sb.append(", ").append(logintotal);

        sb.append(")");
        return sb.toString();
    }
}