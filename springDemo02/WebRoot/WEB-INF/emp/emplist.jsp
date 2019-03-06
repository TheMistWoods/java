<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>员工列表</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
	
</head>
<body>
	<div class="container">
		<table class="table table-striped table-bordered table-hover table-sm">
			<thead class="thead-dark">
				<tr>
					<th>员工号</th>
					<th>姓名</th>
					<th>薪水</th>
					<th>部门</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${emps}" var="emp">
				<tr>
					<td class="text-primary">${emp.empno}</td>
					<td>${emp.ename}</td>
					<td class="text-danger">${emp.salary}</td>
					<td>${emp.deptno}</td>
					<td>
						<a href="toUpdate.do?empno=${emp.empno}">修改</a>/
						<a href="delete.do?empno=${emp.empno}">删除</a>
					</td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
		
		<div align="center">
			<a href="toAdd.do"><button type="button" class="btn btn-ptimary">添加</button></a>
		</div>
		
	</div>
</body>
</html>