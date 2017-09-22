<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	个人中心
	<%
		String name = (String)request.getAttribute("name");
		String age = (String)request.getAttribute("age");
		String body = (String)request.getAttribute("body");
		out.println("姓名："+name);
		out.println("年纪："+age);
		out.println("爱好："+body);
	%>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/jhcd?useUnicode=true&characterEncoding=utf-8"
     user="root"  password=""/>
     <sql:query dataSource="${snapshot}" var="result">
		SELECT * from ez_type where pid = 2;
	 </sql:query>
	 <table border="1" width="100%">
		<tr>
		   <th>ID</th>
		   <th>站点名</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
			   <td><c:out value="${row.id}"/></td>
			   <td><c:out value="${row.title}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>