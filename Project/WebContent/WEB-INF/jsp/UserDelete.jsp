<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv = "Logout" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserScreen.jsp">
		<meta http-equiv = "List" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserList.jsp">
		<link rel = "stylesheet" href = "User.css">
		<title>ユーザ削除確認</title>
	</head>

	<body>
		<div class = "bg">
		<p class = "userR">${userInfo.name}さん
		<a href = "LogoutServlet">
			<small><span class = "red1">ログアウト</span></small></a></p></div>
		<p class = "user"><strong>ユーザ削除確認</strong></p>

			<p>ログインID：${user.loginId}
			<br>を本当に削除してよろしいでしょうか。</p>

		<form class="form-signin" action="UserDeleteServlet" method="post">
			<p class = "user">
				<a href = "UserListServlet">
					<input type = "button" value = "キャンセル"></a>
				<input type="hidden" value="${user.id}" name = "id">
					<input type = "submit" value = "OK">
				</p>
		</form>
	</body>

</html>