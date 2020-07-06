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
	<button class="btn">rt2</button>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("body").on("click", ".btn", function(){
				var test1 = "hello";
				var test2 = "world";

				$.ajax({
					type: 'post',
					url: "rt2",
					headers: {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'POST'
					},
					dataType: 'text',
					data: JSON.stringify({
						test1 : test1, // 속성명 :속성값
						test2 : test2
					}),
					success : function(result){
						
						console.log(result);
					
						var obj = JSON.parse(result);

						console.log(obj['test1'])
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