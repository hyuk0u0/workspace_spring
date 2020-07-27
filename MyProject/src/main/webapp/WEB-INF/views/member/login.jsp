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
			<form action="/member/loginPost" method="post">
				<div class="form-group">
					<label for="userId">아이디</label>
					<input id="userId" name="userId" class="form-control">
				</div>
				<div class="form-group">
					<label for="userPw">비밀번호</label>
					<input id="userPw" name="userPw" class="form-control">
				</div>
				<div class="form-group">
					<button type="submit" class="form-control btn btn-primary">로그인</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>