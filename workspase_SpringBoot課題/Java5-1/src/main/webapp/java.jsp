<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.bean.EmployeeBean"%>

<%
// EmployeeController.javaから渡されたBeanを受けとります。
EmployeeBean employeeBean = (EmployeeBean) request.getAttribute("EmployeeBean");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>検索結果</title>
</head>
<body>
	<div align="center">
		<%
		if (employeeBean != null) {
		%>
		<table border="1">
			<tr>
				<th>社員名</th>
				<td><%=employeeBean.getName()%></td>
			</tr>
			<tr>
				<th>コメント</th>
				<td><%=employeeBean.getComment()%></td>
			</tr>
			<tr>
				<th>ログインタイム</th>
				<td><%=employeeBean.getLogin_Time()%></td>
			</tr>
		</table>
		<%
		} else {
		%>
		IDもしくはパスワードが間違ってます
		<p>ログイン</p>
		<form action="/Java5-1/check" method="post">
			<input type="text" name="id">
			<input type="password" name="password">
			<input type="submit" value="送信">
			<input type="reset" value="リセット">
		</form>
		<%
		}
		%>
	</div>
</body>
</html>