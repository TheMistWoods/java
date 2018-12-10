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
		//���ñ����ʽ
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		//��ȡ����·��
		String uri = req.getRequestURI();
		String action = uri.substring(
				uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		AdminDAO dao = (AdminDAO)DAOFactory.getInstance("AdminDAO");
		//�ж�
		if("/del".equals(action)){
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				dao.del(id);
				//�ض���
				res.sendRedirect("list.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/add".equals(action)){
			//����ҳ����������
			String uname = req.getParameter("uname");
			String realname = req.getParameter("realname");
			String pwd = req.getParameter("password");
			//����Admin����,
			Admin a = new Admin(uname,pwd,realname);
			//���������add
			try {
				dao.add(a);
				//�ض���
				res.sendRedirect("list.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/update".equals(action)){
			//����ҳ���������
			int id = Integer.parseInt(req.getParameter("id"));
			String uname = req.getParameter("uname");
			String realname = req.getParameter("realname");
			String pwd = req.getParameter("password");
			//�������󲢸�ֵ
			Admin a = new Admin(id,uname,pwd,realname);
			try {
				dao.update(a);
				//�ض���
				res.sendRedirect("list.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
