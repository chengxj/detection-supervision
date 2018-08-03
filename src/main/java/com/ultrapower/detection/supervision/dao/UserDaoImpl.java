package com.ultrapower.detection.supervision.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.ultrapower.detection.supervision.entity.User;

public class UserDaoImpl implements UserDaoCustom {
	
	@Autowired
    @PersistenceContext
    private EntityManager entityManager;

	public User getUserByUserName(String userName) {
		return (User) entityManager
				.createQuery("from User where userName=:userName")
				.setParameter("userName", userName)
				.getSingleResult();
	}

}
