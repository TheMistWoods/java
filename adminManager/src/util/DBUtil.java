package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���ݿ⹤����
 * ��װ���Ӻ͹رշ���
 * @author Administrator
 *
 */
public class DBUtil {
	public static Connection getConnection() {
		Connection con = null;
		try {
			//ͨ��������Ƽ���������
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jsd1809";
			//���ݿ��ַ,�û���,����
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
	//����
	/*public static void main(String[] args) {
		System.out.println(getConnection());
	}*/
}
