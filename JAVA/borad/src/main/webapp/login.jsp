<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="css/Login.css">
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
</head>

<body>
	<%
	String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	if (userID != null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 로그인이 되어 있습니다')");
		script.println("location.href='main.jsp'");
		script.println("</script>");
	}
	%>
	<div class="container">
		<div class="container">
			<h1>
				<a href="main.jsp" id="logo">JSP BOARD</a>
			</h1>
		</div>
		<h1>로그인</h1>
		<form method="post" action="loginaction.jsp">
			<div class="form-control">
				<input type="text" name="id" required /> <label>Id</label>
			</div>
			<div class="form-control">
				<input type="password" name="pw" required /> <label>Password</label>
			</div>
			<input type="submit" class="btn" value="로그인">
			<p class="text">
				계정이 없나요? <a href="singup.jsp">회원가입</a>
			</p>
		</form>
		<div style="text-align: center;">
			<span id="clock" style="color: gray; font-size: 60px;"></span> <span
				id="apm" style="color: gray; font-size: 30px;"></span>
		</div>
	</div>
	<script src="js/index.js"></script>
	<script src="js/time.js"></script>
</body>
</html>