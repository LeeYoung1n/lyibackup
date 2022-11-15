<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>개인 회원가입</h1>
<form action="/Member/signup" method="post">
<table>
	<tr><td><input type="text" placeholder="ID" name="id">
		<span id="sid"></span></td></tr>
	<tr><td><input type="text" placeholder="PASSWORD" name="password">
		<span id="spw"></span></td></tr>
	<tr><td><input type="text" placeholder="NAME" name="name">
		<span id="sna"></span></td></tr>
	<tr><td colspan="2"><input type="submit" value="가입하기"></td>
	</tr>
</table>
</form>
</body>
</html>