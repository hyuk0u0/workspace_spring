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
	<style type="text/css">
		.jumbotron {
			background-image: url("#");
			background-size: cover;
			text-shadow: black 0.2em 0.2em 0.2em;
			color: white;
		}
		.jumbotronA:link { color: white; text-decoration: none;}
 		.jumbotronA:visited { color: white; text-decoration: none;}
 		.jumbotronA:hover { color: white; text-decoration: none;}
	
	</style>
</head>
<body>
	<nav class="navbar navbar-default" style="background-color: #cccccc;">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-7">
					<ul class="nav navbar-nav">
						<li><a href="/board/mainPage">메인페이지</a></li>
					</ul>
				</div>
				<div class="col-md-2">
					<ul class="nav navbar-nav">
						<li>
							<c:if test="${empty login}">
								<a href="/member/login">로그인</a>	
							</c:if>
							<c:if test="${!empty login}">
								<a href="/member/logout">로그아웃</a>	
							</c:if>
						</li>
						<li><a href="/member/register">회원가입</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">마이페이지<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="/member/myPage/${login.id}">내정보수정</a></li>
								<li><a href="#">주문조회</a></li>
								<li><a href="#">찜 리스트</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</nav>
	
	<div class="container">
		<div class="jumbotron" style="background-color: #cccccc;">
			<h1 class="text-left"><a class="jumbotronA" href="/board/mainPage">쇼핑몰 프로젝트</a></h1>
		</div>
		<div class="row">
				<div class="col-md-2"></div>
			<c:forEach items="${categoryList}" var="categoryDTO">
				<div class="col-md-2" ><p class="text-center"><a href="#">${categoryDTO.cname}모음</a></p></div>
			</c:forEach>
				<div class="col-md-2"></div>
		</div>
	</div>
	<hr>

</body>
</html>