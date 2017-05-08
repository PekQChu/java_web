package com.shu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shu.model.User;

@Controller
public class TestController {
	
    @RequestMapping("/test")
	public ModelAndView testajax(){
		return new ModelAndView("test/ajax");
	}
    
    @RequestMapping("/testHandler")
    public @ResponseBody User testHandler(
    		@RequestParam(value="phone",required=true)  String phone,
			@RequestParam(value="password",required=true)  String password,HttpSession session,
			HttpServletRequest  request){
    	        String receive="用户手机是"+phone+"  "+"用户密码是"+password;
    	        System.out.println(receive);
    	        User user=new User();
    	        user.setPhone(phone);
    	        user.setPassword(password);
    	        user.setEmail("394751513@qq.com");
    	        return user;
    		}
}
