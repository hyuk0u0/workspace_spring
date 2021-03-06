<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/codingBooster.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>코딩 부스터</title>
	<style type="text/css">
		.jumbotron {
			background-image: url("images/jumbotronBackground.jpg");
			background-size: cover;
			text-shadow: black 0.2em 0.2em 0.2em;
			color: white;
		}
	</style>
	
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">코딩 부스터</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.jsp">소개<span class="sr-only"></span></a></li>
					<li><a href="instructor.jsp">강사진</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-haspopup="true" aria-expanded="false">강의<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="lecture.jsp?lectureName=C">C언어</a></li>
							<li><a href="lecture.jsp?lectureName=Java">Java</a></li>
							<li><a href="lecture.jsp?lectureName=Android">안드로이드</a></li>
						</ul>
					</li>
				</ul>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="내용을 입력하세요.">
					</div>
					<button type="submit" class="btn btn-default">검색</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-haspopup="true" aria-expanded="false">접속하기<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="loginForm.jsp">로그인</a></li>
							<li><a href="registerForm.jsp">회원가입</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	
	
	
	
	<div class="container">
		<div class="jumbotron">
			<h1 class="text-center">코딩 부스터를 소개합니다.</h1>
			<p class="text-center">코딩 부스터는 IT 교육 사이트입니다. 다양한 IT 관련 무료 및 유료 강의가 존재합니다.<p>
			<p class="text-center"><a class="btn btn-primary btn-lg" href="lecture.jsp">강의 들으러 가기</a></p>
		</div>
		<div class="row">
			<div class="col-md-4">
				<h4>코딩 부스터의 특징</h4>
				<p>코딩 부스터는 다른 사이트와 차원이 다른 깔끔한 구성을 보여줍니다. 모든 페이지가 사용자가 접근하고 일기 쉽도록 정교하게 구성되었습니다.</p>
				<p><a class="btn btn-default" data-target="#modal" data-toggle="modal">자세히 알아보기</a></p>
			</div>
			<div class="col-md-4">
				<h4>폭넓은 강사진</h4>
				<p>코딩 부스터는 정말로 뛰어난 개발자만을 강사진으로 뽑습니다. 각각의 강사진은 현직 개발자로서 프로그래밍을 처음 접하는 학생에게 친절하게 알려줍니다.</p>
				<p><a class="btn btn-default" href="instructor.jsp">자세히 알아보기</a></p>
			</div>
			<div class="col-md-4">
				<h4>핵심적인 강의</h4>
				<p>강의는 실제 개발에 있어서 반드시 필요한 핵심적인 내용을 중심으로 다룹니다. 강의를 듣는 시간 내내 요약된 정보를 온전히 받아들일 수 있습니다.</p>
				<p><a class="btn btn-default" href="lecture.jsp">자세히 알아보기</a></p>
			</div>
		</div>
		<hr>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-heading"><span class="glyphicon glyphicon-pencil"></span>
				&nbsp;&nbsp;최신 강의 목록</h3>
			</div>
			<div class="panel-body">
				<div class="media">
					<div class="media-left">
						<a href="lecture.jsp?lectureName=C"><img class="media-object" src="images/c.jpg" alt="C언어 강의 이미지"></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading"><a href="lecture.jsp?lectureName=C">C언어 기초 프로그래밍 강의</a>&nbsp;<span class="badge">New</span></h4>
						C언어 강의는 기초 프로그래밍 강의입니다. 처음 프로그래밍을 접하는 입문자가 듣기에 적합한 강의입니다.
						강의료는 무료이며 C언어 기초 프로그래밍 강좌는 총 20강으로 구성됩니다.
					</div>
				</div>
				<hr>
				<div class="media">
					<div class="media-left">
						<a href="lecture.jsp?lectureName=Java"><img class="media-object" src="images/java.jpg" alt="Java 강의 이미지"></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading"><a href="lecture.jsp?lectureName=Java">Java 기초 프로그래밍 강의</a>&nbsp;<span class="badge">New</span></h4>
						Java 강의는 객체 지향 프로그래밍의 기본을 알려주는 강의입니다. 처음 프로그래밍을 접하는 입문자가 듣기에 적합한 강의입니다.
						강의료는 무료이며 Java 기초 프로그래밍 강좌는 총 30강으로 구성됩니다.
					</div>
				</div>
				<hr>
				<div class="media">
					<div class="media-left">
						<a href="lecture.jsp?lectureName=Android"><img class="media-object" src="images/android.jpg" alt="안드로이드 강의 이미지"></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading"><a href="lecture.jsp?lectureName=Android">안드로이드 스튜디오 활용 강의</a>&nbsp;<span class="badge">New</span></h4>
						안드로이드 강의는 Java를 활용하여 안드로이드 애플리케이션을 개발하는 강의입니다.
						속도감 있는 강의로 앱 개발 입문자가 빠르게 앱을 만들어보면서 기본 개념을 탄탄히 다지도록 합니다.
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	<footer style="background-color: #000000; color: #ffffff">
		<div class="container">
			<br>
			<div class="row">
				<div class="col-sm-2" style="text-align: center;"><h5>Copyright &copy; 2020</h5><h5>박성혁(Sunghyuk Park)</h5></div>
				<div class="col-sm-4"><h4>대표자 소개</h4><p>저는 코딩 부스터의 대표 박성혁입니다. 한국교원대학교에서 공부를 하고 있으며 웹 개발에 관심이 많습니다.</p></div>
				<div class="col-sm-2"><h4 style="text-align: center;">내비게이션</h4>
					<div class="list-group">
						<a href="index.jsp" class="list-group-item">소개</a>
						<a href="instructor.jsp" class="list-group-item">강사진</a>
						<a href="lecture.jsp" class="list-group-item">강의</a>
					</div>
				</div>
				<div class="col-sm-2"><h4 style="text-align: center;">SNS</h4>
					<div class="list-group">
						<a href="https://www.naver.com" class="list-group-item">페이스북</a>
						<a href="https://www.google.com" class="list-group-item">유튜브</a>
						<a href="https://www.daum.net" class="list-group-item">네이버 TV</a>
					</div>
				</div>
				<div class="col-sm-2"><h4 style="text-align: center;"><span class="glyphicon glyphicon-ok"></span>&nbsp;by 박성혁</h4></div>
			</div>
		</div>
	</footer>
	<div class="row">
		<div class="modal" id="modal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						코딩 부스터의 특징
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body" style="text-align: center;">
						저희 서비스의 특징은 바로 강의를 들을 수 있다는 점입니다. <br>
						특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<br><br>
						<img src="images/youtube.png" id="imagepreview" style="width: 256px; height: 256px;">
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-heading">
					<span class="glyphicon glyphicon-option-vertical"></span>
					&nbsp;
					<a href="#">베스트</a>
				</h3>
			</div>
			<div class="panel-body" style="min-height: 912px;">
				<div class="row">
					<c:forEach items="${hList}" var="dto">
					<div class="col-md-3 col-xs-6">
					<div class="thumbnail">
						<a href="read.do?num=${dto.num }">
							<c:if test="${not empty dto.attList }">
								<img style="width:100%; height: 200px;" src="${dto.attList[0].attPath}" >
							</c:if>
							<c:if test="${empty dto.attList }">
								<img style="width:100%; height: 200px;"src="images/jumbotronBackground.jpg">
							</c:if>
							<div class="caption">
								<h3><a href="read.do?num=${dto.num }">${dto.title}</a></h3>
								<h3><small>${dto.location}</small>&nbsp;&nbsp;<small>${dto.category}</small></h3>
								<p style="color: gold;">${dto.money}원</p>
								<hr>
								<p>조회수 ${dto.readcnt} &nbsp;&nbsp;&nbsp; 찜 ${dto.likes} &nbsp;&nbsp;&nbsp; 댓글 ${dto.replycnt}</p>
							</div>
						</a>	
					</div>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>