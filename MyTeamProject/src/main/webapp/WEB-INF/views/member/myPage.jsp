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
	<c:if test="${empty login}">
		<script>alert('로그인이 필요한 화면입니다. 로그인 페이지로 이동합니다.'); location.href='/member/login'; </script>
	</c:if>
<body>

	<div class="container">
		<div class="row">
			<form action="/member/update" method="post" id="updateForm">
				<div class="form-group">
					<label for="id">아이디</label>
					<input class="form-control" id="id" name="id" value="${memberDTO.id}" readonly>
				</div>
				<div class="form-group">
					<label for="pw">비밀번호</label>
					<input class="form-control" id="pw" name="pw" type="password" value="${memberDTO.pw}">
				</div>
				<div class="form-group">
					<label for="uname">이름</label>
					<input class="form-control" id="uname" name="uname" value="${memberDTO.uname}">
				</div>
				<div class="form-group">
					<label for="phone">전화번호</label>
					<input class="form-control" id="phone" name="phone" value="${memberDTO.phone}">
				</div>
				<div class="form-group">
					<label for="addr">주소</label>
					<input class="form-control" id="addr" name="addr" value="${memberDTO.addr}">
				</div>
			</form>
			<div class="form-group">
				<button class="btn btn-primary" type="button" id="updateSubmit">수정</button>
				<button class="btn btn-primary" type="button" id="deleteSubmit">삭제</button>
			</div>
		</div>
	</div>



	<script type="text/javascript">
		$(function(){
			var UpdateMsg = "<c:out value="${UpdateMsg}"/>";
			if (UpdateMsg == 'success') {
				alert("회원 정보 수정 완료!");
			}
		});
	
		$(document).ready(function(){

			// 아이디 업데이트
			$("#updateSubmit").on("click", function(){
				if($("#pw").val()=="") {
					alert("비밀번호를 입력해주세요.");
					$("#pw").focus();
					return false;
				}
				if($("#uname").val()=="") {
					alert("이름을 입력해주세요.");
					$("#uname").focus();
					return false;
				}
				if($("#phone").val()=="") {
					alert("전화번호를 입력해주세요.");
					$("#phone").focus();
					return false;
				}
				if($("#addr").val()=="") {
					alert("주소를 입력해주세요.");
					$("#addr").focus();
					return false;
				}

				$("#updateForm").submit();
			});

			// 아이디 삭제
			$("#deleteSubmit").on("click", function(event){


				location.href='/member/delete/${memberDTO.id}';
			});


			
		});
	</script>
</body>
</html>