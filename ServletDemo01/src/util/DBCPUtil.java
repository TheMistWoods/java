package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 连接池工具类
 * 1)读文件取数据
 * 2)封装获取连接和归还连接方法
 * @author Administrator
 *
 */
public class DBCPUtil {
	//定义变量接收四个数据
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	//读文件的对象
	private static Properties ps=new Properties();
	//BasicDataSource获取连接
	private static BasicDataSource ds = null;
	
	//静态代码块,类加载时只执行一次
	static {
		try {
			//通过类加载器获取输入流读文件
			ps.load(DBCPUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = ps.getProperty("mysql_driver");
			url = ps.getProperty("mysql_url");
			user = ps.getProperty("mysql_user");
			password = ps.getProperty("mysql_pwd");
			
			//连接池相关参数
			String initialSize = ps.getProperty("dataSource_initialSize");
			String maxActive = ps.getProperty("dataSource_maxActive");
			String maxIdle = ps.getProperty("dataSource_maxIdle");
			String minIdle = ps.getProperty("dataSource_minIdle");
			String maxWait = ps.getProperty("dataSource_maxWait");
			
			//加载驱动
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
	//封装连接方法
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		if(ds!=null) {
			con = ds.getConnection();
		}
		return con;
	}
	//封装归还方法
	public static void releaseConnection(Connection con,
			Statement st,ResultSet rs) throws SQLException {
		
		if(rs!=null) {
			rs.close();
		}
		if(st!=null) {
			st.close();
		}
		if(con!=null) {
			con.close();//归还连接
		}
	}
	
	//测试
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}
