package com.olmysoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olmysoft.dao.UserMapper;
import com.olmysoft.entity.User;
import com.olmysoft.service.ILoginService;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUser() {
		return userMapper.getUser();
	}

}
