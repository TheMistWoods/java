package web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import entity.Admin;
import factory.DAOFactory;

public class WebServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		//获取请求路径
		String uri = req.getRequestURI();
		String action = uri.substring(
				uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		AdminDAO dao = (AdminDAO)DAOFactory.getInstance("AdminDAO");
		//判断
		if("/del".equals(action)){
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				dao.del(id);
				//重定向
				res.sendRedirect("list.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/add".equals(action)){
			//接收页面请求数据
			String uname = req.getParameter("uname");
			String realname = req.getParameter("realname");
			String pwd = req.getParameter("password");
			//创建Admin对象,
			Admin a = new Admin(uname,pwd,realname);
			//将对象加入add
			try {
				dao.add(a);
				//重定向
				res.sendRedirect("list.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/update".equals(action)){
			//接收页面请求参数
			int id = Integer.parseInt(req.getParameter("id"));
			String uname = req.getParameter("uname");
			String realname = req.getParameter("realname");
			String pwd = req.getParameter("password");
			//创建对象并赋值
			Admin a = new Admin(id,uname,pwd,realname);
			try {
				dao.update(a);
				//重定向
				res.sendRedirect("list.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
