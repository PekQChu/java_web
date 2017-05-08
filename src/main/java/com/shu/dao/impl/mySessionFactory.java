package com.shu.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class mySessionFactory {
	private  SessionFactory sessionFactory;
	private static mySessionFactory Instance=null;
	
	private mySessionFactory()
	{
		Configuration cfg = new AnnotationConfiguration().configure();  
		sessionFactory = cfg.buildSessionFactory();
	}
	public static mySessionFactory getInstance()
	{
		if(Instance==null)
		{
			Instance =new mySessionFactory();
		}
		return Instance;
	}
	
	public Session openSession()
	{
		return sessionFactory.openSession();
	}
}
