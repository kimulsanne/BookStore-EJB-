<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kim.service.CartService"%>
<%@ page import="com.kim.model.Book"%>
<%@ page import="com.kim.model.User"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>购物车</title>
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
			    		CartService cart=(CartService) session.getAttribute("cart");						
						User user = (User) session.getAttribute("user");
						List<Book> list = null;
						if (cart != null)
							list = cart.listCart();
			
						
						if (true) {
							if (list != null) {
					%>
					
					<form action="BuyBook" method="post">
						<table border=1>
							<caption>购物车</caption>
							<tr>
								<th>书名</th>
								<th>作者</th>
								<th>价格</th>
								<th>数量</th>
							<tr>
								<%
									for (int i = 0; i < list.size(); i++) {
								%>
							
							<tr height=70>								
								<td><h1><%=list.get(i).getName()%></h1></td>
								<td><h1><%=list.get(i).getWriter()%></h1></td>
								<td><h1><%=list.get(i).getPrice()%></h1></td>
								<td><h1><%=list.get(i).getQuantity()%></h1></td>

							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="6">
									<input type="submit" value="购买">			
									<input type="hidden" name="username" value=<%=user.getUsername()%>>						 
									<input type="hidden" name="action" value="buy">
								</td>
							</tr>
						</table>
					</form>
					<%					
					
							} else {
								out.println("<br><h1>购物车为空!<h1>");
							}
						}  
						
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
