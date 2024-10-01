package com.trello.qspiders.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * This Method is used to read the data from properties file.
	 * @param key
	 * @return String value
	 * @throws IOException
	 */
	public String toReadData(String key) throws IOException  {
		FileInputStream fis=new FileInputStream("./src/test/resources/trellodata.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		 String value = pobj.getProperty(key);
		 
		return value;
	}
	

}
