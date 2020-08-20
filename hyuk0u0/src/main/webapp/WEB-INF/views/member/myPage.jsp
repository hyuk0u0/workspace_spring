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
			  		<h1>마이페이지</h1>
			  	</div>
			    <div class="panel-body">
			    	<h2>회원 정보</h2>
			    	<p>아이디 : ${memberDTO.userId}<p>
			    	<p>성함  : ${memberDTO.userName}</p>
			    	<p>배송지 : ${memberDTO.addr}</p>
			    	<p><a href="/member/update/${memberDTO.userId}"><span class="glyphicon glyphicon-pencil"></span> 회원 수정 </a></p>
			    	<p><a href="/member/delete/${memberDTO.userId}"><span class="glyphicon glyphicon-remove"></span> 회원 탈퇴</a></p>
			    	<hr>
			    	<h2>장바구니</h2>
			    	<hr>
			    	<h2>거래내역</h2>
			    </div>
			</div>
		</div>
	</div>



<jsp:include page="../includes/footer.jsp" />
</body>
</html>