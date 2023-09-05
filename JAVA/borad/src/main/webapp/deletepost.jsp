<%@page import="database.DB"%>
<%@page import="java.util.*"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("num");
	String userID = (String) session.getAttribute("userID");
	String userROLE = (String) session.getAttribute("userROLE");
	try {
		DB.result = DB.st.executeQuery("select * from board where b_no=" + no);
		DB.result.next();
		String num = DB.result.getString("b_no");
		String writer = DB.result.getString("b_writer");
		if(!userID.equals(writer) && !userROLE.equals("staff")) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('권한이 없습니다')");
			script.println("location.href='Board.jsp'");
			script.println("</script>");
		} else {
			DB.st.executeUpdate("delete from board where b_no = " + no);
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('게시글이 삭제되었습니다')");
			script.println("location.href='board.jsp'");
			script.println("</script>");
		}
	} catch (Exception e) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('삭제에 실패했습니다')");
		script.println("history.back()");
		script.println("</script>");
		e.printStackTrace();
	}
	%>
</body>
</html>