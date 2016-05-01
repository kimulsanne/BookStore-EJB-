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
<script src="js/chat.js"></script>

</head>

<body>

	<%
		User user = (User) session.getAttribute("user");
		String name = user.getUsername();
		String id = (String) request.getParameter("id");
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
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 left_side">			
			</div>
			
			<div class="col-lg-5">
				<div id="user" class="<%=name%>"></div>
				<h3>聊天信息:</h3>
				<button type="submit" id="joinButton" class="btn btn-info">加入聊天室</button>	
				<textarea id="textarea" class="form-control" rows="20" ></textarea>
				<input type="text" class="form-control" id="msg" placeholder="请输入内容">		      						
    			<button type="submit" id="sendButton" class="btn btn-primary">发送</button>				
    		</div>
			<div class="col-lg-2">
    			<h3>用户列表:</h3>
    			<textarea id="userlist" class="form-control" rows="20" ></textarea>
			</div>
			<div class="col-lg-3">
			</div>
		</div>
	</div>
	
	
</body>
</html>

