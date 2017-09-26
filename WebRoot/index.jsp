<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <c:choose>
	  <c:when test="${not empty sessionScope.user}">
	  	 欢迎登录：${sessionScope.user}
	  </c:when>
	  <c:otherwise>
		  	你还没有登录！
	  <form action="<%=path %>/login" method="post">
		  	userName:<input type="text" name="userName"/><br>
		  	password:<input type="password" name="password"/><br>
		  	<input type="submit" value="登录"/>
	  </form>
	</c:otherwise>
  </c:choose>
  </body>
</html>
