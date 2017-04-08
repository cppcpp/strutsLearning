<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.URLDecoder"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path=request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css" />
<script type="text/javascript">
 	window.onload=function(){
 		var randomCode=document.getElementById("randomCode");			
 		randomCode.onclick=function(){
 			//加上时间戳：让服务器知道这是两次不同的请求
 			randomCode.src="randomCode.action?time="+new Date().getTime();
 		}
 	}
</script>
<%
String user="";
String name="";
String password="";
Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for(Cookie c:cookies){
		if(c.getName().equals("user")){
			//cookie解码
			user=URLDecoder.decode(c.getValue(),"utf-8");
			String[] strs=user.split(",");
			name=strs[0];
			password=strs[1];
			System.out.print("前台：name："+name+"password:"+password);
			return ;
		}
	}
}


%>
</head>
<body>
		<div class="main-content">
			<div class="login-content">
				<form action="login.action" method="post">
					<span>账号</span><input type="text" class="name" name="userName" value="<%=name%>" placeholder="请输入姓名" required/><br>
					<span>密码</span><input type="text" class="name" name="userPassword" value="<%=password%>" placeholder="请输入密码" required><br>
					<span class="code">验证码</span><input  type="text" name="userCode" class="name" placeholder="请输入验证码"><img src="randomCode.action" name="randomCode" alt="看不清，请点击" id="randomCode"><br>
					<div class="tip">${requestScope.loginRong} ${requestScope.CodeRong} </div>
					<div class="rem-pas"><input type="checkbox" name="remenber">记住密码  <a href="#">忘记密码</a></div>
					<input type="submit" value="提交"><br>
				</form>
			</div>
		</div>
		
	</body>
</html>