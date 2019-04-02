package com.wl.myshrio.model.vo;


/**
 * @desc: 菜单vo
 * 
 * @author: jwy
 * @date: 2017/12/26
 */
public class PermisVo {

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 地址
     */
    private String url;

    /**
     * 菜单类型
     */
    private String type;

    /**
     * 父级菜单id
     */
    private String lastId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户id
     */
    private String userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getLastId() {
        return lastId;
    }

    public void setLastId(String lastId) {
        this.lastId = lastId;
    }
}
