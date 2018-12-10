package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库工具类
 * 封装连接和关闭方法
 * @author Administrator
 *
 */
public class DBUtil {
	public static Connection getConnection() {
		Connection con = null;
		try {
			//通过反射机制加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jsd1809";
			//数据库地址,用户名,密码
			con = DriverManager.getConnection(url,"root","1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(Connection con,
			Statement st,ResultSet rs) throws SQLException{
		if(rs!=null){
			rs.close();
		}
		if(st!=null){
			st.close();
		}
		if(con!=null){
			con.close();
		}
	}
	//测试
	/*public static void main(String[] args) {
		System.out.println(getConnection());
	}*/
}
