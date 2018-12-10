package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	private static Properties ps = new Properties();
	static{
		//获取类加载器
		ClassLoader loader = ConfigUtil.class.getClassLoader();
		//读取文件
		InputStream is = loader.getResourceAsStream("config.properties");
		try {
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//根据key获取value,根据类型找到具体实现类的路径
	public static String getValue(String key){
		return ps.getProperty(key);
	}
	//测试
	/*public static void main(String[] args) {
		System.out.println(getValue("AdminDAO"));
	}*/
}
