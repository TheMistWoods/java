package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * ���ӳع�����
 * 1)���ļ�ȡ����
 * 2)��װ��ȡ���Ӻ͹黹���ӷ���
 * @author Administrator
 *
 */
public class DBCPUtil {
	//������������ĸ�����
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	//���ļ��Ķ���
	private static Properties ps=new Properties();
	//BasicDataSource��ȡ����
	private static BasicDataSource ds = null;
	
	//��̬�����,�����ʱִֻ��һ��
	static {
		try {
			//ͨ�����������ȡ���������ļ�
			ps.load(DBCPUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = ps.getProperty("mysql_driver");
			url = ps.getProperty("mysql_url");
			user = ps.getProperty("mysql_user");
			password = ps.getProperty("mysql_pwd");
			
			//���ӳ���ز���
			String initialSize = ps.getProperty("dataSource_initialSize");
			String maxActive = ps.getProperty("dataSource_maxActive");
			String maxIdle = ps.getProperty("dataSource_maxIdle");
			String minIdle = ps.getProperty("dataSource_minIdle");
			String maxWait = ps.getProperty("dataSource_maxWait");
			
			//��������
			ds = new BasicDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(password);
			
			if(initialSize!=null) {
				ds.setInitialSize(Integer.parseInt(initialSize));
			}
			if(maxActive!=null) {
				ds.setMaxActive(Integer.parseInt(maxActive));
			}
			if(maxIdle!=null) {
				ds.setMaxIdle(Integer.parseInt(maxIdle));
			}
			if(minIdle!=null) {
				ds.setMinIdle(Integer.parseInt(minIdle));
			}
			if(maxWait!=null) {
				ds.setMaxWait(Long.parseLong(maxWait));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//��װ���ӷ���
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		if(ds!=null) {
			con = ds.getConnection();
		}
		return con;
	}
	//��װ�黹����
	public static void releaseConnection(Connection con,
			Statement st,ResultSet rs) throws SQLException {
		
		if(rs!=null) {
			rs.close();
		}
		if(st!=null) {
			st.close();
		}
		if(con!=null) {
			con.close();//�黹����
		}
	}
	
	//����
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}
