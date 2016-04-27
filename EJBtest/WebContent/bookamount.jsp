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
<script>
	function check() {
		var x = document.getElementById("amount").value;
		if (x == "" || isNaN(x)) {
			alert("数量为空或者不是数字!");
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
						String name = (String) request.getParameter("name");
						String id = (String) request.getParameter("id");
						if (true) {
							
					%>
					<form action="AddToCart" method="post" onSubmit="return check(this);">
						<h2>购买图书的名称:<%=name%></h2>
						<h2>请输入要购买的数量:</h2>
						<input type="hidden" name="bookname" value=<%=name%>>
						<input type="hidden" name="id" value=<%=id%>>
						<input type="text" id="amount" name="amount">
						<input type="submit" value="添 加">					
					</form>
					<%
						
						}  
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
