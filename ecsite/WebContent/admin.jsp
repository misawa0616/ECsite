<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Admin画面</title>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>管理者画面</p>
		</div>
		<div id="left">
			<table>
				<tr>
					<th>商品</th>
				</tr>
				<tr></tr>
				<tr>
					<th><a href='<s:url action="itemCreateAction"/>'>新規登録</a></th>
				</tr>
				<tr>
					<th><a href='<s:url action="itemListAction"/>'>一覧</a></th>
				</tr>
			</table>
		</div>
		<div id="right">
			<table>
				<tr>
					<th>ユーザー</th>
				</tr>
				<tr></tr>
				<tr>
					<th><a href='<s:url action="UserCreateAction"/>'>新規登録</a></th>
				</tr>
				<tr>
					<th><a href='<s:url action="UserListAction"/>'>一覧</a></th>
				</tr>
			</table>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>