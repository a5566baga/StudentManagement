package com.emily.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import com.emily.db.MyHibernateSessionFactory;
import com.emily.entity.Users;
import com.emily.service.impl.UsersDAOImpl;
import com.emliy.service.UsersDAO;

public class TestUsersDao {


	@Test
	public void test() {
		Users user = new Users(1,"ss","123");
		UsersDAO usersDao = new UsersDAOImpl();
//		usersDAO.usersLogin(user);
//		System.out.println(s);
		Assert.assertEquals(true, usersDao.usersLogin(user));
	}
	
	@Test
	public void test2(){
		Transaction transaction = null;
		Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		Users user = new Users();
		user.setUsername("ss");
		user.setPassword("123");
		transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
	}

}
