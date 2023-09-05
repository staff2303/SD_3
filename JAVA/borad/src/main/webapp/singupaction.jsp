<%@page import="database.DB"%>
<%@page import="java.util.*"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 액션</title>
</head>
<body>
	<%
	Class.forName("com.mysql.jdbc.Driver");
	DB.run();
	request.setCharacterEncoding("utf-8");

	String userNAME = request.getParameter("name");
	String userID = request.getParameter("id");
	String userPW = request.getParameter("pw");
	String userCPW = request.getParameter("cpw");
	int cho = DB.singup(userNAME, userID, userPW, userCPW);
	
	if (cho == 0) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('존재하는 아이디입니다.')");
		script.println("history.back()");
		script.println("</script>");
	} else if (cho == 1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('회원가입완료.')");
		script.println("location.href = 'login.jsp'");
		script.println("</script>");
	} else if (cho == -1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('비밀번호가 같지않습니다.')");
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