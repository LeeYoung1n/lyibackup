<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/js/list.js"></script>
</head>
<body>

<h1>개인 게시판 목록 리스트</h1>

	<a href="/Board/write"><button>글쓰기</button></a>
	<form id="searchForm" action="/Board/list">
		<select name="type">
			<option value="T">제목</option>
			<option value="C">내용</option>
			<option value="TC">제목+내용</option>
			<option value="W">작성자(id)</option>
		</select>
		<input type="text" name="keyword">
		<input type="text" name="pageNum" value="${paging.cri.pageNum}">
		<input type="text" name="amount" value="${paging.cri.amount}">
		<input type="button" value="검색">
	</form>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>아이디</th>
		</tr>
		<!-- for문 시작 -->
		<c:forEach items="${list}" var="boardlist">
		<tr>
			<td>${boardlist.bno}</td>
			<td><a href="/Board/detail?bno=${boardlist.bno}">${boardlist.title}</a></td>
			<td>${boardlist.content}</td>
			<td>${boardlist.regdate}</td>
			<td>${boardlist.cnt}</td>
			<td>${boardlist.id}</td>
		</tr>
		</c:forEach>
	</table>
	
	
	
	${paging }<br>
	<!-- prev(이전)이 true이면 이전버튼 활성화 -->
	<c:if test="${paging.prev}">
		<a href="/photo/List?type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${paging.startPage-1}&amount=${paging.cri.amount}">이전</a>
	</c:if>
	
	<!-- begin(1)이 end(10)될 동안 반복(1이 10이 될 동안 반복) -->
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
	<a href="/photo/List?type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${num} &amount=${paging.cri.amount }">${num }</a>
	</c:forEach>
	<!-- a태그와 주소를 같이 맞추려면 둘이 같아야함 -->
	
	<!-- next(다음)이 true이면 다음버튼 활성화 -->
	<c:if test="${paging.next}">
	<a href="/photo/List?type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${paging.endPage+1} &amount=${paging.cri.amount }">${num }</a>
	</c:if>

</body>
</html>