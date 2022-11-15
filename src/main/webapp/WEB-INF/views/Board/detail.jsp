<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script type="text/javascript" src="/resources/js/attach.js"></script>
</head>
<body>
<form method="post">
<table border="1">
	<tr>
		<th>제목</th>
		<td><input type="text" name="title" value="${detail.title}">
			<input type="hidden" name="bno" value="${detail.bno}">
			|조회수${detail.cnt }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="content">${detail.content}</textarea></td>
	</tr>
	<tr>
		<th>작성일자</th><td>${detail.regdate}</td>
	</tr>
	<tr><td colspan="2">
		<input type="submit" value="수정" formaction="/Board/modify">
		<input type="submit" value="삭제" formaction="/Board/remove">
		</td>
	</tr>

</table>

</form>

	<div id="uploadResult">
		<ul>
		
		</ul>
	</div>
	<!-- 댓글 작성 버튼 - html에 직접적으로 드러남 -->
	<div><label>댓글</label></div>
	<div>
	<textarea rows="5" cols="50" id="reply"></textarea>
	</div>
	<div>
	<input type="button" value="댓글쓰기" id="add">
	</div>
	<div id="chat">
		<ul id="replyUL">
		</ul>
	</div>
</body>
</html>