<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv = "Logout" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserScreen.jsp">
<meta http-equiv = "List" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserList.jsp">
<link rel = "stylesheet" href = "User.css">
<title>ユーザ新規登録</title>
</head>
<body>
<div class = "bg">
<p class = "userR">${userInfo.name}名さん　　
<a href = "LogoutServlet" style = "text-decoration : none">
	<small><span class = "red1">ログアウト</span></small></a></p></div>
<p class = "user"><strong>ユーザ新規登録</strong></p>
<p class = "user">ログインID　<input type = "text" name = "ログインID">
<p class = "user">パスワード　<input type = "password" name ="パスワード"></p>
<p class = "user">パスワード（確認）　<input type = "password" name = "パスワード（確認）"></p>
<p class = "user">ユーザ名　<input type = "text" name = "ユーザ名"></p>
<p class = "user">生年月日　<input type = "date" name ="生年月日"></p>
<p class = "user"><input type = "submit" value = "登録"></p>
<p><a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserList.jsp"><small>戻る</small></a></p>
</body>
</html>