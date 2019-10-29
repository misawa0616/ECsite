<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<title>userListDeleteConfirm画面</title>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>userListDeleteConfirm画面</p>
		</div>
		<div>
			<h3>すべてのユーザーを削除します。よろしいですか?</h3>
				<div>
					<a href='<s:url action="UserListDeleteCompleteAction"/>'>OK</a>
					<br>
					<br>
					<a href='<s:url action="UserListAction"/>'>キャンセル</a>
				</div>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>
