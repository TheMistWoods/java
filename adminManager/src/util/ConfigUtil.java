package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	private static Properties ps = new Properties();
	static{
		//��ȡ�������
		ClassLoader loader = ConfigUtil.class.getClassLoader();
		//��ȡ�ļ�
		InputStream is = loader.getResourceAsStream("config.properties");
		try {
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//����key��ȡvalue,���������ҵ�����ʵ�����·��
	public static String getValue(String key){
		return ps.getProperty(key);
	}
	//����
	/*public static void main(String[] args) {
		System.out.println(getValue("AdminDAO"));
	}*/
}
