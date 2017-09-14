<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:debug/>
查询所有结果：
<br>
<br>
<table border="1"  >
<tr>
		<td>
			p_id
		</td>
		<td>
			p_plasmidNumber
		</td>
		<td>
			p_name
		</td>
		<td>
			p_vector
		</td>
		<td>
			p_constructor
		</td>
		<td>
			p_ruku
		</td>
		<td>
			p_date
		</td>
		<td>
			p_time
		</td>
		<td>
			p_description
		</td>
		<td>
			p_note
		</td>
		
	</tr> 
<s:iterator value="findAll" id="name">
	<tr>
		<td>
			<s:property value="#name.p_id"/><br>
		</td>
		<td>
			<s:property value="#name.p_plasmidNumber"/><br>
		</td>
		<td>
			<s:property value="#name.p_name"/><br>
		</td>
		<td>
			<s:property value="#name.vector.dict_item_name"/><br>
		</td>
		<td>
			<s:property value="#name.constructor.dict_item_name"/><br>
		</td>
		<td>
			<s:property value="#name.ruku.dict_item_name"/><br>
		</td>
		<td>
			<s:property value="#name.p_date"/><br>
		</td>
		<td>
			<s:property value="#name.p_time"/><br>
		</td>
		<td>
			<s:property value="#name.p_description"/><br>
		</td>
		<td>
			<s:property value="#name.p_note"/><br>
		</td>
		
	</tr> 
</s:iterator>
</table>
<s:debug/>
</body>
</html>