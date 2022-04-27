<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>basic</h1>
	<div>
	
	<%-- 경로 시작 시 /로 시작하는 건
		 http://loaclhost:9090 뒤에서 주소 붙여나가는 것
		 절대주소의 의미
		 
		 /가 없는 경우는 주소 상에서 / 앞까지, 현재 주소에서 뒷부분만 변경하는 것
		 
	 --%>
	 	<p>${page}</p>
	
		<%-- 모든 요청은 컨트롤러로 가야 함 --%>
		<p><a href="/">home</a></p>
		<p><a href="doA">doA</a></p> <%-- /sample/doA 도 가능 --%>
		<p><a href="login">login</a></p> <%-- /sample/login 도 가능 --%>
		<p><a href="insert">insert</a></p> <%-- /sample/insert 도 가능 --%>		
	</div>
</body>
</html>