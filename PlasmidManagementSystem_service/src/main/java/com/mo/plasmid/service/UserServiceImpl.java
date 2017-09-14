package com.mo.plasmid.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mo.plasmid.dao.UserDao;
import com.mo.plasmid.domain.User;
@Transactional
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> findByUserCode(String user_code) {
		return userDao.findByUserCode(user_code);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
		
	}
}
