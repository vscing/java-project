<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<form action="./login.do" method="post">
 		<input type="text" name="name" value="">
 		<input type="text" name="age" value="">
 		<input type="checkbox" name="boy" value="吃饭" />1 
        <input type="checkbox" name="boy" value="睡觉" />2  
        <input type="checkbox" name="boy" value="打代码" />3
 		<input type="submit" value="提交">
 	</form>
</body>
</html>