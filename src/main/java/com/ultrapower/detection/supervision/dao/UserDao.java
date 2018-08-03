package com.ultrapower.detection.supervision.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ultrapower.detection.supervision.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>, UserDaoCustom {

}
