<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	height: 30px;
	text-align: center;
	padding: 10px;
	border: 2px solid gray;
	border-radius: 12px;
	padding: 5px;
	margin: 10px;
	padding: 5px;
}

.links:hover {
	background-color: gray;
}

a:hover {
	color: black;
}

a {
	color: white;
	text-decoration: none;
}
</style>

</head>
<body bgcolor="gray">

	<c:choose>
		<c:when test="${adminLogin eq 'success'}">

			<!-- This is Header -->
			<header
				style="height:70px; background-color:black; border-bottom: 5px solid gray;">
			<h1 align="center">College E-Library Management App</h1>
			</header>

			<!--For Menu Option to the Admin  -->
			<div
				style="background-color: black; height: 650px; width: 20%; float: left;">

				<div class="links">
					<a href="adminwindow.jsp">ADMIN</a>
				</div>

				<div class="links">
					<a href="librarianregistration.jsp">Register Librarian</a>
				</div>
				<div class="links">
					<a href="librariansearch.html">Search Librarian</a>
				</div>
				<div class="links">
					<a href="updatelibrarian.html">Update Librarian</a>
				</div>
				<div class="links">
					<a href="librariandelete.html">Delete Librarian</a>
				</div>
				<div class="links">
					<a href="./controller/showalllibrarian">Show All Librarian</a>
				</div>
				<div class="links">
					<a href="adminlogout.jsp">Logout</a>
				</div>

			</div>


			<!-- Body  -->
			<div
				style="float: left; height: 650px; width: 80%; background-image: url('background-modified.jpg'); background-size: 1215px 650px;">
				<!-- <img src="background-modified.jpg" width="1215px" height="650px" /> -->
				<p style="font-size: 30px; color: Black;">Welcome Admin</p>
				<p
					style="margin-top: 500px; margin-left: 600px; background-color: gray; opacity: 0.7; border: 5px solid black; text-align: center; font-size: 20px;">
					"Today a reader, tomorrow a leader." – Margaret Fuller</p>

			</div>
		</c:when>
		<c:otherwise>
					<jsp:forward page="adminlogin.jsp"></jsp:forward>
		</c:otherwise>
	</c:choose>
</body>
</html>