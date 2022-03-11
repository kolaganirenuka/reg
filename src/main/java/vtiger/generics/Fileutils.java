package vtiger.generics;

import java.io.FileInputStream;
import java.util.Properties;



public class Fileutils {
	public String readdataprop(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IAutoconst.propfilepath);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	public String readdataprop(String path, String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IAutoconst.propfilepath);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
}
