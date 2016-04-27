<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kim.model.Book"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kim.model.User"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>提示信息</title>
<link rel="stylesheet" type="text/css" href="images/styles.css">
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
						@SuppressWarnings("unchecked")
						List<User> list = (List<User>) session.getAttribute("userlist");
						if (true) {
							if (list != null) {
					%>

					<form action="AddToCart" method="post">
						<table border=1>
							<caption>查询结果</caption>
							<tr>
								<th>用户id</th>
								<th>用户名</th>
								<th>密码</th>
			
							<tr>
								<%
									for (int i = 0; i < list.size(); i++) {
								%>
							
							<tr height=70>
								<td><h1><%=list.get(i).getId()%></h1></td>
								<td><h1><%=list.get(i).getUsername()%></h1></td>
								<td><h1><%=list.get(i).getPassword()%></h1></td>

							</tr>
							<%
								}
							%>
						</table>
					</form>
					<%
							}
						} 
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
