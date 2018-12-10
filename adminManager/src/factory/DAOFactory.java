package factory;

import dao.AdminDAO;
import util.ConfigUtil;

/**
 * ����ģʽ
 * @author Administrator
 *
 */
public class DAOFactory {
	//�������ʹ�������
	public static Object getInstance(String type){
		Object o = null;
		//����ConfigUtil�еķ�����ȡ���·��
		String className = ConfigUtil.getValue(type);
		//�������·������ʵ�����
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
