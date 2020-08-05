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

</head>
<body>
	<jsp:include page="header.jsp"/>

	
	
	<a href="/board/insert">글쓰기</a>
	

	
	<div class="container">
		<div class="panel">
			<div class="panel-heading">
				<h3 class="text-center"><a href="#">모든 상품</a></h3>
			</div>
			<div class="panel-body">
				<div class="row">
					<c:forEach items="${boardList}" var="boardDTO">
						<div class="col-md-3">
							<div class="thumbnail">
								<a href="/board/read/${boardDTO.bno}">
									<img src="../resources/show.png" style="width: 100%; height: 200px;">	
								</a>
								<hr>
								<div class="caption">
									<h5><a href="/board/read/${boardDTO.bno}">${boardDTO.title}</a></h5>
									<p class="text-right">${boardDTO.price}원</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<jsp:include page="footer.jsp"/>
	
	
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