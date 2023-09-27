package com.WebDriverUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	/**
	 * This method is used to get the data from property file
	 * @throws IOException 
	 * 
	 */
	public String getPropertyKeyValues(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IPathconstants.ppath);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	/**
	 * This method is used to write the data into property file
	 * @throws IOException 
	 * 
	 */
	public void writePropertyKeyValue(String key,String value) throws IOException
	{
		Properties p = new Properties();
		p.setProperty(key, value);
		
		FileOutputStream fos = new FileOutputStream(IPathconstants.ppath);
		p.store(fos, "write data");
		fos.close();
	}

}
