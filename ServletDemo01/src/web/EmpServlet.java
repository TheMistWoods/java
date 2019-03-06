package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;
import entity.Emp;
import factory.DAOFactory;

public class EmpServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("text/html;charset=utf-8");
		
		//获取请求资源路径
		String uri = req.getRequestURI();
		String action = uri.substring(
						uri.lastIndexOf("/"), 
						uri.lastIndexOf("."));
		//通过工厂获取DAO
		EmpDAO empDAO = (EmpDAO)DAOFactory.getInstance("EmpDAO");
		
		//判断请求资源
		if("/list".equals(action)){
			
			try {
				
				List<Emp> emps = empDAO.findAll();
				
				//绑定到request
				req.setAttribute("emps", emps);
				//转发到list
				req.getRequestDispatcher("list.jsp").forward(req, res);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/load".equals(action)){
			//接收empno
			int id = Integer.parseInt(req.getParameter("empno"));
			try {
				Emp emp = empDAO.findByEmpno(id);
				
				req.setAttribute("emp", emp);
				req.getRequestDispatcher("update.jsp").forward(req, res);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/update".equals(action)){
			
			int empno = Integer.parseInt(req.getParameter("empno"));
			String ename = req.getParameter("ename");
			double salary = Double.parseDouble(req.getParameter("salary"));
			int deptno = Integer.parseInt(req.getParameter("deptno"));
			
			Emp emp = new Emp();
			emp.setEmpno(empno);
			emp.setEname(ename);
			emp.setSalary(salary);
			emp.setDeptno(deptno);
			
			try {
				empDAO.update(emp);
				res.sendRedirect("list.do");//重定向到list
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("/delete".equals(action)){
			int empno = Integer.parseInt(req.getParameter("empno"));
			try {
				empDAO.delete(empno);
				res.sendRedirect("list.do");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("/add".equals(action)){
			
			String ename = req.getParameter("ename");
			double salary = Double.parseDouble(req.getParameter("salary"));
			int deptno = Integer.parseInt(req.getParameter("deptno"));
			
			Emp emp = new Emp();
			emp.setEname(ename);
			emp.setSalary(salary);
			emp.setDeptno(deptno);
			
			try {
				empDAO.save(emp);
				res.sendRedirect("list.do");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
