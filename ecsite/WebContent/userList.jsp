<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ItemList画面</title>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>userList</p>
		</div>
		<div>
		<s:if test="userList == null">
			<h3>ユーザー情報はありません。</h3>
		</s:if>
		<s:elseif test="message == null">
			<h3>ユーザー情報は以下になります。</h3>
			<table border="1">
				<tr>
					<td>ID</td>
					<td>ログインID</td>
					<td>ログインパス</td>
					<td>ユーザー名</td>
					<td>入力日</td>
					<td>更新日</td>
				</tr>
			<s:iterator value="userList">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="loginId" /></td>
					<td><s:property value="loginPass" /></td>
					<td><s:property value="userName" /></td>
					<td><s:property value="insert_date" /></td>
					<td><s:property value="update_date" /></td>
				</tr>
			</s:iterator>
			</table>
			<s:form action="UserListDeleteConfirmAction">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="削除" />
			</s:form>
		</s:elseif>
		<s:if test="message != null">
			<h3><s:property value="message"/></h3>
		</s:if>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>