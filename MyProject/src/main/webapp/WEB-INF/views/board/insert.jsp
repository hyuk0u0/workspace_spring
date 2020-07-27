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
			$("#submit").on("click", function(){
				if($("#title").val()==""){
					alert("제목을 입력해주세요.");
					$("#title").focus();
					return false;
				}
					$("#insertForm").submit();
				
			});
		});
	</script>
<body>
	<div class="container">
		<div class="row text-center">
			<h1>글쓰기</h1>
		</div>
		<div class="row">
			<form action="/board/insert" method="post" class="insertForm">
				<div class="form-group">
					<label for="title">제목</label>
					<input name="title" id="title" class="form-control">
				</div>
				<div class="form-group">
					<label for="writer">작성자</label>
					<input name="writer" id="writer" class="form-control" value="${dto.userId}(${dto.name})" readonly>
				</div>
				<div class="form-group">
					<label for="content">내용</label>
					<textarea rows="5" name="content" id="content" class="form-control"></textarea>
				</div>
			</form>
			<div class="form-group">
				<label>첨부파일</label>
				<div class="fileDrop"></div>
				<ul class="uploadedList clearfix"></ul>
			</div>
			<div class="form-group">
				<button class="btn btn-primary" id="insertbtn">등록</button>
				<button class="btn btn-primary" id="mainPagebtn">뒤로가기</button>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#insertbtn").click(function(event){
				event.preventDefault();
				
				if($("#title").val()==""){
					alert("제목을 입력해주세요.");
					$("#title").focus();
					return false;
				}
				
				var str = '';
	
				$(".deletefile").each(function(index){
					str += "<input name='files[" + index + "]' value='" + $(this).attr("href") + "' type='hidden'>";
				});
	
				$("form").append(str);
				$("form").submit();
			});

			$("#mainPagebtn").click(function(){
				location.assign("/board/mainPage");
			});

			$(".fileDrop").on("dragenter dragover", function(event){
				event.preventDefault();
			});

			$(".fileDrop").on("drop", function(event){
				event.preventDefault();

				var files = event.originalEvent.dataTransfer.files;

				var file = files[0];

				var formData = new FormData();
				formData.append("file", file);

				$.ajax({
					type : 'post',
					url : '/uploadajax',
					dataType : 'text',
					data : formData,
					processData : false,
					contentType : false,
					success : function(result) {

						var str = '<li class="col-xs-4">';
						str += '<a href="/displayfile?filename=' + getImageLink(result) + '">';
					}
				});
				
			});


			
		});
	</script>
</body>
</html>