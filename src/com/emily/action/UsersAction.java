package com.emily.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

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
		//在session中保存成功的用户
		session.setAttribute("loginUserName", user.getUsername());
		UsersDAO userDao = new UsersDAOImpl();
		if(userDao.usersLogin(user)){
			return "login_success";
		}else {
			return "login_failure";
		}
	}
	@Override
	//表单验证
	public void validate() {
		// TODO Auto-generated method stub
		//用户名不能为空
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError", "用户名不能为空!");
		}
		//密码不能少于6位
		if(user.getPassword().length() < 6){
			this.addFieldError("passwordError", "密码不能少于6位!");
		}
	}
	
	@SkipValidation
	public String logout(){
		if(session.getAttribute("loginUserName") != null){
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	

	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
