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
	<p class = "userR">ユーザ名さん
	<a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserScreen.jsp">
	<small><span style = "color:#ff0000;">ログアウト</span></small></a></p></div>
	<h1 class = "user"><strong>ユーザ一覧</strong></h1>
	<p class = "userR"><a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserNewEntry.jsp">
		<small>新規登録</small></a></p>

	<form method="post" action="#" class="form-horizontal">
		<p class="user">ログインID　<input type="text" name="ログインID">
			</p><p class = "user">ユーザ名　　<input type = "text" name = "ユーザ名"></p>
		<p class = "user">生年月日　　<input type = "date" name = "生年月日"> ~
			<input type = "date" name = "生年月日"></p>
		<p class = "userR"><input type = "submit" value = "    検索    "></p>
	</form>

	<hr><table border = "検索結果" >
		<tr><th>ログインID</th>
		<th>ユーザ名</th>
		<th>生年月日</th>
		<th></th>
	</tr>
		<tr>
		<td>id0001</td>
		<td>田中太郎</td>
		<td>1989年04月26日</td>
		<td><a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserDetail.jsp"
				style = "text-decoration : none"><span class = "blue">詳細</span></a>
			<a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserUpdate.jsp"
				style = "text-decoration : none"><span class = "green">更新</span></a>
			<a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserDelete.jsp"
				style = "text-decoration : none"><span class = "red">削除</span></a></td>
	</tr>
	<tr>
		<td>id0002</td>
		<td>佐藤二朗</td>
		<td>2001年11月12日</td>
		<td><a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserDetail.jsp"
				style = "text-decoration : none"><span class = "blue">詳細</span></a>
			<a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserUpdate.jsp"
				style = "text-decoration : none"><span class = "green">更新</span></a>
			<a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserDelete.jsp"
				style = "text-decoration : none"><span class = "red">削除</span></a></td>
	</tr>
	<tr>
		<td>id0003</td>
		<td>佐川真司</td>
		<td>2000年01月01日</td>
		<td><a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserDetail.jsp"
				style = "text-decoration : none"><span class = "blue">詳細</span></a>
			<a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserUpdate.jsp"
				style = "text-decoration : none"><span class = "green">更新</span></a>
			<a href = "file:///C:/pleiades/pleiades/workspace/Example/WebContent/UserDelete.jsp"
				style = "text-decoration : none"><span class = "red">削除</span></a></td>
	</tr>
	</table>
</body>
</html>