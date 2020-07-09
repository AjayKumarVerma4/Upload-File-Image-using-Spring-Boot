package com.ajay.utils;

import java.io.File;

public class FileHelper {
	
	protected void creatDirectory(String path){


	    File directory = new File(path);

	    if (directory.exists()) {
	       
	    } else {
	       directory.mkdirs();
	    }

	}
	
	public boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("File exists, preparing to delete");
            boolean result = file.delete();
            // test if delete of file is success or not
            if (result) {
                System.out.println("File " + fileName + " deleted");
            } else {
                System.out.println("File was not deleted, unknown reason");
            }
            return result;
        } else {
            System.out.println("File delete failed, file does not exists");
            return false;
        }
    }


	public  boolean deleteDirectory(File dir) {
		System.out.println("isDirectory :: "+dir.isDirectory());
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            for (int i = 0; i < children.length; i++) {
            	System.out.println("Before delete :: "+dir.isDirectory());
                boolean success = deleteDirectory(children[i]);
                System.out.println("After delete :: "+dir.isDirectory());
                if (!success) {
                    return false;
                }
            }
        }

	   System.out.println("removing file or directory : " + dir.getName());
        return dir.delete();
    }

}
