<%@page import="database.DB"%>
<%@page import="java.util.*"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	
	String title = request.getParameter("title");
	String userID = (String)session.getAttribute("userID");
	String content = request.getParameter("content");
	
	int cho = DB.post(title, userID, content);
	if(cho == -1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('글쓰기에 실패했습니다')");
		script.println("history.back()");
		script.println("</script>");
	}else {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('게시글이 등록되었습니다')");
		script.println("location.href='board.jsp'");
		script.println("</script>");
	}
	%>
</body>
</html>