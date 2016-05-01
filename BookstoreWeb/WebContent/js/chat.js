$(function(){
	var socket = null;
	var username = "";
	function parseObj(strData){//转换对象
	    return (new Function( "return " + strData ))();
	};
	//创建socket对象
	socket = new WebSocket("ws://localhost:8088/BookstoreWeb/game");	

	//接收到服务器消息后调用
	socket.onmessage = function(message) {		
		var data=parseObj(message.data);		
		if(data.type=="chat"){			
			$("#textarea").append(data.name + ": " + data.msg + "\n");
		}else if(data.type=="join"){			 
			$("#textarea").append("欢迎: " + data.name + " \n");
		}
	};
	
	//关闭连接的时候调用
	socket.onclose = function(){
		alert("close");
	};
	//出错时调用
	socket.onerror = function() {
		alert("error");
	};
	
	$("#sendButton").click(function() {
		var joinMsg = {};
		joinMsg.type="chat";
		joinMsg.name=username;
		joinMsg.msg=$("#msg").val();
		var message=JSON.stringify(joinMsg);
		socket.send(message);
	});
	
	$("#joinButton").click(function() {
		$(this).attr("disabled", true);
		$("#sendButton").attr("disabled", false);
		username = $("#username").val();
		if (username == "") {
			alert("昵称不能为空!");
			
		} else {
			var joinMsg = {};
			joinMsg.type="join";
			joinMsg.name=username;
			var msg=JSON.stringify(joinMsg);
			socket.send(msg);	
		}
	});
});