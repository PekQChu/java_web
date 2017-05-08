package com.shu.dao;

import java.util.List;

import com.shu.model.User;

public interface UserDAO extends BaseDAO{
	    
	    User findbyphone(String phone); //登陆用的
	    
	    User findbyId(long id);

	    List<User> findAll();            //管理员用的 
}
