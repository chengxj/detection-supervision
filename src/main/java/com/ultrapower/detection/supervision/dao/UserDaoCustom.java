package com.ultrapower.detection.supervision.dao;

import com.ultrapower.detection.supervision.entity.User;

public interface UserDaoCustom {
	
	/**
	 * 通过用户登录名查询用户信息
	 * @param userName 登录名
	 * @return 用户对象
	 */
	User getUserByUserName(String userName);

}
