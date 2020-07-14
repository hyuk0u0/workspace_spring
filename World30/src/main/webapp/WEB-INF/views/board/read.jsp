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
	
	<script src="/resources/js/uploadfn.js" type="text/javascript"></script>
	
	<title>Insert title here</title>
	<style type="text/css">
		.fileDrop {
			width: 80%;
			height: 200px;
			border: 1px solid red;
			margin: auto; /* 가운데정렬 */
		}
		
		.uploadedList {
			margin-top: 50px;
		}
		
		.uploadedList li { /*  리스트에 불릿을 없애줬다 ! */
			list-style: none;  
		}
		
		.orifilename {
			overflow: hidden;
			white-space: nowrap;
			text-overflow: ellipsis;
		}
	</style>
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
				<label>첨부파일</label>
				<ul class="uploadedList clearfix"></ul>
			</div>
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
  					<button data-name="홍길동" class="btn btn-primary btn-xs">수정</button>
  					<button class="btn btn-primary btn-xs">삭제</button>
  				</div>
			</div>
		</div>
		<div class="row">
			<div data-backdrop="static" id="myModal" class="modal fade" tabindex="-1" role="dialog"> <!-- data-backdrop="static" 클로즈 눌렀을때만 모달이 꺼짐 -->
				<div class="modal-dialog" role="document">
			  		<div class="modal-content">
			    		<div class="modal-header">
			      			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			      			<h4 class="modal-rno">rno 데이터</h4>
			    		</div>
			    		<div class="modal-body">
			    			<p class="modal-replyer">홍길동</p>
			     	 		<input class="modal-replytext form-control" value="댓글내용입니다."/>
			   	 		</div>
			  	  		<div class="modal-footer">
			      			<button type="button" class="btn btn-primary modal-update-btn" data-dismiss="modal">댓글 수정</button>
			    		</div>
			  		</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
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
				var replyer = $(this).attr("data-name");
				var replytext = $(this).prev().text(); <!-- 방금 누른 버튼의 앞에놈을 가르킴 -->

				$(".modal-rno").text(rno);
				$(".modal-replyer").text(replyer);
				$(".modal-replytext").val(replytext);

				$("#myModal").modal("show");
			});

			$("#replies").on("click", ".replydelete", function(){
				var rno = $(this).attr("data-rno")  <!-- 지금 클릭한 요소의 속성값 -->

				$.ajax({
					type : 'delete',
					url : '/replies',
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "DELETE"
					}, 
					dataType : 'text',
					data : JSON.stringify({
						rno : rno
					}),
					success : function(result) {
						if(result === "success") {
							getList(bno);
						}
					},
					error : function(request, status, error) {
						console.log(error);
					}
				});
			});

			$(".modal-update-btn").click(function(){
				var rno = $(".modal-rno").text();
				var replytext = $(".modal-replytext").val();

				$.ajax({
					type : 'put',
					url : '/replies/' + rno,
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "PUT"
					},
					dataType : 'text',
					data : JSON.stringify({
						replytext : replytext
					}),
					success : function(result){
						if(result === "success") { <!-- 자바스크립트에서 === 값과 타입이 같아야 true-->
							getList(bno);
						} 
					},
					error : function(request, status, error) {
						console.log(error);
					}
				});
			});

			$.getJSON("/getAttach/" + bno, function(arr) {

				for(var i = 0; i < arr.length; i++) {
					
				var str = '<li class="col-xs-4">';
				str += '<a herf="/displayfile?filename=' + getImageLink(arr[i]) + '">';
				if(checkImage(arr[i])) {
					str += '<img src="/displayfile?filename=' + arr[i] + '"/>';
				} else {
					str += '<img src="/resources/show.png"/>';
				}						
				str += '</a>';
				str += '<p class="orifilename">';
				str += getOriginalName(arr[i]);
				str += '</p>';
				str += '</li>';
			
				
				$(".uploadedList").append(str);
				}
				
			});
			
		}); 

		function getList(bno){

			var str = '';
			
			$.getJSON("/replies/all/" + bno, function(data){
				
				for(var i = 0; i < data.length; i++) { <!-- 파싱해버리기! 데이터 쪼개기 -->
					str += '<div class="panel panel-primary"><div class="panel-heading"><span>rno: ' + data[i]["rno"] + '</span>, <sapn>작성자: ' + data[i]["replyer"] + '</sapn><span class="pull-right"> ' + data[i]["updatedate"] + '</span></div><div class="panel-body"><p>' + data[i]["replytext"] + '</p><button data-name"' + data[i]["replyer"] + '" data-rno="' + data[i]["rno"] + '" class="btn btn-primary btn-xs replymodify">수정</button>&nbsp;<button data-rno="' + data[i]["rno"] + '" class="btn btn-primary btn-xs replydelete">삭제</button></div></div>'; 		
				}

				$("#replies").html(str);
				
			});
		}
	</script>
</body>
</html>