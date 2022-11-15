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
<h1>회원 정보 리스트</h1>
<table border="1">
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>주소</th>
		<th>휴대폰번호</th>
		<th>이메일</th>
		<th>이름</th>
		<th>나이</th>
	</tr>
	<!-- for시작 -->
	<c:forEach items="${memberlist }" var="memlist">
	<tr>
		<td><a href="/Member/memberdetail?id=${memlist.id}">${memlist.id }</a></td>
		<td>${memlist.password }</td>
		<td>${memlist.addr }</td>
		<td>${memlist.phone }</td>
		<td>${memlist.email }</td>
		<td>${memlist.name }</td>
		<td>${memlist.age }</td>
	</tr>
	</c:forEach>
	<!-- for 닫음 -->
</table>
</body>
</html>