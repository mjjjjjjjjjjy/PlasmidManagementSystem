<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">


</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="${pageContest.request.contextPath}/menu.jsp"></jsp:include>

<form action="${pageContext.request.contextPath}/dict_save.action" method="post">
	类型编号：<input name="dict_type_code" type="text"><br>
	类型名称：<input name="dict_type_name" type="text"><br>
	具体名字：<input name="dict_item_name" type="text"><br>
	<input type="submit" value="提交" size="3">
</form>
输入数据参考：001：构建人；002：入库人；003：载体类型。
<br>
<br>
<a href="${pageContext.request.contextPath}/dict_findAll.action">查询所有</a>
<br>
<br>
<table border='1'>
		<tr>
			<td>ID</td>
			<td>类型编号</td>
			<td>类型名称</td>
			<td>具体名字</td>
		</tr>
	<s:iterator value="findAll" id="dict">
		<tr>			
			<td><s:property value="#dict.dict_id"></s:property></td>
			<td><s:property value="#dict.dict_type_code"></s:property></td>
			<td><s:property value="#dict.dict_type_name"></s:property></td>
			<td><s:property value="#dict.dict_item_name"></s:property></td>
		</tr>
	</s:iterator>

</table>

</body>
</html>