<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보 상세 페이지</h1>
<form method="post">
<table border="1">
	<tr>
		<th>아이디</th>
		<td><input readonly type="text" name="id" value="${memberdetail.id}"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="text" name="password" value="${memberdetail.password}">지금은 비번 오픈</td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input type="text" name="addr" value="${memberdetail.addr}"></td>
	</tr>
	<tr>
		<th>이름</th><td>${memberdetail.name}</td>		
	</tr>
	<tr>
		<th>나이</th><td>${memberdetail.age}</td>		
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="정보 수정" formaction="/Member/modify">
		<input type="submit" value="회원 탈퇴" formaction="/Member/resign">
		</td>
	</tr>
</table>
</form>
</body>
</html>