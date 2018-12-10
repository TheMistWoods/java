package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import dao.AdminDAO;
import entity.Admin;

/**
 * 实现类
 * @author Administrator
 *
 */
public class AdminDAOImpl implements AdminDAO {
	
	Connection con = null;
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void add(Admin a) throws Exception {
		//连接数据库
		con = DBUtil.getConnection();
		//创建语句对象
		String sql = "insert into admin values(null,?,?,?)";
		ps = con.prepareStatement(sql);
		//赋值
		ps.setString(1, a.getUname());
		ps.setString(2, a.getPassword());
		ps.setString(3, a.getRealname());
		//执行SQL语句
		int i = ps.executeUpdate();
		
		DBUtil.closeConnection(con, st, rs);
	}

	public void del(int id) throws Exception {
		//创建连接
		con = DBUtil.getConnection();
		//创建语句对象
		st = con.createStatement();
		//执行SQL
		String sql = "delete from admin where id="+id;
		int i = st.executeUpdate(sql);
		
		//关闭
		DBUtil.closeConnection(con, st, rs);

	}

	public List<Admin> findAll() throws Exception {
		//集合
		List<Admin> ads = new ArrayList<Admin>();
		//连接数据库
		con = DBUtil.getConnection();
		//写SQL
		String sql = "select * from admin";
		//执行
		st = con.createStatement();
		rs = st.executeQuery(sql);
		//处理结果集
		Admin ad = null;
		while(rs.next()){
			//封装对象
			ad = new Admin(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4)
			);
			//将封装后的对象添加到ads集合中
			ads.add(ad);
		}
		//关闭连接
		DBUtil.closeConnection(con, st, rs);
		return ads;
	}

	public Admin findById(int id) throws Exception {
		//创建连接
		con = DBUtil.getConnection();
		//创建语句对象
		st = con.createStatement();
		//执行SQL语句
		String sql = "select uname,pwd,realname from admin where id="+id;
		rs = st.executeQuery(sql);
		//处理结果集
		Admin ad = null;
		if(rs.next()){
			ad = new Admin(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3)
			);
			
		}
		//关闭
		DBUtil.closeConnection(con, st, rs);
		return ad;
	}

	public void update(Admin a) throws Exception {
		//创建连接
		con = DBUtil.getConnection();
		//创建语句对象
		String sql = "update admin set uname=?,pwd=?,realname=? where id=?";
		ps = con.prepareStatement(sql);
		//问号赋值
		ps.setString(1, a.getUname());
		ps.setString(2, a.getPassword());
		ps.setString(3, a.getRealname());
		ps.setInt(4, a.getId());
		//执行SQL
		int i = ps.executeUpdate();
		
		//关闭
		DBUtil.closeConnection(con, ps, rs);
	}

}
