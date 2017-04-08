$(function(){
	var cId=$("#cId").val();
	$.ajax({
		type:"post",
		url:"ordinary_checkName.action",
		data:{"cId":cId},
		dataType:'text',//文本类型还可以XMl，等其他数据格式
		beforeSend:function(){
			$("#mesg").html("在向服务器发送请求");
		},
		success:function(){
			
		},
		error:function(){
			
		}
		
	});
});