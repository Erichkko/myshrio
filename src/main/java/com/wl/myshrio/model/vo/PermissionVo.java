package com.wl.myshrio.model.vo;



public class PermissionVo  {


	private String id;
    /**
     * url描述
     */
	private String name;
    /**
     * url地址
     */
	private String url;

    /**
     * 类型：页面、按钮
     */
	private String typeName;

	/**
	 * 上级菜单
	 */
	private String lastPermis;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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



	public String getLastPermis() {
		return lastPermis;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setLastPermis(String lastPermis) {
		this.lastPermis = lastPermis;
	}
}
