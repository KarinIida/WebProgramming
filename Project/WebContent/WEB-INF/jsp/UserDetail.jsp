<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv = "Logout" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserScreen.jsp">
		<meta http-equiv = "List" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserList.jsp">
		<link rel = "stylesheet" href = "User.css">
		<title>ユーザ情報詳細参照</title>
	</head>

	<body>
		<div class = "bg">
		<p class = "userR"> ${userInfo.name}さん　　
		<a href = "LogoutServlet" style = "text-decoration : none">
			<small><span class = "red1">　ログアウト</span></small></a></p></div>

		<div class = "user">
			<p><strong>ユーザ情報詳細参照</strong></p>

				<p>ログインID　${user.loginId}</p>
				<p>ユーザ名　${user.name}</p>
				<p>生年月日　${user.birthDate}</p>
				<p>登録日時　${user.createDate}</p>
				<p>更新日時　${user.updateDate}</p>

		</div>
		<p><a href = "UserListServlet"><small>戻る</small></a></p>

	</body>
</html>