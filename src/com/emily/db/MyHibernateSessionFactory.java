package com.emily.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {

	//创建静态工厂	
	private static SessionFactory sessionFactory;
	
	//私有化构造方法
	private MyHibernateSessionFactory(){}
	
	//静态方法，保证唯一对象
	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null){
		// 创建配置对象
			Configuration configuration = new Configuration().configure();
			// 创建服务注册对象
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//			sessionFactory.openSession();
			return sessionFactory;
		}else{
			return sessionFactory;
		}
	}
	
}
