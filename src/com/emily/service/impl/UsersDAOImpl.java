package com.emily.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.emily.db.MyHibernateSessionFactory;
import com.emily.entity.Users;
import com.emliy.service.UsersDAO;

public class UsersDAOImpl implements UsersDAO {

	@Override
	public boolean usersLogin(Users user) {
		Transaction transaction = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			hql = "from　Users u where username=? and password=?";
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			
			/*String sql = "select * from　Users where username = ? and password = ?";
			Query query2 = session.createSQLQuery(sql);
			query2.setParameter(0, "ss");
			query2.setParameter(1, "123");*/
			
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			List list = query.list();

			transaction.commit();//提交事务
			
			if(list.size() > 0){
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(transaction != null){
				transaction = null;
			}
		}
	}


}
