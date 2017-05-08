package com.shu.tool;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSw {
	public static String convert(Date mill)
	{
		return convert(mill,"yyyy-MM-dd");
	}
	public static String convert2(Date mill) {
		return convert(mill, "yyyy-MM-dd HH:mm:ss");
	}
	public static String convert1(Date mill)
	{
		return convert(mill,"yyyyMMddHHmmssSSS");
	}
	public static boolean istoday(Date mill)
	{
		if(convert(mill,"yyyy-MM-dd").equals(convert(new Date(),"yyyy-MM-dd")))
		return true;
		else
			return false;
	}
	public static String convert(Date mill,String format){
		String strs="";
		try {
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		strs=sdf.format(mill);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return strs;
		}
//	public static Date datoda(Date mill){
//		Date strs=null;
//		try {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		strs=sdf.format(mill);
//		} catch (Exception e) {
//		e.printStackTrace();
//		}
//		return strs;
//		}
	
}
