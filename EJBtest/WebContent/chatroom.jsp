<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min"  type="text/javascript"></script>
<script src="js/chat.js" type="text/javascript"></script>

</head>
<body>

	<div id="showMsg" style="border: 1px solid; width: 500px; height: 400px; overflow: auto;"></div>
	<form role="form">
		<div class="form-group">
			<input type="text" id="msg" class="form-control"/> 
			<input type="button" id="sendButton" class="form-control" value="发送" />
		</div>
	</form>
	
</body>
</html>
