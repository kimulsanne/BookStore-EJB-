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
		String name = (String) request.getParameter("name");
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
	<div  id = "ccc" class="container-fluid">
		<div class="row">
			<div class="col-lg-2 left_side">			
			</div>
			<%
				@SuppressWarnings("unchecked")
				List<Book> list = (List<Book>) session.getAttribute("booklist");			
				if (true) {
					if (list != null) {
			%>
			<div id="tab" class="col-lg-10">
				<h3>所有图书</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>图书名称</th>
							<th>详细信息</th>
							<th>购物车</th>

						</tr>
					</thead>
					<tbody>
					<%
						for (int i = 0; i < list.size(); i++) {
						String s = "test(" + list.get(i).getId() + ")";
					%>
						<tr>
							<th><h4><%=list.get(i).getName()%></h4></th>
							<th>
								<h4><button class="btn btn-default infobtn" id="<%=list.get(i).getId()%>" >详细信息</button></h4>							

							</th>
							<th>
								<form action="AddToCart" method="post">
									<input type="hidden" name="bookname" value=<%=list.get(i).getName()%>>
									<input type="hidden" name="id" value=<%=list.get(i).getId()%>>
									<input type="text" class="form-control" style="width: 100px" id="amount" name="amount" placeholder="请输入数量">
									<input type="submit" class="btn btn-info btn-lg" value="加入购物车"/>
								</form>

							</th>
							
						</tr>
					<%	} %>	
					</tbody>
					
				</table>
			</div>
			<%	} 
			}%>
		</div>
	</div>
	
	<div class="modal fade" id="buy" tabindex="-1" role="dialog"
		aria-labelledby="buyLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="buyLabel">选择数量</h4>
				</div>
				<div class="modal-body">
					<form action="AddToCart" method="post" class="form-register">

						<div class="input-group form-group">
							<span class="glyphicon glyphicon-music"></span> 
							<input type="text" id="amount" name="amount" placeholder="请输入要购买的数量">
						</div>
						<br>
			
						<input type="hidden" name="id" value="1">
						<input class="btn btn-default" type="submit" >
						
					</form>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>

