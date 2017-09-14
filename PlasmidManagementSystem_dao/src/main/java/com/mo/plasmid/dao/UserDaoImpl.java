package com.mo.plasmid.dao;

import java.util.List;

import com.mo.plasmid.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	/*
	 * 通过用户名进行查询
	 */
	@Override
	public List<User> findByUserCode(String user_code) {
		return (List<User>) this.getHibernateTemplate().find("from User where user_code=?", user_code);
	}

}
