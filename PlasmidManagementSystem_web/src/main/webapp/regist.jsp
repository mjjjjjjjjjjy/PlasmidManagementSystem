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
	//用户名判断
	function checkCode(){
		var code=$("#user_code").val();
		 if(code.trim() == "") {
			 $("#codeId").addClass("error");
			$("#codeId").html("用户名不能为空！");
		}else {
			$("#codeId").html("");
			url="${pageContext.request.contextPath}/user_checkCode.action";
			param={"user_code":code}
			$.post(url,param,function(data){
					if (data && data=="no") {
						 $("#codeId").addClass("error");
						$("#codeId").html("用户名已经被占用！请更换其他用户名");
					}else{
						$("#codeId").removeClass("error");
						$("#codeId").html("用户名可以使用！");
					}
			});
		}
	}
	//密码输入判断
	function checkPassword() {
		var user_password=$("#user_password").val();
		var user_password_check=$("#user_password_check").val();
		if (user_password.trim() =="" ) {
			$("#userPassword").addClass("error");
			$("#userPassword").html("密码不能为空");
		}else {
			$("#userPassword").removeClass("error");
			$("#userPassword").html("");

		}
	}
	//再次两次密码输入一致性判断
	function checkPassword2() {
		var user_password=$("#user_password").val();
		var user_password_check=$("#user_password_check").val();
		if (user_password.trim() =="" ) {
			$("#checkPassword2").addClass("error");
			$("#checkPassword2").html("请再次输入密码！");
		}else if (user_password!==user_password_check) {
			$("#checkPassword2").addClass("error");
			$("#checkPassword2").html("两次输入密码不一致");			
		}else{
			$("#checkPassword2").removeClass("error");
			$("#checkPassword2").html("两次输入密码一致！");
			
		}
	}
//表格提交控制
function checkForm() {
	checkCode();
	checkPassword();
	checkPassword2();
	/* alert($(".error").size()); */
	if ($(".error").size()>0) {
		return false;
	}
}



</script>
<title>注册页面</title>
</head>
<body>

<jsp:include page="${pageContest.request.contextPath}/menu.jsp"></jsp:include>

<%-- <s:debug/> --%>
<form action="${pageContext.request.contextPath}/user_regist.action" onsubmit="return checkForm()" method="post">
用户名：<input id="user_code" name="user_code" type="text"  onblur="checkCode()" >  <span id="codeId" ></span><br>
密码：<input id="user_password" name="user_password" type="password"  onblur="checkPassword()"> <span id="userPassword" ></span><br>
密码确认：<input id="user_password_check" name="user_password_check" type="password" onblur="checkPassword2()"><span id="checkPassword2" ></span><br>
<input type="submit" value="保存用户">

</form>

</body>
</html>