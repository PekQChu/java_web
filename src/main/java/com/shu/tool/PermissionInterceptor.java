package com.shu.tool;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.neo4j.cypher.internal.compiler.v2_1.docbuilders.internalDocBuilder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shu.model.User;

public class PermissionInterceptor extends HandlerInterceptorAdapter{
	public static ServletContext curcontext;
	
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView view) throws Exception {  
    	curcontext=request.getSession().getServletContext();
    	String contextPath = request.getContextPath();  
        if (view != null) {  
            request.setAttribute("base", contextPath);  
        }  
    }  
    
    boolean existsConfig(CheckConfig config,long v)
    {
    	if(config==null)
    	{
    		return false;
    	}
    	long[] configs=config.value();
    	for(int i=0;i<configs.length;i++)
    	{
    		if(configs[i]==v)
    		{
    			return true;
    		}
    	}
    	return false;
    }
    boolean checkConfig(CheckConfig config,HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	boolean status=true;
    	if(!existsConfig(config,CheckConfig.UNCHECK_FIRST_INIT))
    	{
    		if(checkFirstStart(request))
            {
            	response.sendRedirect(request.getContextPath()+"/setadmin");  
            	status=false;
    			;
            }
    	}
    	
    	if(!existsConfig(config,CheckConfig.UNCHECK_PROFILE))
    	{
    		;
    	}
    	return status;
    	
    	
    }
//    预处理
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  
    	HandlerMethod method = (HandlerMethod)handler;
    	CheckConfig chConfig=method.getMethodAnnotation(CheckConfig.class); 
    	
		
    	request.getSession(true).setAttribute(Config.SESSION_CUR_URL, Config.GetValue(Config.SESSION_CUR_URL));
    	//处理Permission Annotation，实现方法级权限控制  
       
        Permission permission = method.getMethodAnnotation(Permission.class);  
        ResponseBody responBody= method.getMethodAnnotation(ResponseBody.class); 
        //如果为空在表示该方法不需要进行权限验证  
        if (permission == null) {  
            return true;  
        }  
          
        //验证是否具有权限  
        if (!hasPower(request, permission.value())) { 
        	Object pemissionObj=request.getSession(true).getAttribute(User.CUR_USER);
        	if(pemissionObj==null)
        	{
        		 response.sendRedirect(request.getContextPath()+"/permissionerror_without_login");  
        	}
        	else
        	{
        		response.sendRedirect(request.getContextPath()+"/permissionerror");  
        	}
           
            return false;  
        }  
   
        
        return true;  
          
          
        //注意此处必须返回true，否则请求将停止  
        //return true;  
    	
    	
    	}
    	
    	
    
//		request.getSession(true).setAttribute("cartNum", num);
    	
//    	if(!checkConfig(chConfig,request,response))
//    	{
//    		return false;
//    	}

    
    
    public  String SESSION_FIRST="first_start";
    
	private boolean checkFirstStart(HttpServletRequest request) {
//		Object pemissionObj = request.getSession(true).getAttribute(SESSION_FIRST);
//		if (pemissionObj == null || Integer.parseInt(String.valueOf(pemissionObj)) == 0) {
		
//		}

		return false;
	}
    
	private boolean hasPower(HttpServletRequest request, long value) {
		Object pemissionObj = request.getSession(true).getAttribute(
				User.CUR_USER);
		if (null == pemissionObj
				|| (long) (((User) (pemissionObj)).getType()) < value) {
			return false;
		} else {
			return true;
		}

	}
}
