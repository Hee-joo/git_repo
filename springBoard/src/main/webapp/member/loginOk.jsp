<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="../image/tumi.png" width="30" height="30"
		onclick="location.href='../main/index.do'" style="cursor: pointer;">
	${memId }(${memName }) 님이 로그인
	<br>
	<input type="button" value="로그아웃" onclick="location.href='../member/logout.do'">
	<input type="button" value="회원정보수정" onclick="location.href='../member/modifyForm.do'">
	<input type="button" value="메인으로" onclick="location.href='../main/index.do'">
</body>
</html>