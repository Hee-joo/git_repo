<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// <body onload="함수명"> 와 동일함
	window.onload = function(){
		//alert("로그아웃");
		//location.href = "../main/index.jsp";
		var dialog = document.getElementById("logout_dialog");
		dialog.showModal();
	}
	function close_ok() {
		var dialog = document.getElementById("logout_dialog");
		dialog.close();
		location.href = "../main/index.jsp";
	}
</script>
</head>
<body>
	<dialog id="logout_dialog">
		<h3>로그아웃</h3>
		<input type="button" id="btn_ok" value="확인" onclick="close_ok()">
	</dialog>
</body>
</html>