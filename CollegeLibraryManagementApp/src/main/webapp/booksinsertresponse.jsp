<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0px;
	font-family: "Audiowide", sans-serif;
	color: white;
	background-image: url('../background-modified.jpg');
	background-repeat: no-repeat;
	height: 500px;
	width: 700px;
	background-size: 1525px 650px;
	
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
	border: 2px solid black;
}

a:hover {
	color: black;
}

a {
	color: white;
	text-decoration: none;
}

.libreg {
	color: black;
	height: 500px;
	width: 500px;
	background-color: gray;
	opacity: 0.7;
	margin-left: 300px;
	text-align: center;
}

input {
	border-radius: 10px;
}
</style>
</head>
<body>

	<div class="libreg">
		<h1>Result Page</h1>
		<br /> <br />
		<c:choose>
			<c:when test="${addBook eq 'success'}">
				<h1 style="color: green; text-align: center">Book Record Inserted
					Successfully</h1>
				<div class="links">
					<a href="../addbooks.html">Insert More Books</a>
				</div>

				<div class="links">
					<a href="../welcome.html">Go Back</a>
				</div>

			</c:when>

			<c:otherwise>
				<h1 style="color: red; text-align: center">Book Record Insertion
					Failed</h1>
				<div class="links">
					<a href="../addbooks.html">Insert More Books</a>
				</div>

				<div class="links">
					<a href="../welcome.html">Go Back</a>
				</div>

			</c:otherwise>
		</c:choose>

	</div>
<p
		style="margin-top: 50px; margin-left: 200px; background-color: black; border-radius: 12px; opacity: 0.7; border: 3px solid black; text-align: center; font-size: 20px; color: white;">
		"Today a reader, tomorrow a leader." – Margaret Fuller</p>

</body>
</html>