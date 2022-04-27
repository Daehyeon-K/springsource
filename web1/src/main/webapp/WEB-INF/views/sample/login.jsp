<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login</h1>
	<!-- action 뭐 안쓰면 그냥 현재 경로 -->
	<form action="" method="post">
		<div>
			<label for="userid">userid</label>
			<input type="text" name="userid" id="userid" />
		</div>
		<div>
			<label for="password">password</label>
			<input type="password" name="password" id="password" />
		</div>
		<!-- <div>
			<label for="addr">addr</label>
			<input type="text" name="addr" id="addr" />
		</div>
		<div>
			<label for="age">age</label>
			<input type="text" name="age" id="age" />
		</div> -->
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
	<div>
		<%-- 모든 요청은 컨트롤러로 가야 함 --%>
		<p><a href="basic">basic</a></p>
		<p><a href="doA">doA</a></p>
		<p><a href="/">home</a></p>
		<p><a href="insert">insert</a></p>
	</div>
</body>
</html>