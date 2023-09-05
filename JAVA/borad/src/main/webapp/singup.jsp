<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="css/Singup.css">
</head>

<body>
	<div class="container">
		<div class="container">
			<h1>
				<a href="main.jsp" id="logo">JSP BOARD</a>
			</h1>
		</div>
		<h1>회원가입</h1>
		<form method="post" action="singupaction.jsp">
			<div class="form-control">
				<input type="text" name="name" required> <label>Name</label>
			</div>
			<div class="form-control">
				<input type="text" name="id" required> <label>Id</label>
			</div>
			<div class="form-control">
				<input type="password" name="pw" required> <label>Password</label>
			</div>
			<div class="form-control">
				<input type="password" name="cpw" required> <label>Confirm
					Password</label>
			</div>
			<input type="submit" class="btn" value="회원가입">
			<button class="btn" type="reset">리셋</button>
			<div style="text-align: center;">
				<span id="clock" style="color: gray; font-size: 60px;"></span> <span
					id="apm" style="color: gray; font-size: 30px;"></span>
			</div>
		</form>
	</div>
	<script src="js/index.js"></script>
	<script src="js/time.js"></script>
</body>
</html>