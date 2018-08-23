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

	<div class = "user">

	<header>
		<h1 class = "user"><strong>ログイン画面</strong></h1>
	</header>

	<c:if test = "${errMsg != null}">
		<div class = "alert alert-danger" role = "alert">
			<span class = "red1">${errMsg}</span>
		</div>
	</c:if>

	<form class="form-signin" action="LoginServlet" method="post">
		<p class = "user">ログインID<input type = "text" name = "loginId"></p>
		<p class = "user">パスワード<input type = "password" name = "password"></p>
		<p><a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserList.jsp">
			<input type = "submit" value = "　　ログイン　　"></a></p>
	</form>

	</div>

</body>
</html>