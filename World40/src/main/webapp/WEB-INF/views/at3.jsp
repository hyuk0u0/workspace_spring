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
	
	<button id="btn">at3 test</button>
	
	<p class="name"></p>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btn").click(function(){
				$.ajax({
					type : 'post',
					url : 'at3',
					dataType : 'text',
					data : {
						'id' : 'm004',
						'name' : '김',
						'age' : 33
						
					},
					success : function(result) {
						console.log(result);
						
						var obj = JSON.parse(result); // JSON으로 되어있는 형태는 이렇게 받아준다!
						console.log(obj.id);
						console.log(obj.name);
						console.log(obj.age);
						
						$(".name").text(obj.name);
					},
					error : function(request, status, error) {
						console.log(error);
					}
				});
			});
		});
	</script>
</body>
</html>