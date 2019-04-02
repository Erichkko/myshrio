package com.wl.myshrio.model.dto;


/**
 * @desc: 角色权限vo
 * 
 * @author: jwy
 * @date: 2018/1/4
 */
public class RolePermisVo {

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 菜单ids
     */
    private String[] permiIds;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String[] getPermiIds() {
        return permiIds;
    }

    public void setPermiIds(String[] permiIds) {
        this.permiIds = permiIds;
    }
}
