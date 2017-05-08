package com.shu.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shu.dao.BaseDAO;

public class BaseDAOimpl implements BaseDAO{
	protected mySessionFactory sessionFactory = mySessionFactory.getInstance();

	 @Override
	    public void save(Object object) {
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        try {
	            session.saveOrUpdate(object);
	            tx.commit();
	        } catch (RuntimeException e) {
	            tx.rollback();
	            throw e;
	        } finally {
	            session.close();
	        }
	    }

	    @Override
	    public void delete(Object object) {
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        try {
	            session.delete(object);
	            tx.commit();
	        } catch (RuntimeException e) {
	            tx.rollback();
	            throw e;
	        } finally {
	            session.close();
	        }
	    }
    
}
