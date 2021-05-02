package com.genericcodes;

import java.io.FileInputStream;
import java.util.Properties;

public class DataUtils implements AutoConstants {

	public String getDataFromPropertiesFile(String key) throws Exception
	{
		FileInputStream fis=new FileInputStream(PROP_PATH);
		
		Properties pobj=new Properties();
		pobj.load(fis);
		
		return pobj.getProperty(key);
	}
}
