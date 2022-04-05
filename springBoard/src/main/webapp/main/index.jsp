<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	height: 100%;
}

#all {
	width: 1000px;
	height: 700px;
	margin: auto;
}

#header {
	width: 100%;
	height: 13%;
	text-align: center;
}

#container {
	width: 100%;
	height: 80%;
	border: 1px solid #EEA1A1;
}

#nav {
	width: 270px;;
	height: 100%;
	float: left;
	background: #FCCBCB;
	text-align: center;
}

#section {
	width: 630px;
	height: 100%;
	float: left;
}

#footer {
	width: 100%;
	height: 7%;
	clear: both;
	text-align: center;
	border: 1px solid #EEA1A1;
	background: #EEA1A1;
}
</style>
</head>
<body>
	<div id="all">
		<div id="header">
			<h3>
				<img alt="kirby_header" src="../image/kirby_header.jpg" width="70"
					height="40" onclick="location.href='../main/index.do'">
				Spring을 이용한 미니프로젝트
			</h3>
			
			<a href="../board/boardList.do?pg=1">목록</a>
			
			<c:if test="${memId != null }">
				<a href="../board/boardWriteForm.do">글쓰기</a>
				<!-- 회원목록보기는 관리자 기능이기 때문에, 회원들에는 오픈하면 안됨 -->
				<a href="../member/memberList.do?pg=1">회원목록</a>
				<a href="../member/deleteForm.do">회원 탈퇴</a>
			</c:if>
		</div>
		
		<div id="container">
			<div id="nav">
				<c:if test="${memId == null }">
					<!-- 로그인 전 화면 -->
					<jsp:include page="../member/loginForm.jsp" />
					
					<c:if test="${req_nav != null }">					
						<jsp:include page="${req_nav}" />
					</c:if>					
				</c:if>
				
				<c:if test="${memId != null }">	
					<jsp:include page="../member/loginOk.jsp" />
				</c:if>								
			</div>
			
			<div id="section">
				<c:if test="${req_sec == null }">
					<jsp:include page="../main/body.jsp" />
				</c:if>
				<c:if test="${req_sec != null }">
					<jsp:include page="${req_sec }" />
				</c:if>
			</div>
		</div>
		
		<div id="footer">
			<p>2022.03.25 KJE</p>
		</div>
	</div>
</body>
</html>