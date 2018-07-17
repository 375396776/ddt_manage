<%@page import="java.util.Map"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<!-- 富民银行FORM隐藏表单 -->
<script type="text/javascript" src="${ctx}/js/jquery-1.8.2.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<form id="fmBankForm" style="display: none" action="${action}"  method="POST" target="_self">
		<c:forEach var="var" items="${root}">
			<textarea name="${var.key}" >${var.value}</textarea>
			<br>
		</c:forEach>
	</form>
	<script>
		$(document).ready(function() {
			$("#fmBankForm").submit();
		});
	</script>
</body>
</html>