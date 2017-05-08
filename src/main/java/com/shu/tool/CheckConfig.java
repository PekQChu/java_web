package com.shu.tool;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;



@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)  
@Target(java.lang.annotation.ElementType.METHOD)  
public @interface CheckConfig { 
	
	
	public static long UNCHECK_FIRST_INIT=0;
	public static long UNCHECK_PROFILE=1;
  
    /** 
     * 功能ID，该功能ID，对应数据库中的功能ID 
     * @return 
     * @version V1.0.0 
     * @date Jan 13, 2014 4:59:35 PM 
     */  
    long[] value() default {};  
      
}