package com.yf.sd.service;

import java.util.List;

import com.yf.sd.pojo.User;


public interface UserService {
	//注册用户
	int register(User user);
	//验证用户名
	int yz_username(User user);
	//登录
	int login(String username,String pwd);

}
