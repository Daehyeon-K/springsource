<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	
	<div>
		age : <%=request.getParameter("age") %>
	</div>
	<div>
		num : ${num}
	</div>
	
	<ul>
		<div>
			<li>userid : ${user.userid}</li>
			<li>password : ${user.password}</li>
		</div>
	</ul>

	<div>
		<%-- 모든 요청은 컨트롤러로 가야 함 --%>
		<p><a href="/sample/basic">basic</a></p>
		<p><a href="/sample/doA">doA</a></p>
		<p><a href="/sample/login">login</a></p>
		<p><a href="/sample/insert">insert</a></p>
		<p><a href="/board/list">@TO THE BOARD SECTION!!@</a></p>
	</div>
</body>
</html>
