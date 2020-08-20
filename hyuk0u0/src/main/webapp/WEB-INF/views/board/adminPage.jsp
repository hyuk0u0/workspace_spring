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
	<jsp:include page="../includes/header.jsp" />
	
	<div class="container">
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h1>관리자페이지</h1>
				</div>
				<div class="panel-body">
					<p><a href="/board/categoryInsert">카테고리 조회/등록</a></p>
					<p><a href="/board/goodsInsert">제품 조회/등록</a></p>
					<hr>
					<h2>고객 관리</h2>
					<hr>
					<table class="table">
						<thead>
							<tr>
								<th>아이디</th>
								<th>성함</th>
								<th>주소</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${memberList}" var="memberDTO">
								<tr>
									<th>${memberDTO.userId}</th>
									<th>${memberDTO.userName}</th>
									<th>${memberDTO.addr}</th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>