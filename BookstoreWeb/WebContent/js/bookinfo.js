$(document).ready(function() {
	$(".infobtn").click(function() {
		var params = "id=" + this.id;
		var btn = this;
		$.ajax(
		{	
			url:'GetBook.action',
			type:'post',
			data:params,
			success:function(data){
				var d = JSON.parse(data);
				alert(data);
				showinfo(btn, d);
					
	        },
			error:function(){
				alert("error");
	        },	
	        dataType:'json',
	        contentType: "application/x-www-form-urlencoded; charset=utf-8"
		})	

	})
})

function showinfo(btn, data){
	
	$(".info").remove();
		var ques = 
			'<div class="info">'+
			'<p>书名:' +data.name+ '</p>'+
			'<p>作者:' +data.writer+ '</p>'+
			'<p>价格:' +data.price+ '</p>'+
			'<p>库存:' +data.quantity+ '</p>'+
			'</div>';
	$("#" + btn.id).append(ques);
	//btn.after(ques);
	
}
