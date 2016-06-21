package com.emily.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.emily.db.MyHibernateSessionFactory;
import com.emily.entity.Students;
import com.emliy.service.StudentsDAO;

//对于学生逻辑接口的实现
public class StudentsDAOImpl implements StudentsDAO {

	@Override
	// 查找所有学生
	public List<Students> queryAllStudents() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		List<Students> list = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			hql = "from Students";
			Query query = session.createQuery(hql);
			list = query.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.commit();
			return list;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	@Override
	// 查找单个学生信息
	public Students queryStudentsBySid(String sid) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Students s = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			s = (Students) session.get(Students.class, sid);
			transaction.commit();
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.commit();
			return s;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	@Override
	// 添加学生
	public boolean addStudents(Students s) {
		// TODO Auto-generated method stub
		s.setSid(getNewSid());
		Transaction transaction = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(s);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.commit();
			return false;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	@Override
	// 更新学生信息
	public boolean updateStudents(Students s) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(s);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.commit();
			return false;
		}
		finally {
			if(transaction != null){
				transaction = null;
			}
		}
	}

	@Override
	// 删除学生
	public boolean deleteStudents(String sid) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Students s = (Students) session.get(Students.class, sid);
			session.delete(s);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.commit();
			return false;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}

	}

	// 生成学生学号策略
	private String getNewSid() {
		Transaction transaction = null;
		String hql = "";
		String sid = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			hql = "select max(sid) from Students";
			Query query = session.createQuery(hql);
			sid = (String) query.uniqueResult();
			if (sid == null || "".equals(sid)) {
				sid = "S0000001";
			} else {
				// 拆开
				String temp = sid.substring(1);
				int i = Integer.parseInt(temp);
				i++;
				// 还原
				temp = String.valueOf(i);
				int len = temp.length();
				// 凑成7位
				for (int j = 0; j < 7 - len; j++) {
					temp = "0" + temp;
				}
				sid = "S" + temp;
			}
			transaction.commit();
			return sid;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.commit();
			return null;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

}
