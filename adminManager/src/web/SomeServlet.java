package web;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import entity.Admin;
import factory.DAOFactory;

public class SomeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//设置相应的编码格式
		res.setContentType("text/html;charset=utf-8");
		//获取请求资源路径
		String uri = req.getRequestURI();
		PrintWriter out = res.getWriter();
		//截取->/list /add ...
		String action = uri.substring(
				uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		AdminDAO dao = (AdminDAO)DAOFactory.getInstance("AdminDAO");
		if("/list".equals(action)){
			//处理/list请求-查询
			try {
				List<Admin> ads = dao.findAll();
				//2.将ads中的数据丢给list.jsp
				//2.1将数据绑定到req中
				req.setAttribute("list", ads);
				//2.2转发到list.jsp(转发器)
				req.getRequestDispatcher("list.jsp").forward(req, res);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/add".equals(action)){
			//接收数据
			String uname = req.getParameter("username");
			String pwd = req.getParameter("password");
			String realname = req.getParameter("realname");
			//将页面内容传入库
			try {
				dao.add(new Admin(uname,pwd,realname));
				//重定向
				res.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if("/del".equals(action)){
			//处理del
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				dao.del(id);
				res.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/load".equals(action)){
			//处理load
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				Admin a = dao.findById(id);
				if(a!=null){
					out.print("<form action='update.do' method='post' >");
					out.print("<input type='hidden' name='id' value='"+id+"' /> ");
					out.print("昵称:<input type='text' name='uname' value='"+a.getUname()+"' /><br>" +
							  "密码:<input type='password' name='pwd' value='"+a.getPassword()+"' /><br>" +
							  "真名:<input type='text' name='realname' value='"+a.getRealname()+"' /><br>" +
							  "<input type='submit' value='更新' /></form>");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/update".equals(action)){
			//接收传入的值
			int id = Integer.parseInt(req.getParameter("id"));
			String uname = req.getParameter("uname");
			String pwd = req.getParameter("pwd");
			String realname = req.getParameter("realname");
			Admin a = new Admin(id,uname,pwd,realname);
			
			res.sendRedirect("list.do");
			try {
				dao.update(a);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		out.close();
	}
}
