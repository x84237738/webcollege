package com.college.entity;

import java.io.Serializable;
public class OauthToken implements Serializable {

	//alias
	public static final String TABLE_ALIAS = "OauthToken";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USERID = "userId";
	public static final String ALIAS_TOKEN = "token";
	public static final String ALIAS_EXPIREDSECOND = "expiredSecond";
	public static final String ALIAS_EXPIREDTIME = "expiredTime";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_CREATETIME = "createTime";
	public static final String ALIAS_UPDATETIME = "updateTime";
	//maxId
	public static final String ALIAS_MAXID = "maxId";

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer userId;
	/**
	 * 
	 */
	private String token;
	/**
	 * 秒数
	 */
	private Integer expiredSecond;
	/**
	 * 过期时间
	 */
	private java.util.Date expiredTime;
	/**
	 * 0: 正常 1:删除
	 */
	private Boolean status;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 更新时间
	 */
	private java.util.Date updateTime;
	//maxId
	private Integer maxId;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer value) {
		this.userId = value;
	}
	public String getToken() {
		return this.token;
	}
	
	public void setToken(String value) {
		this.token = value;
	}
	public Integer getExpiredSecond() {
		return this.expiredSecond;
	}
	
	public void setExpiredSecond(Integer value) {
		this.expiredSecond = value;
	}
	public java.util.Date getExpiredTime() {
		return this.expiredTime;
	}
	
	public void setExpiredTime(java.util.Date value) {
		this.expiredTime = value;
	}
	public Boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(Boolean value) {
		this.status = value;
	}
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	
	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}

	public Integer getMaxId() {
		return maxId;
	}

	public void setMaxId(Integer maxId) {
		this.maxId = maxId;
	}
}