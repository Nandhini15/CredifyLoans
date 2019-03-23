package com.loans.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesUtil {

	Properties prop;

	public ReadPropertiesUtil(String filePath) {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getValue(String key) {
		return prop.getProperty(key);
	}
}
