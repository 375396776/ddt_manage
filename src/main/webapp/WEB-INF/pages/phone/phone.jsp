<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.js"></script>
<title>我的手机壳</title>
</head>
<body>
	<form action="" method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td><input id="query" type="button" value="查询" /></td>
			</tr>
		</table>
		手机列表：
		<table width="100%" border=1>
			<tr>
				<td>序号</td>
				<td>手机型号</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${phone }" var="item">
				<tr>
					<td>${item.id }</td>
					<td>${item.phoneType }</td>
					<td><a
						href="${pageContext.request.contextPath }/item/editItem.action?id=${item.id}">修改</a></td>
				</tr>
			</c:forEach>

		</table>
	</form>
	<script type="text/javascript">
		$(function() {
			$('#query').click(function() {
				console.log(111);
				/* $.ajax({
					type : "post",
					url : "${pageContext.request.contextPath }/phone/getPhone_ajax.do",
					dataType:"json",      
		            contentType:"application/json", 
					data : '{"phone_type" : "iphone7"}',
					success : function(data) {
						console.log(data);
					}
				}); */
				$.ajax({
					type:'post',
					url:'${pageContext.request.contextPath }/phone/getPhone_ajax.do',
					contentType:'application/json;charset=utf-8',
					//数据格式是json串，商品信息
					data:'{"name":"手机","price":999}',
					success:function(data){//返回json结果
						console.log(data);
					}
					
				});
			});
		});
	</script>
</body>
</html>