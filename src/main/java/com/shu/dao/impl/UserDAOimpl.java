package com.shu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.shu.dao.UserDAO;
import com.shu.model.User;

@Transactional    //事务管理
@Repository("UserDAO")  //用于标注数据库的访问组件
public class UserDAOimpl extends BaseDAOimpl implements UserDAO{


	@Override
    @SuppressWarnings("unchecked")
    public User findbyId(long id) {
        Session session = sessionFactory.openSession();
        try {
            String hql = "from User where id=:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            List<User> users = query.list();
            if (users.size() == 0) {
                return null;
            }
            return users.get(0);
        } finally {
            session.close();
        }
    }

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		try {
			String hql="from User order by id desc";
			Query query = session.createQuery(hql);
            @SuppressWarnings("unchecked")
            List<User> users = query.list();
            if (users.size() == 0) {
                //用户不存在
                return null;
            }
            return users;
		} finally {
			// TODO: handle finally clause
			 session.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked") //用于抑制编译器产生警告信息
	public User findbyphone(String phone) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
	    try {
	    	String hql = "from User where phone=:phone";
	    	System.out.println(hql);
            Query query = session.createQuery(hql);
            query.setParameter("phone", phone);
            List<User> users = query.list();
            if (users.size() == 0) {
            	System.out.println("查询为空");
                return null;
            }
            return users.get(0);
	     } finally {
		// TODO: handle finally clause
	    	 
	    	 session.close();
	    }
	}

}
