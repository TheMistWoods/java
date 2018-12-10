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
		//������Ӧ�ı����ʽ
		res.setContentType("text/html;charset=utf-8");
		//��ȡ������Դ·��
		String uri = req.getRequestURI();
		PrintWriter out = res.getWriter();
		//��ȡ->/list /add ...
		String action = uri.substring(
				uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		AdminDAO dao = (AdminDAO)DAOFactory.getInstance("AdminDAO");
		if("/list".equals(action)){
			//����/list����-��ѯ
			try {
				List<Admin> ads = dao.findAll();
				//2.��ads�е����ݶ���list.jsp
				//2.1�����ݰ󶨵�req��
				req.setAttribute("list", ads);
				//2.2ת����list.jsp(ת����)
				req.getRequestDispatcher("list.jsp").forward(req, res);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/add".equals(action)){
			//��������
			String uname = req.getParameter("username");
			String pwd = req.getParameter("password");
			String realname = req.getParameter("realname");
			//��ҳ�����ݴ����
			try {
				dao.add(new Admin(uname,pwd,realname));
				//�ض���
				res.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if("/del".equals(action)){
			//����del
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				dao.del(id);
				res.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/load".equals(action)){
			//����load
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				Admin a = dao.findById(id);
				if(a!=null){
					out.print("<form action='update.do' method='post' >");
					out.print("<input type='hidden' name='id' value='"+id+"' /> ");
					out.print("�ǳ�:<input type='text' name='uname' value='"+a.getUname()+"' /><br>" +
							  "����:<input type='password' name='pwd' value='"+a.getPassword()+"' /><br>" +
							  "����:<input type='text' name='realname' value='"+a.getRealname()+"' /><br>" +
							  "<input type='submit' value='����' /></form>");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/update".equals(action)){
			//���մ����ֵ
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
