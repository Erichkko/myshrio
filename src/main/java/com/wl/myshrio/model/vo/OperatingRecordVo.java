package com.wl.myshrio.model.vo;


import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author jwy
 * @since 2018-01-11
 */
public class OperatingRecordVo {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 请求的url
     */
	private String requestUrl;
    /**
     * 远程的ip地址
     */
	private String remoteAddr;
    /**
     * 请求参数
     */
	private String params;
    /**
     * 请示方式
     */
	private String method;
	private Date createTime;
    /**
     * 用户id
     */
    private String uid;
    /**
     * 标识
     */
    private String flag;

	/**
	 * 用户名称
	 */
	private String userName;

    /**
     * 菜单名称
     */
    private String permName;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

	public static final String ID = "id";

	public static final String REQUESTURL = "requestUrl";

	public static final String REMOTEADDR = "remoteAddr";

	public static final String PARAMS = "params";

	public static final String METHOD = "method";

	public static final String CREATE_TIME = "create_time";

    public static final String UID = "uid";

	public static final String FLAG = "flag";



	@Override
	public String toString() {
		return "OperatingRecord{" +
			"id=" + id +
			", requestUrl=" + requestUrl +
			", remoteAddr=" + remoteAddr +
			", params=" + params +
			", method=" + method +
			", createTime=" + createTime +
                ", uid=" + uid +
                ", flag=" + flag +
			"}";
	}
}
