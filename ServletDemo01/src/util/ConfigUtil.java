package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	private static Properties ps = new Properties();
	static{
		//获取类加载器
		ClassLoader loader = ConfigUtil.class.getClassLoader();
		InputStream is = loader.getResourceAsStream("config.properties");
		
		try {
			ps.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key){
		return ps.getProperty(key);
	}
	
	public static void main(String[] args) {
		System.out.println(getValue("EmpDAO"));
	}
}
