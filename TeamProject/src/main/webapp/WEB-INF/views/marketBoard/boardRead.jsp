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
		.uploadedList {
			margin-top: 50px;
		}
		
		.uploadedList li { /*  리스트에 불릿을 없애줬다 ! */
			list-style: none;  
		}
	</style>
</head>
<body>
	
	${boardCategoryToyDTO.cname}
	${boardCategoryToyDTO}
	
	<div class="container">
		<div class="row text-center">
			<h1>글 자세히 보기</h1>
		</div>
		<div class="form-group">
			<label for="title">제목</label>
			<input class="form-control" value="${boardCategoryToyDTO.title}" readonly>
		</div>
		<div class="form-group">
			<label for="gname">상품명</label>
			<input class="form-control" value="${boardCategoryToyDTO.gname}" readonly>
		</div>
		<div class="form-group">
			<label for="price">가격</label>
			<input class="form-control" value="${boardCategoryToyDTO.price}" readonly>
		</div>
		<div class="row">
			<div class="form-group">
				<label>사진</label>
				<ul class="uploadedList clearfix"></ul>
			</div>
		</div>
		<div class="row purchase_row">
			<form action="/marketBoard/purchase" method="post">
				<input type="hidden" name="bno" value="${boardCategoryToyDTO.bno}">
				<input type="hidden" name="id" value="m001">
				<input type="hidden" name="cno" value="${boardCategoryToyDTO.cno}">
				<input type="hidden" name="gno" value="${boardCategoryToyDTO.gno}">
			</form>
			<button class="btn btn-primary btn_purchase">구매</button>
		</div>
	
	</div>
	
	<script type="text/javascript">

		var bno = ${boardCategoryToyDTO.bno};
		
		
		$(document).ready(function(){
			
			$.getJSON("/getUpload/" + bno, function(arr) {
				
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

			$(".purchase_row").on("click", ".btn_purchase",function(event){
				event.preventDefault();

				var isOk = confirm("정말 구매하시겠습니까?");

				if (isOk) {
					var that = $(this);

					$("form").submit();
				}
			});

			
		});

	
	</script>
	
	
	
</body>
</html>