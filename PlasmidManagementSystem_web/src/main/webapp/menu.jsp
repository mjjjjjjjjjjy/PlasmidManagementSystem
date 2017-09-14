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
	var loginUser="${sessionScope.loginUser}";
	if (loginUser) {
		$("#loginStatus").html(" "+loginUser+" ，您已经登陆！");
		$("#exit").html("<a href='${pageContext.request.contextPath}/user_exit.action' >退出登录</a>");
	}else {
		$("#loginStatus").html("请先登陆！");
	}
});
	
</script>
</head>
<body>
<span id="loginStatus" style="color:red;" ></span>

<br>
<br>
<a href="${pageContext.request.contextPath }/index.jsp">主页</a>&nbsp&nbsp
<a href="${pageContext.request.contextPath }/jsp/plasmid/add.jsp">质粒添加</a>&nbsp&nbsp
<a href="${pageContext.request.contextPath }/jsp/plasmid/pageBean.jsp">质粒查询</a>&nbsp &nbsp
<a href="${pageContext.request.contextPath }/jsp/dict/add.jsp">词典管理</a>&nbsp&nbsp
<a href="${pageContext.request.contextPath }/regist.jsp">注册</a>&nbsp&nbsp
<a href="${pageContext.request.contextPath }/login.jsp">登陆</a>&nbsp&nbsp
<span id="exit"></span>
<br>
<br>

</body>
</html>