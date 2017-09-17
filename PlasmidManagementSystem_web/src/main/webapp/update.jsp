<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
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
				// 先获取值栈中的值，使用EL表达式
				var vsId = "${vector.dict_id}";
				// 值栈中的id值和遍历的id值相同，让被选中
				if(vsId == n.dict_id){
					// JQ的DOM操作
					$("#vector").append("<option value='"+n.dict_id+"' selected>"+n.dict_item_name+"</option>");
				}else{
					$("#vector").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
				}
			});
		},"json");
		
		//查询构建者
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
		
		// 查询入库人
		var param = {"dict_type_code":"002"};
		$.post(url,param,function(data){
			// 遍历
			$(data).each(function(i,n){
				// 先获取值栈中的值，使用EL表达式
				var vsId = "${ruku.dict_id}";
				// 值栈中的id值和遍历的id值相同，让被选中
				if(vsId == n.dict_id){
					// JQ的DOM操作
					$("#ruku").append("<option value='"+n.dict_id+"' selected>"+n.dict_item_name+"</option>");
				}else{
					$("#ruku").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
				}
			});
		},"json");
		//设置回异步执行
		$.ajaxSettings.async = false;
	});
	
	
	$(function(){
		var loginUser="${sessionScope.loginUser}";
		if (loginUser) {
			$("#loginStatus").html("["+loginUser+"],您已经登陆！");
			$("#exit").html("<a href='${pageContext.request.contextPath}/user_exit.action' >退出登录</a>");
		}else {
			$("#loginStatus").html("请先登陆！");
		}
	});
	
</script>
</head>
<body>
欢迎来到质粒更新系统！
<%-- <s:debug/> --%>

<jsp:include page="${pageContest.request.contextPath}/menu.jsp"></jsp:include>

<FORM id="plasmidForm" name="plasmidForm" action="${pageContext.request.contextPath }/plasmid_update.action" method=post enctype="multipart/form-data">
	质粒编号：<input id="p_plasmidNumber" name="p_plasmidNumber" type="text" value="${model.p_plasmidNumber }"><br/>
	质粒名称：<input id="p_name" name="p_name" type="text" value="${model.p_name}"><br/>
 	载体名称：<select id="vector" name="vector.dict_id"></select><br/>
	构建人：<select id="constructor" name="constructor.dict_id" ></select> <br/>
	入库人：<select id="ruku" name="ruku.dict_id"></select> <br/>
	描   述：<input id="p_description" name="p_description" type="text"  value="${model.p_description} "><br/>
	备   注：<input id="p_note" name="p_note" type="text" value="${model.p_note}" ><br/>	
	附件：<input id="upload" name="upload" type="file" value="上传序列"><br>	
	<button type="submit">更新</button>	
</FORM>

<br>
<br>
<br>

</body>
</html>