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
	
	<c:if test="${empty login}">
		<script>alert('로그인이 필요한 화면입니다. 로그인 페이지로 이동합니다.'); location.href='/member/login'; </script>
	</c:if>
</head>
	<script type="text/javascript">
		$(document).ready(function(){

			// 아이디 업데이트
			$("#updateSubmit").on("click", function(){
				if($("#userPw").val()=="") {
					alert("비밀번호를 입력해주세요.");
					$("#userPw").focus();
					return false;
				}
				if($("#userName").val()=="") {
					alert("이름을 입력해주세요.");
					$("#userName").focus();
					return false;
				}

				$("#updateForm").submit();
			});

			// 아이디 삭제
			$("#deleteSubmit").on("click", function(event){

				location.href='/member/delete/${dto.userId}';
			});


			
		});
	</script>

<body>
	<div class="container">
		<div class="row">
			<form action="/member/update" method="post" id="updateForm">
				<div class="form-group">
					<label for="userId">아이디</label>
					<input class="form-control" id="userId" name="userId" value="${dto.userId}" readonly>
				</div>
				<div class="form-group">
					<label for="userPw">비밀번호</label>
					<input class="form-control" id="userPw" name="userPw" type="password" value="${dto.userPw}">
				</div>
				<div class="form-group">
					<label for="userName">이름</label>
					<input class="form-control" id="userName" name="userName" value="${dto.userName}">
				</div>
			</form>
			<div class="form-group">
				<button class="btn btn-primary" type="button" id="updateSubmit">수정</button>
				<button class="btn btn-primary" type="button" id="deleteSubmit">삭제</button>
			</div>
			
			
		</div>
	</div>
</body>
</html>