package com.emily.test;

import org.junit.Assert;
import org.junit.Test;

import com.emily.entity.Users;
import com.emily.service.impl.UsersDAOImpl;
import com.emliy.service.UsersDAO;

public class TestUsersDao {


	@Test
	public void test() {
		Users user = new Users(1, "zhangsan", "123");
		UsersDAO usersDAO = new UsersDAOImpl();
//		boolean s = usersDAO.usersLogin(user);
//		System.out.println(s);
		Assert.assertEquals(true, usersDAO.usersLogin(user));
	}

}
