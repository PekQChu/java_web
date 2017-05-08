package com.shu.tool;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;


public class FileHelper {
	private static String MainFolder="";

	public static void SaveFileToPath(MultipartFile file,
			HttpServletRequest request, String targetname)
	{

		String path = request.getSession().getServletContext().getRealPath("/upload");  
		File targetFile = new File(path, targetname);  
		if(!targetFile.exists()){  
			targetFile.mkdirs();  
		}  

		//保存  
		try {  
			file.transferTo(targetFile);  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
	}
	public static  File GetUploadedFile(HttpServletRequest request,String targetname)
	{
		String path = request.getSession().getServletContext().getRealPath("/upload");  
		File targetFile = new File(path, targetname);  
		return targetFile;

	}
	public static String SaveFileToPath(MultipartFile file,String name,
			HttpServletRequest request)
	{
		Date a=new Date();
		String savetime=TimeSw.convert(a,"yyyyMMddhhmmss");
		String fileName = file.getOriginalFilename();  
//		String path = String.format("%s_%s", savetime,fileName);
		SaveFileToPath(file,request,name);
		return name;

	}
	public static String SaveFileToPathexcel(MultipartFile file,
			HttpServletRequest request)
	{
		Date a=new Date();
		String savetime=TimeSw.convert(a,"yyyyMMddhhmmss");
		String fileName = file.getOriginalFilename();  
		String path = String.format("%s_%s", savetime,fileName);
		SaveFileToPath(file,request,path);
		return path;

	}
	

}
