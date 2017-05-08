package com.shu.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;







import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Config {
	//private static String base_url="http://10.1.130.202:8080/cpa";
	public static String SESSION_CUR_URL="base_url";
	private ConfigHaspMap config;
	public static Config instance=null;
	private  Config()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml"); 
		config=(ConfigHaspMap)ac.getBean("configbean"); 
	}



	private synchronized  static Config getInstance()
	{
		if(instance==null)
		{
			instance=new Config();
		}
		return instance;
	}

	public static String  GetValue(String key)
	{
		getInstance();
		return instance.config.get(key);
	}
	public static  int  GetInt(String key)
	{
		System.out.print("\n\n+++++++++++++++++++++");
		System.out.print("\n\n+++++++++++++++++++++");
		System.out.print("\n\n+++++++++++++++++++++");
		System.out.print(key);
		String value=GetValue(key);
		System.out.print("\n\n+++++++++++++++++++++");
		System.out.print(value);
		System.out.print("\n\n+++++++++++++++++++++");
		int ivalue=-1;
		try{
			ivalue= Integer.parseInt(value);;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ivalue;
	}

	public static  double  GetFloat(String key)
	{
		String value=GetValue(key);
		return Double.parseDouble(value);
	}

	public static  Date  GetTime(String key)
	{
		String value=GetValue(key);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd ");
		Date date=null;
		try {
			date = sdf.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
