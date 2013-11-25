<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<button id="showInfo" type="button">触发AJAX</button>
<div id = "info_block"></div>
</body>

<script src = "../js/jquery-1.10.2.min.js"></script>
<script type = "text/JavaScript">
var userinfo = new Object();
userinfo.name = 'Tom';
userinfo.girlFriends = ['Amy', 'Penny'];

$("#showInfo").click(function(){
	$.ajax({
        type: 'post',
        url: 'getdiv',
        data: JSON.stringify(userinfo),
        contentType: "application/json; charset=utf-8",
        traditional: true,
        success: function (data) {
           $("#info_block").html(data);
        }
    });
});
</script>

</html>