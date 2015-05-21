package com.tarena.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

public class UploadUtil {
	
	public static String uploadFile(File some, String someFileName){
		String dir_path = ServletActionContext
				.getServletContext().getRealPath("/upload");
			String[] strings = someFileName.split("\\.");
			String timeStampName = new Date().getTime()+"."+strings[strings.length-1];
			String file_path = dir_path+File.separatorChar+timeStampName;
			System.out.println("文件保存路径: "+file_path);
			//读取some内容写入file_path
			try{
				FileInputStream fis = new FileInputStream(some);
				FileOutputStream fos = new FileOutputStream(
						new File(file_path));
				byte[] bb = new byte[1024];
				int len = -1;
				while((len=fis.read(bb))!= -1){
					fos.write(bb,0,len);
				}
				fis.close();
				fos.close();
				return timeStampName;//ok.jsp
			}catch(Exception ex){
				ex.printStackTrace();
				return "error";
			}
	}
	
	public static String uploadFile(File some){
		String dir_path = ServletActionContext
				.getServletContext().getRealPath("/upload");
		String file_path = dir_path+File.separatorChar+new Date().getTime();
		System.out.println("文件保存路径: "+file_path);
		//读取some内容写入file_path
		try{
			FileInputStream fis = new FileInputStream(some);
			FileOutputStream fos = new FileOutputStream(
					new File(file_path));
			byte[] bb = new byte[1024];
			int len = -1;
			while((len=fis.read(bb))!= -1){
				fos.write(bb,0,len);
			}
			fis.close();
			fos.close();
			return "success";//ok.jsp
		}catch(Exception ex){
			ex.printStackTrace();
			return "error";
		}
	}

}
