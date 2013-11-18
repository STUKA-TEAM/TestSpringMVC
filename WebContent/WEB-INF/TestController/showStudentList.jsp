<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${studentList}" var="student">
    <c:if test = "${student.school == 'SEU'}">
	Student Name: <c:out value = "${student.name}"/> || Student School: <c:out value = "${student.school}" />
	<br/>
	</c:if>
</c:forEach>
</body>
</html>