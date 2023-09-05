<%@page import="database.DB"%>
<%@page import="java.util.*"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<title>JSP 게시판</title>
<link rel="stylesheet" href="css/main.css" />
<script>
	function adjustTextareaHeight(textarea) {
		textarea.style.height = "auto";
		textarea.style.height = textarea.scrollHeight + "px";
	}
</script>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
String userID = null;
if (session.getAttribute("userID") != null) {
	userID = (String) session.getAttribute("userID");
}
if (userID == null) {
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('로그인이 필요합니다')");
	script.println("location.href='login.jsp'");
	script.println("</script>");
}
%>
</head>
<body class="homepage">
	<div id="page-wrapper">
		<div id="header-wrapper">
			<div class="container">
				<header id="header">
					<div class="inner">
						<h1>
							<a href="main.jsp" id="logo">JSP BOARD</a>
						</h1>
						<nav id="nav">
							<ul>
								<li><a href="main.jsp">Home</a></li>
								<li class="current_page_item"><a href="board.jsp">Board</a></li>
								<li><a href="#">GAME</a></li>
								<li>[ <%=session.getAttribute("userID")%> ] 등급 : <%=session.getAttribute("userROLE")%></li>
								<li><a href="logout.jsp">LOGOUT</a></li>
							</ul>
						</nav>
					</div>
				</header>
			</div>
		</div>
		<div id="main-wrapper">
			<div class="inner">
				<section class="container box feature1">
					<form action="writepost.jsp" method="post">
						<table style="text-align: center; border: 1px solid #ffffff">
							<tr>
								<th colspan="3"
									style="background-color: #45474c; text-align: center;">게시글
									작성</th>
							</tr>
							<tr>
								<td
									style="background-color: #45474c; text-align: center; width: 10%">제목</td>
								<td style="background-color: #45474c; text-align: left;"><input
									type="text" style="color: #000000; width: 100%" name="title" required></td>
								<td
									style="background-color: #45474c; text-align: center; width: 10%"></td>
							</tr>
							<tr>
								<td style="background-color: #45474c; text-align: center;">작성자</td>
								<td style="background-color: #45474c; text-align: left;"><%=session.getAttribute("userID")%></td>
								<td
									style="background-color: #45474c; text-align: center; width: 10%"></td>
							</tr>
							<tr>
								<td style="background-color: #45474c; text-align: center;">내용</td>
								<td style="background-color: #45474c; text-align: left;"><textarea
										style="color: #000000; width: 100%; resize: none;" name="content"
										oninput="adjustTextareaHeight(this)" required></textarea></td>
								<td
									style="background-color: #45474c; text-align: center; width: 10%"></td>
							</tr>
							<tr>
								<td colspan="3" style="background-color: #45474c;"><input
									type="submit" value="작성" onclick="return confirm('게시글을 등록 하시겠습니까?')" class="paging-button"></td>
							</tr>
						</table>
					</form>
				</section>
			</div>
		</div>
	</div>
	<!-- Scripts -->
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.dropotron.min.js"></script>
	<script src="js/breakpoints.min.js"></script>
	<script src="js/util.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
