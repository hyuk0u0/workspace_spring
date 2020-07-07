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
		<div class="row text-center">
			<h1>글 자세히 보기</h1>
		</div>
		<div class="row">
			<div class="form-group">
				<label for="title">제목</label>
				<input readonly value="${vo.title}" class="form-control">
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label for="writer">작성자</label>
				<input readonly value="${vo.writer}" class="form-control">
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label for="content">내용</label>
				<textarea readonly rows="5" class="form-control">${vo.content}</textarea>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<button class="btn btn-primary" id="reply_form">댓글</button>
				<button class="btn btn-primary" id="update">수정</button>
				<button class="btn btn-primary" id="delete">삭제</button>
				<button class="btn btn-primary" id="list">목록</button>
			</div>
		</div>
		<div class="row">
			<div class="collapse" id="myCollapse">
				<div class="form-group">
					<label for="replyer">작성자</label>
					<input class="form-control" id="replyer">
				</div>
				<div class="form-group">
					<label for="replytext">내용</label>
					<input class="form-control" id="replytext">
				</div>
				<div class="form-group">
					<button class="btn btn-primary" id="replyInsertBtn">댓글 등록</button>
				</div>
			</div>
		</div>
		<div id="replies" class="row"> <!-- 자바스크립트로 덮어쓰기 해버렸음 -->
			<div class="panel panel-primary">
  				<div class="panel-heading">
  					<span>rno: 3</span>, <sapn>작성자: 홍길동</sapn>
  					<span class="pull-right">2020년 07월07일...</span>
  				</div>
  				<div class="panel-body">
  					<p>댓글 내용입니다.</p>
  					<button class="btn btn-primary btn-xs">수정</button>
  					<button class="btn btn-primary btn-xs">삭제</button>
  				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	
		var bno = ${vo.bno};

		getList(bno); <!-- 곧바로 실행됨! -->
		
		$(document).ready(function(){
			
			$("#update").click(function(){
				location.assign("/board/update/${vo.bno}");
			});

			$("#delete").click(function(){
				location.assign("/board/delete/${vo.bno}");
			});

			$("#list").click(function(){
				location.assign("/board/list");
			});

			$("#reply_form").click(function(){
				$("#myCollapse").collapse("toggle");
			});

			$("#replyInsertBtn").click(function(){
				var replyer = $("#replyer").val();
				var replytext = $("#replytext").val();

				$.ajax({
					type : 'post',
					url : '/replies',
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "POST"
					},
					dataType : 'text',
					data : JSON.stringify({
						bno : bno,
						replyer : replyer,
						replytext : replytext
					}),
					success : function(result){
						$("#replyer").val(""); <!-- 글을 입력한뒤 비게하려구!  -->
						$("#replytext").val("");

						getList(bno); <!-- 곧바로 추가되게 -->
					},
					error : function(request, status, error) {
						console.log(error);
					}
				});
			});

			$("#replies").on("click", ".replymodify", function(){
				var rno = $(this).attr("data-rno")  <!-- 지금 클릭한 요소의 속성값 -->
				
			});

			$("#replies").on("click", ".replydelete", function(){
				var rno = $(this).attr("data-rno")  <!-- 지금 클릭한 요소의 속성값 -->
				alert(rno + "삭제버튼");
			});
		}); 

		function getList(bno){

			var str = '';
			
			$.getJSON("/replies/all/" + bno, function(data){
				
				for(var i = 0; i < data.length; i++) { <!-- 파싱해버리기! 데이터 쪼개기 -->
					str += '<div class="panel panel-primary"><div class="panel-heading"><span>rno: ' + data[i]["rno"] + '</span>, <sapn>작성자: ' + data[i]["replyer"] + '</sapn><span class="pull-right"> ' + data[i]["updatedate"] + '</span></div><div class="panel-body"><p>' + data[i]["replytext"] + '</p><button data-rno="' + data[i]["rno"] + '" class="btn btn-primary btn-xs replymodify">수정</button><button data-rno="' + data[i]["rno"] + '" class="btn btn-primary btn-xs replydelete">삭제</button></div></div>'; 		
				}

				$("#replies").html(str);
				
			});
		}
	</script>
</body>
</html>