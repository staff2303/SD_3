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
Class.forName("com.mysql.jdbc.Driver");
DB.run();
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
								<%
								if (session.getAttribute("userID") == null) {
								%>
								<li><a href="login.jsp">LOGIN</a></li>
								<%
								} else {
								%>
								<li>[ <%=session.getAttribute("userID")%> ] 등급 : <%=session.getAttribute("userROLE")%></li>
								<li><a href="logout.jsp">LOGOUT</a></li>
								<%
								}
								%>
							</ul>
						</nav>
					</div>
				</header>
			</div>
		</div>
		<div id="main-wrapper">
			<div class="inner">
				<section class="container box feature1">
					<div class="search">
						<form method="GET">
							<input type="search" name="search" placeholder="제목 검색" 
								style="background-color: #45474c; margin-right: 10px;" />
							<button type="submit" class="write-link">검색</button>
						</form>
					</div>
					<table style="text-align: center; border: 1px solid #dddddd">
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
						<tbody>
							<%
							int pageSize = 10; // 페이지당 게시물 수
							int currentPage = 1; // 현재 페이지 (기본값 1)
							int totalPage = 1;
							if (request.getParameter("page") != null) {
								currentPage = Integer.parseInt(request.getParameter("page"));
							}
							int startRow = (currentPage - 1) * pageSize; // 시작 행

							try {
								// 전체 게시물 수 조회
								DB.result = DB.st.executeQuery("SELECT COUNT(*) AS count FROM board");
								int totalCount = 0;
								if (DB.result.next()) {
									totalCount = DB.result.getInt("count");
								}

								// 전체 페이지 수 계산
								totalPage = (int) Math.ceil((double) totalCount / pageSize);

								String search = request.getParameter("search");
								if (search != null && !search.isEmpty()) {
									DB.result = DB.st.executeQuery("SELECT * FROM board WHERE b_title LIKE '%" + search + "%' ORDER BY b_no DESC LIMIT " + startRow + ", " + pageSize);
								} else {
									DB.result = DB.st.executeQuery("SELECT * FROM board ORDER BY b_no DESC LIMIT " + startRow + ", " + pageSize);
								}
								while (DB.result.next()) {
									String no = DB.result.getString("b_no");
									String title = DB.result.getString("b_title");
									String writer = DB.result.getString("b_writer");
									String hits = DB.result.getString("b_hits");
									String date = DB.result.getString("b_date");
							%>
							<tr>
								<td><%=no%></td>
								<td><a href="read.jsp?num=<%=no%>"><%=title%></a></td>
								<td><%=writer%></td>
								<td><%=hits%></td>
								<td><%=date%></td>
							</tr>
							<%
							}
							} catch (Exception e) {
							e.printStackTrace();
							}
							%>
						</tbody>
					</table>
					<div class="paging">
						<%
						// 이전 페이지 링크
						if (currentPage > 1) {
						%>
						<a href="board.jsp?page=<%=currentPage - 1%>"
							class="paging-button">이전</a>
						<%
						}

						// 페이지 번호 링크
						for (int i = 1; i <= totalPage; i++) {
						if (i == currentPage) {
						%>
						<span class="current-page"><%=i%></span>
						<%
						} else {
						%>
						<a href="board.jsp?page=<%=i%>" class="paging-link"><%=i%></a>
						<%
						}
						}

						// 다음 페이지 링크
						if (currentPage < totalPage) {
						%>
						<a href="board.jsp?page=<%=currentPage + 1%>"
							class="paging-button">다음</a>
						<%
						}
						%>
						<div class="write-button">
							<a href="write.jsp" class="write-link">글쓰기</a>
						</div>
					</div>
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
