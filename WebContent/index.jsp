<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome jsp</title>
<style type="text/css">
	.header{
		height=100px;
		background-color: #fffedf;
		
	}
</style>

</head>
<body>
	<div class="header"></div>
	<div class="content">
	<table border="1">
		<c:forEach items="${lists}" var="classInfo">
			<tr>
				<td id="cId">${classInfo.getcId()}</td>
				<td>${classInfo.getcName()}</td>
				<td>${classInfo.getcDesc()}</td>
				<td><input type="button" value="修改"  id="modify"></td>
				<td><input type="button" value="删除" id="delete"></td>
			</tr>
		</c:forEach>
	</table> 
	</div>
<script src="js/jquery-3.1.1.min.js" />
<script src="js/index.js" />
</body>
</html>