<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Audiowide">

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
	width: 400px;
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
	/* height: 500px; */
	width: 1270px;
	background-color: gray;
	opacity: 0.7;
	/* margin-left: 200px;  */
	text-align: center;
}

input {
	border-radius: 10px;
}

th {
	color: white;
}
</style>
</head>
<body>
	

	<div class="libreg">
		<h1>All Student Record</h1>
		<br /> 
		<c:choose>
			<c:when test="${searchStudents ne null}">
				<table border="1" cellpadding="5px" align="center">
					<tr style="background-color: black;">
						<th>Id</th>
						<th>Name</th>
						<th>Mail Id</th>
						<th>Contact No</th>
						<th>Password</th>
						<th>Gender</th>
						<th>Department</th>
						<th>Course</th>
					</tr>
						<tr>
							<td>${searchStudents.sid }</td>
							<td>${searchStudents.sname }</td>
							<td>${searchStudents.mailid }</td>
							<td>${searchStudents.contactno }</td>
							<td>${searchStudents.password }</td>
							<td>${searchStudents.gender}</td>
							<td>${searchStudents.department }</td>
							<td>${searchStudents.course }</td>
						</tr>
				</table><br />
			</c:when>
			<c:otherwise>
				<h1 style="color: red; text-align: center">Student Record Not Found</h1>
				<div class="links">
					<a href="../searchstudent.jsp">Search Student</a>
				</div>

				<div class="links">
					<a href="../welcome.html">Go Back</a>
				</div>
			</c:otherwise>
		</c:choose>

	</div>
	<p
		style="margin-top: 50px; align: right; background-color: black; border-radius: 12px; opacity: 0.7; border: 3px solid black; text-align: center; font-size: 20px; color: white;">
		"Today a reader, tomorrow a leader." – Margaret Fuller</p>

</body>
</html>