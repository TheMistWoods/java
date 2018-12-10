package factory;

import dao.AdminDAO;
import util.ConfigUtil;

/**
 * 工厂模式
 * @author Administrator
 *
 */
public class DAOFactory {
	//根据类型创建对象
	public static Object getInstance(String type){
		Object o = null;
		//调用ConfigUtil中的方法获取类的路径
		String className = ConfigUtil.getValue(type);
		//根据类的路径创建实体对象
		try {
			o = Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return o;
	}
	public static void main(String[] args) {
		AdminDAO o = (AdminDAO)getInstance("AdminDAO");
		try {
			System.out.println(o.findAll().size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
