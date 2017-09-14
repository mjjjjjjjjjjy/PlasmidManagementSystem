<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script language="javascript">
//测试1.
/* 	$(function () {
		var arr1 = [ "aaa", "bbb", "ccc" ];
		$(arr1).each(function(i,val){
			alert(i);
			alert(val);
		})
	}); */
//测试2	
/* 	$(function () {
		var arr1 = {one:1,two:2,three:3};
		$(arr1).each(function(i,val){
			alert(i);
			alert(val);
		})
	}); */
	//测试3：
	 　　$(function(){
		 var obj = { one:1, two:2, three:3};      
	 　	$.each(obj,function(key, val) {      
	      　　alert(key);   
	      　　alert(val);      
	 　　})
	   });
	
</script>
<title>Insert title here</title>
</head>
<body>

</body>
</html>