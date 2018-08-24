<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv = "Logout" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserScreen.jsp">
<meta http-equiv = "List" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserList.jsp">
<link rel = "stylesheet" href = "User.css">
<title>ユーザ情報更新</title>
</head>

<body>
<div class = "bg">
<p class = "userR">${userInfo.name}さん
<a href = "LogoutServlet" style = "text-decoration : none">
	<small><span class = "red1">　ログアウト</span></small></a></p></div>

	<div class = "user">
		<header>
			<p><strong>ユーザ情報更新</strong></p>
		</header>

		<c:if test = "${errMsg != null}">
			<div class = "alert alert-danger" role = "alert"><span class = "red1">${errMsg}</span>
			</div>
		</c:if>

	<form class="form-signin" action="UserUpdateServlet" method="post">
		<p>ログインID　${user.loginId}</p>
		<p>パスワード　<input type = password name = "パスワード"></p>
		<p>パスワード（確認）　<input type = password name = "パスワード（確認）"></p>
		<p>ユーザ名　<input type = "text" name ="ユーザ名" value = "${user.name}"></p>
		<p>生年月日　<input type = "date" name ="生年月日" value = "${user.birthDate}"></p>
		<p><input type = "submit" value = "更新"></p>
	</form>

	</div>
<p><a href = "UserListServlet"><small>戻る</small></a></p>

</body>
</html>