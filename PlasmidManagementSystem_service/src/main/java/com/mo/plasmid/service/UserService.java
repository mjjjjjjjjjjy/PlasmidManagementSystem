package com.mo.plasmid.service;

import java.util.List;

import com.mo.plasmid.domain.User;

public interface UserService {

	List<User> findByUserCode(String user_code);

	void save(User user);

}
