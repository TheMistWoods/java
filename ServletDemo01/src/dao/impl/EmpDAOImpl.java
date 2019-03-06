package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBCPUtil;

import dao.EmpDAO;
import entity.Emp;

public class EmpDAOImpl implements EmpDAO{
	
	Connection con = null;
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;

	public List<Emp> findAll() throws Exception {
		
		sql = "select e.*,d.dname from emp e join dept d on e.deptno=d.deptno";
		con = DBCPUtil.getConnection();//创建数据库连接
		st = con.createStatement();//创建语句对象
		rs = st.executeQuery(sql);//创建结果集
		
		List<Emp> emps = new ArrayList<Emp>();//创建数据集合
		Emp emp = null;
		while(rs.next()){//循环获取数据
			emp = new Emp(
					rs.getInt(1),
					rs.getString(2),
					rs.getDouble(3),
					rs.getString(5)
			);
			emps.add(emp);//添加到集合中
		}
		//归还连接
		DBCPUtil.releaseConnection(con, st, rs);
		return emps;
	}

	public Emp findByEmpno(int empno) throws Exception {
		
		sql = "select * from emp where empno="+empno;
		con = DBCPUtil.getConnection();
		st = con.createStatement();
		rs = st.executeQuery(sql);
		
		Emp emp = null;
		if(rs.next()){
			emp = new Emp(
					rs.getInt(1),
					rs.getString(2),
					rs.getDouble(3),
					rs.getInt(4)
			);
		}
		DBCPUtil.releaseConnection(con, st, rs);
		return emp;
	}

	public void update(Emp emp) throws Exception {
		
		sql = "update emp set ename=?,salary=?,deptno=? where empno=?";
		con = DBCPUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, emp.getEname());
		ps.setDouble(2, emp.getSalary());
		ps.setInt(3, emp.getDeptno());
		ps.setInt(4, emp.getEmpno());
		
		int i = ps.executeUpdate();
		
		DBCPUtil.releaseConnection(con, ps, rs);
		
	}

	public void save(Emp emp) throws Exception {
		
		sql = "insert into emp values(null,?,?,?)";
		con = DBCPUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, emp.getEname());
		ps.setDouble(2, emp.getSalary());
		ps.setInt(3, emp.getDeptno());
		
		int i = ps.executeUpdate();
		
		DBCPUtil.releaseConnection(con, ps, rs);
		
	}

	public void delete(int empno) throws Exception {
		
		sql = "delete from emp where empno="+empno;
		con = DBCPUtil.getConnection();
		st = con.createStatement();
		int i = st.executeUpdate(sql);
		
		DBCPUtil.releaseConnection(con, st, rs);
		
	}

}
