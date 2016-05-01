<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<style type="text/css">
	body {
	  	background-repeat:no-repeat;
		background-image:url(images/background.jpg);
	}

</style>

</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="top_bar">
				<div class="col-md-1"></div>
				<div class="col-md-9">
				</div>
				<div class="col-md-2">
					<button class="btn btn-info btn-lg" data-toggle="modal"
						data-target="#reg">注册</button>
					<button class="btn btn-info btn-lg" data-toggle="modal"
						data-target="#log">登录</button>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="reg" tabindex="-1" role="dialog"
		aria-labelledby="regLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="regLabel">注册</h4>
				</div>
				<div class="modal-body">
					<form class="form-register" action="Register" method="post">
						<div class="input-group form-group">
							<span class="glyphicon glyphicon-user"></span> <input type="text"
								name="user.username" placeholder="请输入用户名">
						</div>						
						<div class="input-group form-group">
							<span class="glyphicon glyphicon-lock"></span> <input
								type="password" name="user.password" placeholder="请输入密码">
						</div>					
						<div class="input-group form-group">
							<span class="glyphicon glyphicon-envelope"></span> <input
								type="text" name="user.mail" placeholder="请输入邮箱">
						</div>
						<div class="input-group form-group">
							<span class="glyphicon glyphicon-music"></span> <input
								type="text" name="user.phone" placeholder="请输入电话">
						</div>
						<br>
						<button class="btn btn-primary" type="submit" id="regist">注册</button>
						<button class="btn btn-default" type="button" data-dismiss="modal">关闭</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="log" tabindex="-1" role="dialog"
		aria-labelledby="loginLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="loginLabel">登录</h4>
				</div>
				<div class="modal-body">
					<form class="form-login" action="Login" method="post">
						<div class="input-group form-group">
							<span class="glyphicon glyphicon-user"></span> <input type="text"
								name="user.username" placeholder="请输入用户名">
						</div>
						<br>
						<div class="input-group form-group">
							<span class="glyphicon glyphicon-lock"></span> <input
								type="password" name="user.password" placeholder="请输入密码">
						</div>
						<br>
						<button class="btn btn-primary" type="submit" id="login">登录</button>
						<button class="btn btn-default" type="button" data-dismiss="modal">关闭</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>











