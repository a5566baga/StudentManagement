package com.emily.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Assert;
import org.junit.Test;

import com.emily.entity.Students;
import com.emily.service.impl.StudentsDAOImpl;
import com.emliy.service.StudentsDAO;

public class TestStudent {
	// 创建sessionFactory
	private SessionFactory sessionFactory;
	// 创建Session
	private Session session;
	// 创建SchemaExport
	private SchemaExport schemaExport;

	private Transaction transaction;

	@Test
	public void test() {
		// 创建配置对象
		Configuration configuration = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}
	
	//添加测试数据
	@Test
	public void testSaveStudent(){
	// 创建配置对象
			Configuration configuration = new Configuration().configure();
			// 创建服务注册对象
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Students s1 = new Students("S0000001", "ben", "男", new Date(), "Chain");
			Students s2 = new Students("S0000002", "jack", "男", new Date(), "Chain");
			Students s3 = new Students("S0000003", "lose", "女", new Date(), "Chain");
			session.save(s1);
			session.save(s2);
			session.save(s3);
			
			transaction.commit();
			sessionFactory.close();
	}
	
	/*@Test
	//测试生成新的字符串
	public void testGetNewSid(){
		StudentsDAOImpl impl = new StudentsDAOImpl();
		System.out.println(impl.getNewSid());
	}
*/
	
	@Test
	//测试添加
	public void testAddNewStudents(){
		Students s = new Students(null, "youi", "男", new Date(), "no way");
		StudentsDAO sdao = new StudentsDAOImpl();
		Assert.assertEquals(true, sdao.addStudents(s));
	}
	
}
