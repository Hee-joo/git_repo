<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Title</title>
<!-- ?v=1 : 브라우저는 자바스크립트 파일을 다운받은후, 자주 업데이트를 하지 않음
            그러므로 파일 설정에서 버전을 추가하면, 파일 업데이트를 실행함
 -->
<script type="text/javascript" src="../script/memberScript.js?v=2"></script>
<style type="text/css">
    table#tb_writeForm{
        width: 500px;
        border-collapse: collapse;
        border: 1px solid black;
        font-family: Gothic;
    }
    table#tb_writeForm td{
        border: 1px solid black;
        padding: 5px;
    }
    table#tb_writeForm td.center{
        text-align: center;
    }
</style>
</head>
<body>
<form action="../member/write.do" method="post" name="frm" id="form" onsubmit="check(); return false;">
    <table id="tb_writeForm">
        <tr>
            <td width="20%" class="center">이름</td>
            <td width="80%"><input type="text" name="name" id="name" placeholder="* 필수 입력"></td>
        </tr>
        <tr>
            <td class="center">아이디</td>
            <td>
            	<input type="text" name="id" id="id" placeholder="* 필수 입력">
            	<input type="button" value="중복체크" onclick="checkId()">
            </td>
        </tr>
        <tr>
            <td class="center">비밀번호</td>
            <td><input type="password" name="pwd" id="pwd" placeholder="* 비밀번호 입력"></td>
        </tr>
        <tr>
            <td class="center">재확인</td>
            <td><input type="password" name="repwd" id="repwd" placeholder="* 비밀번호 재확인"></td>
        </tr>
        <tr>
            <td class="center">성별</td>
            <td>
                <input type="radio" name="gender" value="남">남
                <input type="radio" name="gender" value="여">여
            </td>
        </tr>
        <tr>
            <td class="center">이메일</td>
            <td>
                <input type="text" name="email1">&nbsp;@&nbsp;
                <select name="email2">
                    <option value="naver.com">naver.com</option>
                    <option value="daum.net">daum.net</option>
                    <option value="gmail.com">gmail.com</option>
                </select>
            </td>
        </tr>
        <tr>
            <td class="center">핸드폰</td>
            <td>
                <select name="tel1">
                    <option value="010">010</option>
                    <option value="016">016</option>
                    <option value="018">018</option>
                </select>
                &nbsp;-&nbsp;
                <!-- 숫자만 입력받도록 설정 -->
                <input type="text" name="tel2" maxlength="4" size="10"
                	oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
                &nbsp;-&nbsp;
                <input type="text" name="tel3" maxlength="4" size="10"
                	oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
            </td>
        </tr>
        <tr>
            <td class="center">주소</td>
            <td>
                <input type="text" name="addr" style="width:100%;">
            </td>
        </tr>
        <tr>
            <td colspan="2"  class="center">
                <button type="submit">회원 가입</button>&nbsp;
                <button type="reset">다시 작성</button>
            </td>
        </tr>
    </table>

</form>
</body>
</html>