<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Audiowide">
<style>
body {
	margin: 0px;
	font-family: "Audiowide", sans-serif;
	color: white;
}

header {
	margin: 0px;
	padding: 5px;
}

.links {
	background-color: black;
	height: 70px;
	text-align: center;
	border: 2px solid gray;
	border-radius: 12px;
	margin-top: 50px;
}

.links:hover {
	background-color: gray;
	border: 2px solid black;
}

a:hover {
	color: black;
}

a {
	color: white;
	text-decoration: none;
	font-size: 25px;
}

.libreg {
	color: black;
	height: 300px;
	width: 500px;
	background-color: gray;
	opacity: 0.7;
	margin-left: 950px;
	margin-top: 100px;
	text-align: center;
	padding: 10px;
	border: 3px solid black;
	border-radius: 12px;
}
input {
	border-radius: 10px;
}
</style>

</head>
<body bgcolor="gray">

	<!-- This is Header -->
	<header
		style="height:70px; background-color:black; border-bottom: 5px solid gray;">
	<h1 align="center">College E-Library Management App</h1>
	</header>

	<!--For Menu Option to the Admin  -->

	<!-- Body  -->
	<div
		style="float: left; height: 650px; width: 100%; background-image: url('background-modified.jpg'); background-size: 1525px 650px; background-repeat: no-repeat;">
		<!-- <img src="background-modified.jpg" width="1215px" height="650px" /> -->

		<div class="libreg">

			<center>
				<h1>Admin Login</h1>
				<br />
				<form method="post" action="./adminlogincontroller">
					<table cellpadding="10px">
						<tr>
							<th>Admin Id</th>
							<td><input type="text" name="aid" /></td>
						</tr>
						<tr>
							<th>Password</th>
							<td><input type="password" name="apassword" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								value="Submit" style="width: 100px; height: 25px;"/></td>
						</tr>
					</table>
				</form>
				<c:choose>
					<c:when test="${adminLogin eq 'fail'}">
					<p style="color: red;">*UserName and Password is Incorrect</p>
					</c:when>
				</c:choose>
			</center>

		</div>

		<p
			style="margin-top: 100px; margin-left: 600px; background-color: black; border-radius: 12px; opacity: 0.7; border: 3px solid black; text-align: center; font-size: 20px;">
			"Today a reader, tomorrow a leader." – Margaret Fuller</p>
	</div>
</body>
</html>