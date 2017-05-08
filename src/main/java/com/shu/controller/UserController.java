package com.shu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shu.tool.NetResult;
import com.shu.dao.UserDAO;
import com.shu.dao.impl.UserDAOimpl;
import com.shu.model.User;

/*
 *   用户注册 登陆 注销 删除 管理等 
 *   chuchengE
 *   
 */
@Controller
public class UserController {
      private UserDAO userDAO;
      
      @RequestMapping(value = "/login", method = RequestMethod.GET)
      public ModelAndView loginView(){
    	  return new ModelAndView("login");
      }
      
      
      /*
       * 登陆处理 
       */
      @RequestMapping(value = "/loginHandler", method = {RequestMethod.POST,RequestMethod.GET})
      public @ResponseBody String loginHandler(
    		@RequestParam(value="phone1",required=true)  String phone,
    		@RequestParam(value="password1",required=true)  String password,
    		HttpServletRequest  request){
    	  System.out.println("用户的手机号码是："+phone);
    	  System.out.println("用户的密码是："+password);
    	    NetResult r=new NetResult();
    	    UserDAO u=new UserDAOimpl();
    	    User user=u.findbyphone(phone);
    	    if(user==null){
    	    	r.status=-1;
    	    	r.content="此账号不存在";
    	    	return "hello world";
    	    }else{
    	    	r.status=0;
    	    	r.content="success";
    	    	return "你好呀";
    	    }
    	    
      }
}
