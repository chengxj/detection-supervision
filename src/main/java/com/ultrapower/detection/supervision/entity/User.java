package com.ultrapower.detection.supervision.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	
	private long id;// 主键
	private String userName;// 登录名
	private String pwd;// 密码
	private String realName;// 用户姓名
	private String phone;// 手机号
	private String email;// 电子邮件
	private long deptID;// 部门ID
	private String position;// 职位
	private boolean isSuperUser;
	private boolean enabled;// 启用标识
	private Date createTime;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public String getRealName() {
		return realName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public long getDeptID() {
		return deptID;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setDeptID(long deptID) {
		this.deptID = deptID;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean isSuperUser() {
		return isSuperUser;
	}

	public void setSuperUser(boolean isSuperUser) {
		this.isSuperUser = isSuperUser;
	}

}
