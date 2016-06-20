package com.emily.action;

import com.emily.entity.Users;
import com.emily.service.impl.UsersDAOImpl;
import com.emliy.service.UsersDAO;
import com.opensymphony.xwork2.ModelDriven;

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	
	//用户登录动作
	public String login(){
		UsersDAO userDao = new UsersDAOImpl();
		if(userDao.usersLogin(user)){
			return "login_success";
		}else {
			return "login_failure";
		}
	}
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
