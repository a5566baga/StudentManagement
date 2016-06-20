package com.emliy.service;

import com.emily.entity.Users;

//创建用户的逻辑接口
public interface UsersDAO {
	//判断是否登录成功
	public boolean usersLogin(Users user);
	
}
