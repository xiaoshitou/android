package com.example.download.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Environment;

public class FileUtil {

	public final  static String SDPATH  = Environment.getExternalStorageDirectory()+File.separator;
	
	public static File down2SD(String path,String name,InputStream is){
		File file = null;
		OutputStream os =null;
		
		try {
			createDir(path);
			file= createFile(path+name);
			os = new FileOutputStream(file);
			byte[] buffer = new byte[4*1024];
			while((is.read(buffer))!=-1){
				os.write(buffer);
			}
			os.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	
	
	public static boolean isFileExist(String filename){
		File file = new File(SDPATH+filename);
		return file.exists();
	}
	
	
	
	public static File createFile(String filename) throws IOException{
		File file = new File(SDPATH+filename);
		file.createNewFile();
		return file;
	} 
	public static File createDir(String path){
		File dir = new File(SDPATH+path);
		dir.mkdir();
		return dir;
	}
}
