package com.yf.sd.mapper;

import java.util.List;

import com.yf.sd.pojo.User;

public interface UserMapper {
	int addUser(User user);

	int yz_username(User user);

	int login(String username,String pwd);
}
