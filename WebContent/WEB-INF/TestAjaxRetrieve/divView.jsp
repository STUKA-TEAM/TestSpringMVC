<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<div id = "retrieved">
Hello Ajax!
Data From Model:
<c:out value = "${user.name}" />
<c:forEach items = "${user.girlFriends}" var = "girlFriend" >
<c:out value = "${girlFriend}"/>
</c:forEach>
</div>
