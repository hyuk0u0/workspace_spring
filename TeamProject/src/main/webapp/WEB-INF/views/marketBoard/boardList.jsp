<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>게시글번호</th>
						<th>제목</th>
						<th>카테고리</th>
						<th>상품 번호</th>
						<th>작성일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${boardList}" var="dto">
						<tr>
							<td>${dto.bno}</td>
							<td><a href="/marketBoard/boardRead/${dto.bno}">${dto.title}</a></td>
							<td>${dto.cname}</td>
							<td>${dto.gno}</td>
							<td>${dto.regDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
	</div>
</body>
</html>