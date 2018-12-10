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
 * ʵ����
 * @author Administrator
 *
 */
public class AdminDAOImpl implements AdminDAO {
	
	Connection con = null;
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void add(Admin a) throws Exception {
		//�������ݿ�
		con = DBUtil.getConnection();
		//����������
		String sql = "insert into admin values(null,?,?,?)";
		ps = con.prepareStatement(sql);
		//��ֵ
		ps.setString(1, a.getUname());
		ps.setString(2, a.getPassword());
		ps.setString(3, a.getRealname());
		//ִ��SQL���
		int i = ps.executeUpdate();
		
		DBUtil.closeConnection(con, st, rs);
	}

	public void del(int id) throws Exception {
		//��������
		con = DBUtil.getConnection();
		//����������
		st = con.createStatement();
		//ִ��SQL
		String sql = "delete from admin where id="+id;
		int i = st.executeUpdate(sql);
		
		//�ر�
		DBUtil.closeConnection(con, st, rs);

	}

	public List<Admin> findAll() throws Exception {
		//����
		List<Admin> ads = new ArrayList<Admin>();
		//�������ݿ�
		con = DBUtil.getConnection();
		//дSQL
		String sql = "select * from admin";
		//ִ��
		st = con.createStatement();
		rs = st.executeQuery(sql);
		//��������
		Admin ad = null;
		while(rs.next()){
			//��װ����
			ad = new Admin(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4)
			);
			//����װ��Ķ�����ӵ�ads������
			ads.add(ad);
		}
		//�ر�����
		DBUtil.closeConnection(con, st, rs);
		return ads;
	}

	public Admin findById(int id) throws Exception {
		//��������
		con = DBUtil.getConnection();
		//����������
		st = con.createStatement();
		//ִ��SQL���
		String sql = "select uname,pwd,realname from admin where id="+id;
		rs = st.executeQuery(sql);
		//��������
		Admin ad = null;
		if(rs.next()){
			ad = new Admin(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3)
			);
			
		}
		//�ر�
		DBUtil.closeConnection(con, st, rs);
		return ad;
	}

	public void update(Admin a) throws Exception {
		//��������
		con = DBUtil.getConnection();
		//����������
		String sql = "update admin set uname=?,pwd=?,realname=? where id=?";
		ps = con.prepareStatement(sql);
		//�ʺŸ�ֵ
		ps.setString(1, a.getUname());
		ps.setString(2, a.getPassword());
		ps.setString(3, a.getRealname());
		ps.setInt(4, a.getId());
		//ִ��SQL
		int i = ps.executeUpdate();
		
		//�ر�
		DBUtil.closeConnection(con, ps, rs);
	}

}
