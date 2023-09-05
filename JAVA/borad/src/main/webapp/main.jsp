<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<title>JSP 게시판</title>
<link rel="stylesheet" href="css/main.css" />
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
</head>

<body class="homepage is-preload">
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
								<li class="current_page_item"><a href="main.jsp">Home</a></li>
								<li><a href="board.jsp">Board</a></li>
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
		<div id="footer-wrapper">
			<footer id="footer" class="container">
				<div class="row">
					<div class="col-3 col-6-medium col-12-small">
						<section>
							<h2>메인화면</h2>
							<ul class="divided">
								<li><a href="#">꾸미기가 귀찮아요</a></li>
								<li><a href="#">아이디어 있으면</a></li>
								<li><a href="#">게시판에 적어줘요</a></li>
							</ul>
						</section>
					</div>
					<div class="col-6 col-12-medium imp-medium">
						<section>
							<h2>
								<strong>JSP로만든 사이트 입니다</strong> by staff2303
							</h2>
							<p>
								안녕하세요! <strong>staff2303</strong>입니다! 로그인후 게시판 이용 가능합니다!
							</p>
						</section>

						<!-- Contact -->
						<section>
							<h2>staff2303</h2>
							<div>
								<div class="row">
									<div class="col-6 col-12-small">
										<dl class="contact">
											<dt>Email</dt>
											<dd>
												<a href="#">staff2303@gmail.com</a>
											</dd>
											<dt>Github</dt>
											<dd>
												<a href="https://github.com/staff2303">staff2303</a>
											</dd>
										</dl>
									</div>
									<div class="col-6 col-12-small">
										<dl class="contact">
											<dt>Address</dt>
											<dd>
												경기도 부천시<br />부천역근처<br /> korean
											</dd>
											<dt>Phone</dt>
											<dd>010-7161-5660</dd>
										</dl>
									</div>
								</div>
							</div>
						</section>
					</div>
					<div class="col-12">
						<div id="copyright">
							<ul class="menu">
								<li>&copy; Untitled. All rights reserved</li>
							</ul>
						</div>
					</div>
				</div>
			</footer>
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