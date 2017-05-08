package com.shu.tool;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class utility {
   public static String setpass(String pass)  
   {
	  
	   char [] p=pass.toCharArray();
	   int[] r=new int[p.length];
	   for(int i=0;i<p.length;i++)
	   {
		   r[i]=p[i]*2;
	   }
	  
	  System.out.println(r.toString());
	  String x="";
		for(int i=0;i<p.length;i++)
		{
			x=x+"a"+String.valueOf(r[i]);
		}
	  return x;
   }
	public static boolean EmptyString(String str)
	{
		return null==str||"".equals(str.trim());
	}
//	public static User GeuCurUser(HttpSession session)
//	{
//		Object cur_userobj=session.getAttribute(User.CUR_USER);
//		User cur_user=cur_userobj==null?null:(User)cur_userobj;
//		return cur_user;
//	}
	public static String[] Split(String str) {
		return str.split(",");
	}
//
//	public static boolean EmptyString(String str)
//	{
//		return null==str||"".equals(str.trim());
//	}
	//全局数组
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };



	// 返回形式为数字跟字符串
	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		// System.out.println("iRet="+iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	// 返回形式只为数字
	private static String byteToNum(byte bByte) {
		int iRet = bByte;
		System.out.println("iRet1=" + iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		return String.valueOf(iRet);
	}

	// 转换字节数组为16进制字串
	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}
	public static String Encrypt(String str)
	{
		return GetMD5Code(GetMD5Code(str));
	}
	public static String GetMD5Code(String strObj) {
		String resultString = null;
		try {
			resultString = new String(strObj);
			MessageDigest md = MessageDigest.getInstance("MD5");
			// md.digest() 该函数返回值为存放哈希值结果的byte数组
			resultString = byteToString(md.digest(strObj.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return resultString;
	}
	public static boolean isNumeric(String str){
		try {  
            int num=Integer.valueOf(str);//把字符串强制转换为数字  
            return true;//如果是数字，返回True  
        } catch (Exception e) {  
            return false;//如果抛出异常，返回False  
        }  
	}
	public static boolean isNumericDouble(String str){
		try {  
            double num=Double.valueOf(str);//把字符串强制转换为数字  
            return true;//如果是数字，返回True  
        } catch (Exception e) {  
            return false;//如果抛出异常，返回False  
        }  
	}
	public static String trimToNumber(String s) {  
	    int n = s.length();  
	    char[] a = new char[n];  
	    int len = 0;  
	    for (int i = 0; i < n; i++) {  
	        char ch = s.charAt(i);  
	        if (ch >= '0' && ch <= '9') {  
	            a[len++] = ch;  
	        }  
	    }  
	    return new String(a, 0, len);  
	} 
	public static List<String> del_repeat(List<String> str){
		List list = new ArrayList();
		for (int i=0; i<str.size();i++)
		if(!list.contains(str.get(i))) {
		list.add(str.get(i));
		}
		return list;
		
	}

}
