package com.miniProject.utilsHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigMngr {
	public static String configFileName =System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config.properties";
	private static Map<String, Properties> configs = new HashMap<String, Properties>();
	private static void loadConfig(String name) {
		Properties prop = new Properties();
		try {
			InputStream inputStream = new FileInputStream(configFileName);
			prop.load(inputStream);
			inputStream.close();
		} catch (Exception e) {
			//Assert.fail(e.getMessage());
			return;
		}
		// put properties
				configs.put(name, prop);
	}
	
	public static Properties getConfig(String name) {
		// if not loaded then load config
		if (!configs.containsKey(name)) {
			loadConfig(name);
		}
		return configs.get(name);
	}

	public static String getProperty(String propertyName) {

		return getConfig(configFileName).getProperty(propertyName);
	}

	
}
