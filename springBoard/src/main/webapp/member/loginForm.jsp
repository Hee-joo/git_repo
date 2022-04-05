<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/memberScript.js"></script>
</head>
<body>
	<form action="../member/login.do" method="post" name="form1">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" placeholder="아이디를 입력"></td>
			</tr>		
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" placeholder="비밀번호 입력"></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="로그인" onclick="checkLogin(); return false;">
					<input type="button" value="회원가입" 
						onclick="location.href='../member/writeForm.do'">
				</td>
			</tr>	
		</table>
	</form>
	<a href="../main/index.jsp">메인 화면</a>
</body>
</html>