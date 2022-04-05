<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var dialog = document.getElementById("delete_dialog");
		dialog.showModal();
	}
	function close_ok() {
		var dialog = document.getElementById("delete_dialog");
		dialog.close();
		location.href="delete.do";
	}
	function close_cancel() {
		var dialog = document.getElementById("delete_dialog");
		dialog.close();
		location.href = "../main/index.jsp";
	}
</script>
</head>
<body>
	<dialog id="delete_dialog">		
		<p>회원 탈퇴하시겠습니까?</p>
		<input type="button" id="btn_ok" value="확인" onclick="close_ok()">
		<input type="button" id="btn_cancel" value="취소" onclick="close_cancel()">
	</dialog>
</body>
</html>