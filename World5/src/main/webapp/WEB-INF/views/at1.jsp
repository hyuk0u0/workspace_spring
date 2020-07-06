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
	<button>at1 test</button>
	<p></p>
	
	
	
	
	
	
	
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("button").click(function() {
				$.ajax({ //ajax 통신을 하겠다!
					type : 'post',
					url : '/at1',
					dataType: 'text', //문자열!
					data : {
						'msg' : 'hello'	
					},
					success : function(result) {
						console.log(result);
						
						$("p").text(result);
						//var msg = ${"p"}.text(); //p태그 안에 있는 내용을 msg에 넣어라!
					},
					error : function(request, status, error) { // 실패했을때!
						console.log("code:" + request.status + "\n" + "msg:" + request.responseText + "\n" + "error:" + error);
					},
					complete : function() {
						alert('ok');
					} // 약간 finally랑 같음 무조건 뜨게하는거!
									
				}); 
			});
		});
	</script>
	
	
	
	
	
</body>
</html>