<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Hello</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    
  </head>
  
  <body>
    <div class="container">
    	<form action="update.do" method="post">
    		<table class="table table-striped table-bordered table-hover table-sm">
    			<tr>
    				<td>员工号</td>
    				<td><input type="text" name="empno" value="${emp.empno}" readonly="readonly"/></td>
    			</tr>
    			<tr>
    				<td>姓名</td>
    				<td><input type="text" name="ename" value="${emp.ename}"/></td>
    			</tr>
    			<tr>
    				<td>薪水</td>
    				<td><input type="text" name="salary" value="${emp.salary}"/></td>
    			</tr>
    			<tr>
    				<td>部门号</td>
    				<td><input type="text" name="deptno" value="${emp.deptno}"/></td>
    			</tr>
    			<tr>
    				<td></td>
    				<td>
    					<input type="submit" value="保存" />
    				</td>
    			</tr>
    		
    		</table>
    	</form>
    </div>
  </body>
</html>
