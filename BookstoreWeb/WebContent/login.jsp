<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户登 录</title>
<link rel="stylesheet" type="text/css" href="images/styles.css">
<script>
	function login() {
		var x = document.getElementById("user").value;
		if (x == "") {
			alert("用户名不能为空!");
			return false;
		}
		x = document.getElementById("password").value;
		if (x == "") {
			alert("密码不能为空!");
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
 
					<h2>登 录</h2>
					<form action="Login" method="post" onSubmit="return login(this);">
						<table align="center" width="300" border="0" class="tb1">
							<tr>
								<td align="right">用户名：</td>
								<td><input id="username" type="text" 
									name="user.username"></td>
							</tr>
							<tr>
								<td align="right">密 码：</td>
								<td><input id="password" type="password"
									name="user.password"></td>
							</tr>
							<tr>
								<td colspan="2" align="center" height="50"><input
									type="submit" value="登 录"> <input type="reset"
									value="重 置"></td>
							</tr>
						</table>
						<%

						%>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
