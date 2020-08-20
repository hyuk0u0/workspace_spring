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
			<form action="/member/register" method="post" id="regForm">
				<div class="form-group">
					<label for="userId">아이디</label>
					<input class="form-control" id="userId" name="userId">
				</div>
				<div class="form-group">
					<button class="idChk btn btn-primary" id="idChk" type="button" onclick="fn_idChk();" value="N">중복확인</button>
				</div>
				<div class="form-group">
					<label for="userPw">비밀번호</label>
					<input class="form-control" id="userPw" name="userPw" type="password">
				</div>
				<div class="form-group">
					<label for="userName">성함</label>
					<input class="form-control" id="userName" name="userName">
				</div>
				<div class="form-group">
					<label for="addr">주소</label>
					<input class="form-control" id="addr" name="addr">
				</div>
				<input type="hidden" name="grantsNum" value="4">
			</form>
			<div class="form-group">
				<button class="btn btn-primary" type="button" id="submit">회원가입</button>
				<button class="cencle btn btn-primary" type="button">취소</button>
			</div>
		</div>
	</div>
	
	<jsp:include page="../includes/footer.jsp" />
	
	<script type="text/javascript">
		$(document).ready(function(){
			//취소
			$(".cencle").on("click", function(){
				location.href = "/board/mainPage";
			});

			//회원가입
			$("#submit").on("click", function(){
				if($("#userId").val() == ""){
					alert("아이디를 입력해주세요");
					$("#userId").focus();
					return false;
				}

				if($("#userPw").val() == ""){
					alert("비밀번호를 입력해주세요");
					$("#userPw").focus();
					return false;
				}

				if($("#userName").val() == ""){
					alert("성함을 입력해주세요");
					$("#userName").focus();
					return false;
				}

				if($("#addr").val() == ""){
					alert("주소를 입력해주세요");
					$("#addr").focus();
					return false;
				}

				var idChkVal = $("#idChk").val();

				if (idChkVal == "N") {
					alert("중복확인 버튼을 눌러주세요.")
				} else if (idChkVal == "Y") {
					$("#regForm").submit();
				}
			});
		});

		function fn_idChk(){
			$.ajax({
				url : "/member/idChk",
				type : "post",
				dataType : "json",
				data : {
					"userId" : $("#userId").val()
				},
				success : function(data){
					if (data == 1) {
						alert("중복된 아이디입니다.");
					}else if(data == 0){
						$("#idChk").attr("value", "Y");
						alert("사용가능한 아이디입니다.")
					}
				}
			});
		}
	</script>
</body>
</html>