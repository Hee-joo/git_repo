<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//<body onload="함수명"> 와 동일함
	window.onload = function(){
		var dialog = document.getElementById("write_dialog");
		dialog.showModal();
	}
	function close_ok() {
		var dialog = document.getElementById("write_dialog");
		dialog.close();
		location.href = "../main/index.jsp";
	}
</script>
</head>
<body>
	<dialog id="write_dialog" align="center">
		<c:if test="${result > 0 }">
			<p>회원 가입 성공</p>
		</c:if>
		<c:if test="${!(result > 0)}">
			<p>회원 가입 실패</p>
		</c:if>	
		<p align="center">	
			<input type="button" id="btn_ok" value="확인" onclick="close_ok()">		
		</p>
	</dialog>

</body>
</html>

