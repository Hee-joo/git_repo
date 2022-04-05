<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// 브라우저가 모든 태그를 인식한 다음, onload 이벤트가 동작됨	
	window.onload = function(){
		var dialog = document.getElementById("modify_dialog");
		dialog.showModal();
	}
	function close_ok() {
		var dialog = document.getElementById("modify_dialog");
		dialog.close();
		location.href = "../board/boardView.do?seq=${seq }&pg=${pg }";
	}
</script>
</head>
<body>
	<dialog id="modify_dialog" align="center">
		<c:if test="${result > 0 }">
			<p>글 수정 성공</p>
		</c:if>
		<c:if test="${!(result > 0)}">
			<p>글 수정 실패</p>
		</c:if>
		<input type="button" id="btn_ok" value="확인" onclick="close_ok()">
	</dialog>
</body>
</html>