<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页查询</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<SCRIPT language=javascript>

	// 提交分页的查询的表单
	 function to_page(pageCode){
		if(pageCode){
			$("#page").val(pageCode);
		}
		document.customerForm.submit();
	}
	
	//ajax的编写
	function dict_constructor(){
		// 发送ajax的请求
		var url = "${ pageContext.request.contextPath }/dict_findByCode.action";
		var param = {"dict_type_code":"001"};
		$.post(url,param,function(data){
			// 遍历
			$(data).each(function(i,n){
				// 先获取值栈中的值，使用EL表达式
				var vsId = "${constructor.dict_id}";
				// 值栈中的id值和遍历的id值相同，让被选中
				if(vsId == n.dict_id){
					// JQ的DOM操作
					$("#constructor").append("<option value='"+n.dict_id+"' selected>"+n.dict_item_name+"</option>");
				}else{
					$("#constructor").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
				}
			});
		},"json");
		
	}
	//为文本框赋值
	function textVal(){
			$("#p_plasmidNumber").val("${p_plasmidNumber}");
			$("#p_name").val("${p_name}");
	}
	//随页面自动启动
	$(function(){
		dict_constructor();
		textVal();
	});
	
</SCRIPT>
</head>
<body>
<s:debug/>

<jsp:include page="${pageContest.request.contextPath}/menu.jsp"></jsp:include>

查询结果如下：<br>
 <form id="customerForm" name="customerForm" action="${pageContext.request.contextPath}/plasmid_findByPage.action" method="post">
	质粒编号：<input id="p_plasmidNumber" name="p_plasmidNumber" type="text" placeholder="如pB110" size="10" >
	质粒名称：<input id="p_name" name="p_name" type="text" size="10">
	构建人：	<select name="constructor.dict_id" id="constructor">
				<option value="">--请选择--</option>
			</select>
	<input type="submit" value="查询"><br>

	共[<B>${pageBean.totalCount}</B>]条记录，共[<B>${pageBean.totalPage}</B>]页
	,每页显示
	<select name="pageSize">
		<option value="2" <c:if test="${pageBean.pageSize==2 }">selected</c:if>>2</option>
		<option value="3" <c:if test="${pageBean.pageSize==3 }">selected</c:if>>3</option>
		<option value="4" <c:if test="${pageBean.pageSize==4 }">selected</c:if>>4</option>
		<option value="5" <c:if test="${pageBean.pageSize==5 }">selected</c:if>>5</option>
		<option value="6" <c:if test="${pageBean.pageSize==6 }">selected</c:if>>6</option>
		<option value="7" <c:if test="${pageBean.pageSize==7 }">selected</c:if>>7</option>
		<option value="8" <c:if test="${pageBean.pageSize==8 }">selected</c:if>>8</option>
		<option value="9" <c:if test="${pageBean.pageSize==9 }">selected</c:if>>9</option>
		<option value="10" <c:if test="${pageBean.pageSize==10 }">selected</c:if>>10</option>
		<option value="11" <c:if test="${pageBean.pageSize==11 }">selected</c:if>>11</option>
		<option value="${pageBean.totalCount}" <c:if test="${pageBean.pageSize==pageBean.totalCount }">selected</c:if>>所有数据</option>
	</select>
	条
	<c:if test="${pageBean.pageCode > 1 }">
  		[<A href="javascript:to_page(${pageBean.pageCode-1})">前一页</A>]
 	</c:if>
	<B>${pageBean.pageCode}</B>
	<c:if test="${pageBean.pageCode < pageBean.totalPage }">
    		[<A href="javascript:to_page(${pageBean.pageCode+1})">后一页</A>] 
  	</c:if>
	到<input type="text" size="3" id="page" name="pageCode" />页
	
 	<input type="button" value="Go" onclick="to_page()"/>
 	<!-- <input type="submit" value="提交"> -->
</form>
 查询结果如下：<br>
<table border="1"  >
	<tr>
		<td>
			ID
		</td>
		<td>
			质粒编号
		</td>
		<td>
			质粒名称
		</td>
		<td>
			载体类型
		</td>
		<td>
			构建人
		</td>
		<td>
			入库人
		</td>
		<td>
			日期
		</td>
		<td>
			时间
		</td>
		<td>
			描述
		</td>
		<td>
			备注
		</td>
		<td>
			操作
		</td>
		
	</tr> 
<s:iterator value="pageBean.beanList" id="name">
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
		<td>
		<a href="${pageContext.request.contextPath }/plasmid_initUpdate.action?p_id=${name.p_id}">修改</a>
													&nbsp;&nbsp;
		<!-- <input type="button" value="删除" onclick="delete()"/> -->
													
		<a href="${pageContext.request.contextPath}/plasmid_delete.action?p_id=${name.p_id}" onclick="return window.confirm('确定删除吗？')">删除</a>
		
		</td>
	</tr> 
</s:iterator>
</table>

</body>
</html>