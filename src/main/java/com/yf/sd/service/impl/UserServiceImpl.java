package com.yf.sd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yf.sd.mapper.UserMapper;
import com.yf.sd.pojo.User;
import com.yf.sd.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public int register(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public int yz_username(User user) {
		return userMapper.yz_username(user);
	}

	@Override
	public int login(String username, String pwd) {
		return userMapper.login(username,pwd);
	}
}
