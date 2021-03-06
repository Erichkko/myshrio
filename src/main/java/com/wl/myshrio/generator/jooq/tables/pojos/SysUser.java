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
public class SysUser implements Serializable {

    private static final long serialVersionUID = -1932109270;

    private String        id;
    private String        headPortraits;
    private String        nickname;
    private String        email;
    private String        pswd;
    private LocalDateTime createTime;
    private LocalDateTime lastLoginTime;
    private Long          status;

    public SysUser() {}

    public SysUser(SysUser value) {
        this.id = value.id;
        this.headPortraits = value.headPortraits;
        this.nickname = value.nickname;
        this.email = value.email;
        this.pswd = value.pswd;
        this.createTime = value.createTime;
        this.lastLoginTime = value.lastLoginTime;
        this.status = value.status;
    }

    public SysUser(
        String        id,
        String        headPortraits,
        String        nickname,
        String        email,
        String        pswd,
        LocalDateTime createTime,
        LocalDateTime lastLoginTime,
        Long          status
    ) {
        this.id = id;
        this.headPortraits = headPortraits;
        this.nickname = nickname;
        this.email = email;
        this.pswd = pswd;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.status = status;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadPortraits() {
        return this.headPortraits;
    }

    public void setHeadPortraits(String headPortraits) {
        this.headPortraits = headPortraits;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return this.pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastLoginTime() {
        return this.lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getStatus() {
        return this.status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SysUser (");

        sb.append(id);
        sb.append(", ").append(headPortraits);
        sb.append(", ").append(nickname);
        sb.append(", ").append(email);
        sb.append(", ").append(pswd);
        sb.append(", ").append(createTime);
        sb.append(", ").append(lastLoginTime);
        sb.append(", ").append(status);

        sb.append(")");
        return sb.toString();
    }
}
