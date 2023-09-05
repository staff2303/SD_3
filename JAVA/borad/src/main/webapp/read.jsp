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
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
String userID = null;
String userROLE = null;
if (session.getAttribute("userID") != null) {
	userID = (String) session.getAttribute("userID");
}
if (session.getAttribute("userROLE") != null) {
	userROLE = (String) session.getAttribute("userROLE");
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
					<table style="text-align: center; border: 1px solid #dddddd">
						<thead>
							<tr>
								<th
									style="background-color: #45474c; text-align: center; width: 10%">번호</th>
								<th
									style="background-color: #45474c; text-align: center; width: 50%">제목</th>
								<th
									style="background-color: #45474c; text-align: center; width: 10%">작성자</th>
								<th
									style="background-color: #45474c; text-align: center; width: 10%">조회수</th>
								<th
									style="background-color: #45474c; text-align: center; width: 20%">작성일</th>
							</tr>
						</thead>
						<tbody>
							<%
							String readNum = request.getParameter("num");
							try {
								DB.result = DB.st.executeQuery("select * from board where b_no=" + readNum);
								DB.result.next();
								String no = DB.result.getString("b_no");
								String title = DB.result.getString("b_title");
								String writer = DB.result.getString("b_writer");
								String hits = DB.result.getString("b_hits");
								String date = DB.result.getString("b_date");
								String content = DB.result.getString("b_content");
							%>
							<tr>
								<td><%=no%></td>
								<td><%=title%></td>
								<td><%=writer%></td>
								<td><%=hits%></td>
								<td><%=date%></td>
							</tr>
							<tr>
								<th style="background-color: #45474c; text-align: center;"
									colspan="5">내용</th>
							</tr>
							<tr>
								<td colspan="5"><%=content%></td>
							</tr>
							<%
							} catch (Exception e) {
							e.printStackTrace();
							}
							%>
						</tbody>
					</table>
					<a href="board.jsp" class="paging-button">목록</a>
					<%
					if (userID.equals(DB.result.getString("b_writer")) || userROLE.equals("staff")) {
					%>
					<a href="update.jsp?num=<%=readNum%>" class="paging-button">수정</a>
					<a href="deletepost.jsp?num=<%=readNum%>"
						onclick="return confirm('삭제하시겠습니까?')" class="paging-button">삭제</a>
					<%
					}
					%>
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