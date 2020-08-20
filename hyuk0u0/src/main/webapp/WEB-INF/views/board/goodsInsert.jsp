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
			<form action="/board/goodsInsert" method="POST" id="goodsForm">
				<h3>상품 등록</h3>
				<hr>
				<div class="form-group">
					<select name="categoryNum" id="categoryNum">
						<option value="" selected="selected">카테고리 선택</option>
						<c:forEach items="${categoryList}" var="categoryDTO">
							<option value="${categoryDTO.categoryNum}">${categoryDTO.categoryName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="goodsName">상품 이름</label>
					<input class="form-control" name="goodsName" id="goodsName">
				</div>
				<div class="form-group">
					<label for="price">가격</label>
					<input class="form-control" name="price" id="price">
				</div>
			</form>
			<div class="form-group">
				<button class="btn btn-primary" type="button" id="submit">등록</button>
				<button class="cencle btn btn-primary" type="button">취소</button>
			</div>
			<h3>상품 조회</h3>
			<hr>
			<select id="select1" onchange="javascript:itemChange(this);" name="categoryNum">
				<option value="" selected="selected">카테고리 선택</option>
					<c:forEach items="${categoryList}" var="categoryDTO">
						<option value="${categoryDTO.categoryNum}">${categoryDTO.categoryName}</option>
					</c:forEach>
			</select>
			<table class="table">
				<thead>
					<tr>
						<th>상품 번호</th>
						<th>상품 이름</th>
						<th>가격</th>
					</tr>
				</thead>
				<tbody id="select2">
					
				</tbody>
			</table>
		</div>
	</div>
	
	
	
	<jsp:include page="../includes/footer.jsp" />
	
	<script type="text/javascript">
		$(document).ready(function(){
			//취소
			$(".cencle").on("click", function(){
				location.href = "/board/adminPage";
			});


			$("#submit").on("click", function(){
				if($("#categoryNum").val() == ""){
					alert("카테고리를 선택해주세요.");
					$("#categoryNum").focus();
					return false;
				}
				
				if($("#goodsName").val() == ""){
					alert("상품 이름을 입력해주세요.");
					$("#goodsName").focus();
					return false;
				}

				if($("#price").val() == ""){
					alert("가격을 입력해주세요.");
					$("#price").focus();
					return false;
				}
				$("#goodsForm").submit();
				
			});			
		});

		function itemChange(obj) {
			var categoryNum = obj.value;
			if (categoryNum == "") {
				return false;
			}
			$.ajax({
				type : 'post',
				url : '/board/selectGoods',
				dataType : 'text',
				data : {
					categoryNum : categoryNum
				},
				success : function(result){
					var obj = JSON.parse(result);

					$('#select2').empty();
					var str = "";
					
					
						
					for (var i = 0; i < obj.length; i++) {
						str += "<tr>";
						str += "<td>" + obj[i]["goodsNum"] + "</td>";
						str += "<td>" + obj[i]["goodsName"] + "</td>";
						str += "<td>" + obj[i]["price"] + "</td>";
						str += "</tr>";
					}

					
					$("#select2").append(str);
				}
			})
		}
	</script>
</body>
</html>