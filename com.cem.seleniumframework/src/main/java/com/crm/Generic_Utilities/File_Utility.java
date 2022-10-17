package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this method is used to luanch the application
 * @param Key
 * @return
 * @throws Throwable
 * @author Raju
 *
 */
public class File_Utility {
	public String getPropertyKryValue(String Key) throws IOException {
		//FileInputStream filb=new FileInputStream("./common_Data.properties");
		FileInputStream filb=new FileInputStream(ipathConstant.PROPERTYFILE_PATH);
		Properties pro=new Properties();
		pro.load(filb);
		 String value = pro.getProperty(Key);
		 return value;
	}

}
