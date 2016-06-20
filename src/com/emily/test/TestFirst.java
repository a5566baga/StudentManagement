package com.emily.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;


public class TestFirst {

	//创建sessionFactory
	private SessionFactory sessionFactory;
	//创建Session
	private Session session;
	//创建SchemaExport
	private SchemaExport schemaExport;
	
	private Transaction transaction;
	
	
	@Test
	//测试建表
	public void test() {
		//创建配置对象
		Configuration configuration = new Configuration().configure();
		//创建服务注册对象
		sessionFactory = configuration.buildSessionFactory(
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}

}
