<%@page import="database.DB"%>
<%@page import="java.util.*"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 액션</title>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
</head>
<body>
	<%
	Class.forName("com.mysql.jdbc.Driver");
	DB.run();
	request.setCharacterEncoding("utf-8");

	String userID = request.getParameter("id");
	String userPW = request.getParameter("pw");
	String ID = "";
	String ROLE = "";
	int cho = DB.login(userID, userPW);

	if (cho == 1) {
		try {
			DB.result = DB.st.executeQuery("select * from member where m_id='" + userID + "'");
			DB.result.next();
			ID = DB.result.getString("m_id");
			ROLE = DB.result.getString("m_role");
			session.setAttribute("userID", ID);
			session.setAttribute("userROLE", ROLE);
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('" + ID + " 님 환영합니다! 등급 : " + ROLE + "')");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} else if (cho == 0) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('비밀번호가 틀립니다.')");
		script.println("history.back()");
		script.println("</script>");
	} else if (cho == -1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('존재하지 않는 아이디입니다.')");
		script.println("history.back()");
		script.println("</script>");
	} else if (cho == -2) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('데이터베이스 오류가 발생했습니다.')");
		script.println("history.back()");
		script.println("</script>");
	}
	%>
</body>
</html>