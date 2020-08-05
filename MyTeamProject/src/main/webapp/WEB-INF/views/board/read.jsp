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
			<h1>글쓰기</h1>
		</div>
		<div class="row">
				<div class="form-group">
					<label for="title">제목</label>
					<input name="title" id="title" class="form-control">
				</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label>첨부파일</label>
				<ul class="uploadedList clearfix"></ul> <!-- 사진 위로 침범방지 -->
			</div>
		</div>
		<div class="form-group">
			<button class="btn btn-primary" id="update">수정</button>
			<button class="btn btn-primary" id="delete">삭제</button>
			<button class="btn btn-primary" id="mainPage">목록</button>
		</div>
	</div>
	
	<script type="text/javascript">
		var bno = ${boardDTO.bno};
		
		$(document).ready(function(){
			$("#update").click(function(){
				location.assign("/board/update/${vo.bno}");
			});

			$("#delete").click(function(){
				location.assign("/board/delete/${vo.bno}");
			});

			$("#mainPage").click(function(){
				location.assign("/board/mainPage");
			});
			
			$.getJSON("/getAttach/" + bno, function(arr) {

				
				console.log(arr[0]);
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
	</script>
</body>
</html>