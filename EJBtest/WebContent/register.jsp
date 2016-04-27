<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kim.model.User"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="images/styles.css">
<script>
	function check() {
		var x = document.getElementById("username").value;
		if (x == "") {
			alert("用户名不能为空!");
			return false;
		}
		x = document.getElementById("password").value;
		if (x == "") {
			alert("密码不能为空!");
			return false;
		}
		x = document.getElementById("repassword").value;
		if (x == "") {
			alert("确认密码不能为空!");
			return false;
		}
		x = document.getElementById("mail").value;
		if (x == "") {
			alert("邮箱不能为空!");
			return false;
		}
	}
</script>
</head>

<body>
	<div align="center">
		<div class="div1">
			<div class="top"></div>
			<div class="bottom">
				<div class="div2">
					<ul>
						<li><a href="register.jsp">用户注册</a></li>
						<li><a href="login.jsp">用户登录</a></li>
						<li><a href="ShowBook.action">查找图书</a></li>
						<li><a href="showcart.jsp">查看购物车</a></li>
						<li><a href="ShowUser.action">管理</a>
					</ul>
				</div>
				<div class="div3">
					<%
						User user = (User) session.getAttribute("user");
						if (user == null || user.getUsername().equals("admin")) {
					%>
					<h2>用户注册</h2>
					<form action="Register" method="post" onSubmit="return check(this);">
						<table align="center" width="300" border="0" class="tb1">
							<tr>
								<td align="right">用户名：</td>
								<td><input type="text" id="username" name="user.username"></td>
							</tr>
							<tr>
								<td align="right">密 码：</td>
								<td><input type="password" id="password"name="user.password"></td>
							</tr>
							<tr>
								<td align="right">确 认 密 码：</td>
								<td><input type="password" id="repassword" name="repassword"></td>
							</tr>

							<tr>
								<td align="right">邮 箱：</td>
								<td><input type="text" id="mail" name="user.mail"></td>
							</tr>
							<tr>
								<td colspan="2" align="center" height="50"><input
									type="submit" value="注 册"> <input type="reset"
									value="重 置"></td>
							</tr>
						</table>
						<%
							} else {
								out.println("<br><h1>您已经登录！<h1>");
							}
						%>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
