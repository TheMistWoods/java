package factory;

import util.ConfigUtil;
import dao.EmpDAO;

public class DAOFactory {
	public static Object getInstance(String type){
		Object o = null;
		String className = ConfigUtil.getValue(type);
		try {
			o = Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return o;
	}
	
	public static void main(String[] args) {
		EmpDAO o = (EmpDAO)getInstance("EmpDAO");
		System.out.println(o);
	}
}
