package com.iNetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
Properties pro;  //object for properties class 

public readConfig() {
	File src= new File ("./configurations//config.properties"); // location of properties file
	try {
		FileInputStream fis =new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
	}catch(Exception e) {
		System.out.println("Exception is "+e.getMessage());
	}
}
     

public String getApplicationURL() {
    	 String url=pro.getProperty("baseURL");
    			 return url;
     }


public String getUserName() {
	 String user=pro.getProperty("username");
			 return user;
}
public String getPassWord() {
	String pwd=pro.getProperty("password");
	return pwd;
}
public String getChromePath() {
	String cPath= pro.getProperty("chromepath");
	return cPath;
}

public String getfirefoxpath() {
	String fPath=pro.getProperty("firefoxpath");
	return fPath;
}
}
