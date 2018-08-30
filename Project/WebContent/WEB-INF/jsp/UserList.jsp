<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
	<link rel = "stylesheet" href = "User.css">
	<title>ユーザ一覧</title>
	</head>

<body>
	<div class = "bg">
	<p class = "userR"> ${userInfo.name}さん　　
	<a href = "LogoutServlet" style = "text-decoration : none">
		<small><span class = "red1">ログアウト</span></small></a></p></div>
	<h1 class = "user"><strong>ユーザ一覧</strong></h1>
	<p class = "userR"><a href = "UserNewEntryServlet">
		<small>新規登録</small></a></p>

	<form method="post" action="UserListServlet" class="form-horizontal">
		<p class="user">ログインID　<input type="text" name="loginIdP">
			</p><p class = "user">ユーザ名　　<input type = "text" name = "userNameP"></p>
		<p class = "user">生年月日　　<input type = "date" name = "dateStartP"> ~
			<input type = "date" name = "dateEndP"></p>
		<p class = "userR"><a href = "UserListServlet">
			<input type = "submit" value = "　検索　"></a></p>
	</form>

	<hr>
		<table border = "検索結果" align="center">
		<thead>
			<tr><th>ログインID</th>
			<th>ユーザ名</th>
			<th>生年月日</th>
			<th></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var = "user" items = "${userList}">
				<tr>
				<td>${user.loginId}</td>
				<td>${user.name}</td>
				<td>${user.birthDate}</td>

<c:if test="${userInfo.loginId == 'admin'}">
					<td><a href = "UserDetailServlet?id=${user.id}"
							style = "text-decoration : none"><span class = "blue">　詳細　</span></a>
						<a href = "UserUpdateServlet?id=${user.id}"
							style = "text-decoration : none"><span class = "green">　更新　</span></a>
						<a href = "UserDeleteServlet?id=${user.id}"
							style = "text-decoration : none"><span class = "red">　削除　</span></a></td>
</c:if>

<c:if test="${userInfo.loginId != 'admin'}">
	<td><a href = "UserDetailServlet?id=${user.id}"
							style = "text-decoration : none"><span class = "blue">　詳細　</span></a>
</c:if>

<c:if test="${user.loginId == userInfo.loginId}">
	<a href = "UserUpdateServlet?id=${user.id}"
							style = "text-decoration : none"><span class = "green">　更新　</span></a>
</c:if>

				</tr>
			</c:forEach>
		</tbody>
		</table>

</body>
</html>