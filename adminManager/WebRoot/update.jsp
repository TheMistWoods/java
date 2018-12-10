<%@ page language="java" import="java.util.*,entity.*,dao.*,util.*,factory.*" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="./css/userAdmin.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
</head>
<body>
		<div class="container_box">
		<div class="main_title">用户管理</div>
		<div  class="main_body">
			<div class="nav_title autoH color_909090">
				<label>用户管理</label><span class="jiantou"></span><label class="color_0e6fb6">修改信息</label>
			</div>
			<div class="shade_content">
				<form method="post" action="update.do" >	
				<%
					int id = Integer.parseInt(request.getParameter("id"));
					AdminDAO dao = (AdminDAO)DAOFactory.getInstance("AdminDAO");
					Admin a = dao.findById(id);
				%>
					<div>
						<label>ID:</label>
						<span>
							<input type="text" name="id" value="<%=id %>" readonly="readonly" />
						</span>
					</div>
					<div>
						<label>用户名:</label>
						<span>
							<input type="text" name="uname" value="<%=a.getUname() %>" />
						</span>
					</div>
					<div>
						<label>真实姓名:</label>
						<span>
							<input type="text" name="realname" value="<%=a.getRealname() %>" />
						</span>
					</div>
					<div>
						<label>密码:</label>
						<span>
							<input type="password" name="password" value="<%=a.getPassword() %>" />
						</span>
					</div>
					<div class="o_btns">
						<input class="save" type="submit" value="保存">
						<input class="cancel" type="button" value="取消">
					</div>
				</form>
			</div>
		</div>
		</div>

</div>
</div>				
</body>
</html>










