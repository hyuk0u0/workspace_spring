<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
리턴형식에 String을 사용하지 않고 void를 사용한 경우<br>
<%
for(int i = 1 ; i < 11; i++){
	out.print(i+"&nbsp;");
}

%>
</body>
</html>