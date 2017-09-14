<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	.error{
	color:red;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">

	//将异步改成同步，否则会影响表格提交的判断。
	$.ajaxSettings.async = false;

	//用户名判断
	function checkCode(){
		var code=$("#user_code").val();
		 if(code.trim() == "") {
			$("#codeId").addClass("error");
			$("#codeId").html("用户名不能为空！");
		}else{
			$("#codeId").removeClass("error");
			$("#codeId").html("");
		}
	}
	//密码输入判断
	function checkPassword() {
		var user_password=$("#user_password").val();
		if (user_password.trim() =="" ) {
			$("#userPassword").addClass("error");
			$("#userPassword").html("密码不能为空！");
		}else {
			$("#userPassword").removeClass("error");
			$("#userPassword").html("");

		}
	}
	
	function checkAll() {
		//alert("执行账户密码验证");
		$.ajaxSettings.async = false;
		url="${pageContext.request.contextPath}/user_login.action";
		var code=$("#user_code").val();
		var user_password=$("#user_password").val();
		param={"user_code":code,"user_password":user_password}
		$.post(url,param,function(data){
				if (data && data=="no") {
					$("#loginfail").addClass("error");
					$("#loginfail").html("用户名和密码不正确！");
				}else {
					$("#loginfail").removeClass("error");
					$("#loginfail").html("");

				}
		},"text");
	}
	
	//表格提交控制
	function checkForm() {
		checkCode();
		checkAll();
		/* return false; */
		if ($(".error").size()>0) {
			return false;
		}
	}
	//显示登录信息函数
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
<title>登陆</title>
</head>
<body>
<%-- <s:debug/> --%>

<span id="loginStatus"></span>
<form action="${pageContext.request.contextPath}/user_login.action" onsubmit="return checkForm()" method="post">
<span id="loginfail"></span><br>
用户名：<input id="user_code" name="user_code" type="text"  onblur="checkCode()" >  <span id="codeId" ></span><br>
密码：<input id="user_password" name="user_password" type="password"  onblur="checkPassword()"> <span id="userPassword" ></span><br>
<input type="submit" value="登陆">

<jsp:include page="${pageContest.request.contextPath}/menu.jsp"></jsp:include>
</form>

</body>
</html>