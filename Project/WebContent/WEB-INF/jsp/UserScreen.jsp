<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv = "List" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserList.jsp">
<link rel = "stylesheet" href = "User.css">
<title>ログイン画面</title>
</head>
<body>

<form class="form-signin" action="LoginServlet" method="post">
	<h1 class = "user"><strong>ログイン画面</strong></h1>
	<p class = "user">ログインID<input type = "text" name = "loginId"></p>
	<p class = "user">パスワード<input type = "password" name = "password"></p>
	<p class = "user">
	<a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserList.jsp">
	<input type = "submit" value = "  ログイン  "></a></p>
</form>

</body>
</html>