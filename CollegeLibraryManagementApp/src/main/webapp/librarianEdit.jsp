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
<body bgcolor="gray">

	<!-- This is Header -->
	<header
		style="height:70px; background-color:black; border-bottom: 5px solid gray;">
	<h1 align="center">College E-Library Management App</h1>
	</header>

	<!--For Menu Option to the Admin  -->
	<div
		style="background-color: black; height: 650px; width: 20%; float: left;">

		<div class="links">
			<a href="../adminwindow.jsp">ADMIN</a>
		</div>

		<div class="links">
			<a href="../librarianregistration.jsp">Register Librarian</a>
		</div>
		<div class="links">
			<a href="../librariansearch.html">Search Librarian</a>
		</div>
		<div class="links">
			<a href="../updatelibrarian.html">Update Librarian</a>
		</div>
		<div class="links">
			<a href="../librariandelete.html">Delete Librarian</a>
		</div>
		<div class="links">
			<a href="../controller/showalllibrarian">Show All Librarian</a>
		</div>
		<div class="links">
			<a href="../adminlogout.jsp">Logout</a>
		</div>

	</div>

	<div
		style="float: left; height: 650px; width: 80%; background-image: url('../background-modified.jpg'); background-size: 1215px 650px;">
		<!-- <img src="background-modified.jpg" width="1215px" height="650px" /> -->

		<div class="libreg">
			<h1>Edit Librarian</h1>
			<c:choose>
				<c:when test="${searchLibrarian ne null}">
					<br />
					<br />
					<form method="post" action="./controller/update">
						<table cellpadding="10px">
							<tr>
								<th>Id</th>
								<td><input type="text" name="lid"
									value="${searchLibrarian.lid}" readonly="readonly" /></td>
							</tr>
							<tr>
								<th>Name</th>
								<td><input type="text" name="lname"
									value="${searchLibrarian.lname}" /></td>
							</tr>
							<tr>
								<th>Mail Id</th>
								<td><input type="text" name="lmailid"
									value="${searchLibrarian.lmailid}" /></td>
							</tr>
							<tr>
								<th>Contact No.</th>
								<td><input type="text" name="lcontactno"
									value="${searchLibrarian.lcontactno}" /></td>
							</tr>
							<tr>
								<th>Set Password</th>

								<td><input type="password" name="lpassword"
									value="${searchLibrarian.lpassword}" /></td>
							</tr>
							<tr>
								<th>Gender</th>
								<td><input type="radio" name="lgender"
									value="${searchLibrarian.lgender}" /><label>Male</label> <input
									type="radio" name="lgender" value="${searchLibrarian.lgender}" /><label>Female</label></td>
							</tr>

							<tr>
								<td colspan="2" align="center"><input type="submit"
									value="Update" style="width: 150px; height: 30px;" /></td>
							</tr>
						</table>
					</form>
				</c:when>
				<c:otherwise>
					<h1 style="color: red; text-align: center">Record Not
						Available</h1>

					<div class="links" style="width: 300px;">
						<a href="../updatelibrarian.html">Update Librarian</a>
					</div>

					<div class="links" style="width: 300px;">
						<a href="../adminwindow.html">Go Back</a>
					</div>

				</c:otherwise>
			</c:choose>
		</div>

	</div>
</body>
</html>

