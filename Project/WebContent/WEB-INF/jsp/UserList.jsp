<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta http-equiv = "Logout" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserScreen.jsp">
	<meta http-equiv = "Entry" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserNewEntry.jsp">
	<meta http-equiv = "Detail" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserDetail.jsp">
	<meta http-equiv = "Update" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserUpdate.jsp">
	<meta http-equiv = "Delete" content = "URL = file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserDelete.jsp">
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

	<form method="post" action="#" class="form-horizontal">
		<p class="user">ログインID　<input type="text" name="ログインID">
			</p><p class = "user">ユーザ名　　<input type = "text" name = "ユーザ名"></p>
		<p class = "user">生年月日　　<input type = "date" name = "生年月日"> ~
			<input type = "date" name = "生年月日"></p>
		<p class = "userR"><input type = "submit" value = "    検索    "></p>
	</form>

	<hr>
		<table border = "検索結果" align = "center">
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
				<td><a href = "UserDetailServlet?id=${user.id}"
						style = "text-decoration : none"><span class = "blue">　詳細　</span></a>
					<a href = "UserUpdateServlet?id=${user.id}"
						style = "text-decoration : none"><span class = "green">　更新　</span></a>
					<a href = "UserDeleteServlet?id=${user.id}"
						style = "text-decoration : none"><span class = "red">　削除　</span></a></td>
				</tr>
			</c:forEach>
		</tbody>
		</table>

</body>
</html>