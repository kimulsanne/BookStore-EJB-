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
						List<Book> list = (List<Book>) session.getAttribute("booklist");
						System.out.println("jsP "+list.size());
						if (true) {
							if (list != null) {
					%>

					<form action="AddToCart" method="post">
						<table border=1>
							<caption>查询结果</caption>
							<tr>
								<th>图书名</th>
								<th>作者</th>
								<th>分类</th>
								<th>价格</th>
								<th>数量</th>
								<th>购物车</th>
			
							<tr>
								<%
									for (int i = 0; i < list.size(); i++) {
								%>
							
							<tr height=70>
								<td><h1><%=list.get(i).getName()%></h1></td>
								<td><h1><%=list.get(i).getWriter()%></h1></td>
								<td><h1><%=list.get(i).getCategory()%></h1></td>
								<td><h1><%=list.get(i).getPrice()%></h1></td>
								<td><h1><%=list.get(i).getQuantity()%></h1></td>
								<td colspan="1"><a
									href="bookamount.jsp?id=<%=list.get(i).getId()%>&name=<%=list.get(i).getName()%>">加购物车</a>
								</td>
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
