<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kim.model.Book"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kim.model.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>在线调查系统</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/frame.css">

<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bookinfo.js"></script>

</head>

<body>

	<%
		User user = (User) session.getAttribute("user");
	%>

	<div class="container-fluid">
		<div class="row top_bar">
			<div class="col-md-2">		
			</div>
			<div class="col-md-3">
				<a class="btn btn-default tbtn" href="showbooks.jsp" role="button">查看图书</a>
				<a class="btn btn-default tbtn" href="showcart.jsp" role="button">查看购物车</a>		
				<a class="btn btn-default tbtn" href="chatroom.jsp" role="button">聊天室</a>	
			</div>
			<div class="col-md-1">
				<a class="btn btn-default tbtn" href="ShowUser.action" role="button">管理</a>
			</div>
			<div class="col-md-4">		
			</div>
			<div class="col-lg-2">
				<div class="dropdown">
					<button type="button" class="btn dropdown-toggle btn-lg"
						id="dropdownMenu1" data-toggle="dropdown">
						欢迎:<%=user.getUsername()%>
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="LoginOut.action">退出登录</a></li>
					</ul>
				</div>
			</div>
		</div>

	</div>

	<div  id = "ccc" class="container-fluid">
		<div class="row">
			<div class="col-lg-2 left_side">			
			</div>
			<%
				@SuppressWarnings("unchecked")
				List<User> list = (List<User>) session.getAttribute("userlist");
				if (true) {
					if (list != null) {
			%>
			<div id="tab" class="col-lg-10">
				<h3>所有用户</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>用户id</th>
							<th>用户名</th>
							<th>密码</th>
						</tr>
					</thead>
					<tbody>
					<%
						for (int i = 0; i < list.size(); i++) {
					%>
						<tr>
							<th><h4><%=list.get(i).getId()%></h4></th>
							<th><h4><%=list.get(i).getUsername()%></h4></th>
							<th><h4><%=list.get(i).getPassword()%></h4></th>
							
						</tr>
					<%	} %>	
					</tbody>
					
				</table>
			</div>
			<%	} 
			}%>
		</div>
	</div>
	
	
	
</body>
</html>



