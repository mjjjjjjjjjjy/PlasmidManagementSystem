package com.mo.plasmid.dao;

import java.util.List;

import com.mo.plasmid.domain.User;

public interface UserDao extends BaseDao<User> {

	List<User> findByUserCode(String user_code);

}
