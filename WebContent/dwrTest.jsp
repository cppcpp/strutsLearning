<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/engine.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/util.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/interface/DWRTest.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery-3.1.1.min.js'></script>
<script type="text/javascript">
    //此函数中可以调用java类的方法，除了java方法本身的参数外，还要将回调函数名作为参数传给java方法  
    function sayHello(name) {
        DWRTest.Hello(name, dwrHandler);
    }

    //这是dwr的一个回调函数，data参数即java方法getHello(String name)的返回值  
    function dwrHandler(data) {
        alert(data);
    }
    
    window.onload=function(){
    	var b=document.getElementById("button1");
        b.onclick=function(){
        	sayHello("PiperChan");
        }

    }
       
</script>
</head>
<body>
<input type="text" >
<input type="button" value="Hello" id="button1">
</body>
</html>