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
	<a href="/member/register">회원가입</a>
	<br>
	<c:if test="${empty login}">
		<a href="/member/login">로그인</a>	
	</c:if>
	<c:if test="${!empty login}">
		<a href="/member/logout">로그아웃</a>	
	</c:if>
	<a href="/member/myPage/${login.id}">마이페이지</a>
	<br>
	<a href="/board/insert">글쓰기</a>
	
	
	
	
	
	<script type="text/javascript">
		$(function(){
			var deleteMsg = "<c:out value="${deleteMsg}"/>";
			if (deleteMsg == 'success') {
				alert("회원 정보 삭제 완료!");
			}
		});
	</script>
</body>
</html>