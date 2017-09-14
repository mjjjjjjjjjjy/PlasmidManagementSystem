<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加质粒</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">

	
	$(function(){
		//发送ajax的请求
		var url = "${ pageContext.request.contextPath }/dict_findByCode.action";
		//设置同步执行
		$.ajaxSettings.async = false;
		//查询载体类型
		var param = {"dict_type_code":"003"};
		$.post(url,param,function(data){
			// 遍历
			$(data).each(function(i,n){
				$("#vector").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			});
		},"json");
		
		//查询构建者
		 var param = {"dict_type_code":"001"};
		$.post(url,param,function(data){
			// 遍历
			$(data).each(function(i,n){
				$("#constructor").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			});
		},"json");
		
		// 查询入库人
		var param = {"dict_type_code":"002"};
		$.post(url,param,function(data){
			// 遍历
			$(data).each(function(i,n){
				$("#ruku").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			});
		},"json");
		//设置回调步执行
		$.ajaxSettings.async = false;
	});

</script>
</head>
<body>

<jsp:include page="${pageContest.request.contextPath}/menu.jsp"></jsp:include>

<FORM id="plasmidForm" name="plasmidForm" action="${pageContext.request.contextPath }/plasmid_save.action" method=post>
	质粒编号：<input id="p_plasmidNumber" name="p_plasmidNumber" type="text" ><br/>
	质粒名称：<input id="p_name" name="p_name" type="text" ><br/>
 	载体名称：<select id="vector" name="vector.dict_id"></select><br/>
	构建人：<select id="constructor" name="constructor.dict_id" ></select> <br/>
	入库人：<select id="ruku" name="ruku.dict_id"></select> <br/>
	描   述：<input id="p_description" name="p_description" type="text" ><br/>
	备   注：<input id="p_note" name="p_note" type="text" ><br/>	
	<button type="submit">提交</button>	
</FORM>

</body>
</html>