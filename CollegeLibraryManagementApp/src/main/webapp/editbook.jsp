<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Registration Form</title>
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
		<h1>Edit Books</h1>
		<br />
		<br />
		<c:choose>
			<c:when test="${searchBook ne null}">
				<form method="post" action="./bookscontroller/updatebook">
					<table cellpadding="10px" align="center">
						<c:forEach var="list" items="${searchBook }">
							<tr>
								<th>Book Id</th>
								<td><input type="text" name="bid" value="${list.bookId }" /></td>
							</tr>
							<tr>
								<th>Book Name</th>
								<td><input type="text" name="bname" value="${list.bookName }" /></td>
							</tr>
							<tr>
								<th>Subject</th>
								<td><input type="text" name="subject"
									value="${list.subject }" /></td>
							</tr>
							<tr>
								<th>Author</th>
								<td><input type="text" name="author"
									value="${list.author }" /></td>
							</tr>

							<tr>
								<th>Title</th>
								<td><input type="text" name="title" value="${list.title }" /></td>
							</tr>

							<tr>
								<th>Category</th>
								<td><input type="text" name="category"
									value="${list.category }" /></td>
							</tr>

							<tr>
								<th>Quantity</th>
								<td><input type="text" name="quantity"
									value="${list.qty }" /></td>
							</tr>

							<tr>
								<td colspan="2" align="center"><input type="submit"
									value="Update" /></td>
							</tr>
						</c:forEach>
					</table>
				</form>
			</c:when>
			<c:otherwise>
				<h1 style="color: red; text-align: center">Book Record Not
					Found</h1>
				<div class="links">
					<a href="../updatebook.jsp">Update Books</a>
				</div>

				<div class="links">
					<a href="../welcome.html">Go Back</a>
				</div>


			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>