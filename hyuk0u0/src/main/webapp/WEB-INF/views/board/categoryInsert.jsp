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
			<h3>카테고리 등록</h3>
			<hr>
			<form action="/board/categoryInsert" method="POST" id="categoryForm">
				<div class="form-group">
					<label for="categoryName">카테고리명</label>
					<input class="form-control" id="categoryName" name="categoryName">
				</div>
			</form>
			<div class="form-group">
				<button class="btn btn-primary" type="button" id="submit">등록</button>
				<button class="cencle btn btn-primary" type="button">취소</button>
			</div>
			<hr>
			<h3>카테고리 조회</h3>
			<hr>
			<table class="table">
				<thead>
					<tr>
						<th>카테고리 번호</th>
						<th>카테고리 이름</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categoryList}" var="categoryDTO">					
						<tr>
							<td>${categoryDTO.categoryNum}</td>
							<td>${categoryDTO.categoryName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<c:if test="${!empty msg}">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
	
	<jsp:include page="../includes/footer.jsp" />
	
	<script type="text/javascript">
		$(document).ready(function(){
			//취소
			$(".cencle").on("click", function(){
				location.href = "/board/adminPage";
			});


			$("#submit").on("click", function(){
				if($("#categoryName").val() == ""){
					alert("카테고리를 입력해주세요");
					$("#categoryName").focus();
					return false;
				}

				$("#categoryForm").submit();
				
			});
		});

	</script>
</body>
</html>