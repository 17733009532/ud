<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  		<c:forEach items="${requestScope.querall}" var="querall">
  		|${querall.id}--------
  		${querall.title}--------
  		${querall.imgpath}--------
  		${querall.status}------
  		${querall.cratetime}|
			<a href="${pageContext.request.contextPath}/carousel/download?url=${querall.imgpath}">下载</a><br/>
		</c:forEach>
		
  </body>
</html>
