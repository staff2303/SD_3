<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean class="com.bean.Testbean" id="test" scope="page" />
<jsp:setProperty property="user_id" name="test" param="user_id" />
<jsp:setProperty property="user_pw" name="test" param="user_pw" />
<%-- <jsp:setProperty property="*" name="test" /> <<이거 사용시 get에 적용한 name이 class변수와 이름이 같으면 적용 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : <jsp:getProperty property="user_id" name="test" /><br>
	비밀번호 : <jsp:getProperty property="user_pw" name="test" /><br>
</body>
</html>