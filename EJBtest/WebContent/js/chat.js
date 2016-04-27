$(function(){
	var socket =null;
	function parseObj(strData){//转换对象
	    return (new Function( "return " + strData ))();
	};
	//创建socket对象
	socket = new WebSocket("ws://localhost:8088/EJBtest/game");
	//连接创建后调用

	socket.onopen = function() {
		$("#showMsg").append("连接成功...<br/>");
	};
	//接收到服务器消息后调用
	socket.onmessage = function(message) {
		var data=parseObj(message.data);
		if(data.type=="message"){
			$("#showMsg").append("<span style='display:block'>"+data.text+"</span>");
		}else if(data.type=="background"){
			$("#showMsg").append("<span style='display:block'>系统改变背景地址,背景地址是:"+data.text+"</span>");
			$("body").css("background","url("+data.text+")");
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
		socket.send($("#msg").val());
	});
});