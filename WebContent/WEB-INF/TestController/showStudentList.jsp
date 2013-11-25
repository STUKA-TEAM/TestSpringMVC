<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<c:forEach items="${studentList}" var="student">
    <c:if test = "${student.school == 'SEU'}">
	Student Name: <c:out value = "${student.name}"/> || Student School: <c:out value = "${student.school}" />
	<br/>
	</c:if>
</c:forEach>
</body>
</html>