package com.ajay.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

public class Fileupload extends FileHelper {

		public static final String codeFilePath = "/home/ajay/Desktop/UploadedFile";

		public String getFilePath()
		{
	      	creatDirectory(codeFilePath);
	     	return codeFilePath;
			
		}
		 
	  
		  public String getFilePath(String path) { 
			  creatDirectory(codeFilePath+path);
		  return codeFilePath+path;
		  
		  }

		
			public boolean uploadImage(MultipartFile file,String dirname){		
			InputStream inputStream = null;
			OutputStream outputStream = null;	
			boolean check=false;
			try {
			if (file.getSize() > 0) {
			inputStream = file.getInputStream();
	 		outputStream = new FileOutputStream(dirname);
	 		System.out.println(file.getOriginalFilename());
			int readBytes = 0;
			byte[] buffer = new byte[8192];
			while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
			
			outputStream.write(buffer, 0, readBytes);
			}
			outputStream.close();
			inputStream.close();
			
			check =  true;
	  
			}
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
				check =  false;
			}
			
			return check;
			
		}
			
			
			public void uploadImage(byte[] btDataFile,String dirname){		
				InputStream inputStream = null;
				OutputStream outputStream = null;		
				try {
					File file = new File(dirname);
					FileOutputStream osf = new FileOutputStream(file);
					osf.write(btDataFile);
					osf.flush();
				} catch (Exception e) { 
					e.printStackTrace();
				}
				
			}

}
