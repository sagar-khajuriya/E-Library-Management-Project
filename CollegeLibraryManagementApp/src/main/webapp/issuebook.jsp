<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Issue</title>
<style>
body {
	margin: 0px;
	font-family: "Audiowide", sans-serif;
	color: white;
	background-image: url('background-modified.jpg');
	background-repeat: no-repeat;
	height: 500px;
	width: 700px;
	background-size: 1525px 650px;
}

.libreg {
	color: black;
	height: 550px;
	width: 500px;
	background-color: gray;
	opacity: 0.7;
	margin-left: 300px;
}

input {
	border-radius: 10px;
}
</style>


</head>
<body>
	<div class="libreg">
	<br/>
		<h1 style="text-align: center">Issue Book</h1>
		<br /> <br />
		<form method="post" action="./libtransactioncontroller">
<!--  ./libtransactioncontroller/issuebook -->
			<table cellpadding="10px" align="center">

				<tr>
					<th>Student Id</th>
					<td><input type="text" name="sid"  <c:choose><c:when test="${issueBook ne 'success' }"> value="${sid }"</c:when></c:choose> /></td>
					<c:choose>
						<c:when test="${issueBook eq 'sidNotFound' }">
							<td style="color: red;">*Student Id Incorrect</td>
						</c:when>
					</c:choose>
				</tr>
				<tr>			
				
					<th>Book Id</th>
					<td><input type="text" name="bid" <c:choose><c:when test="${issueBook ne 'success' }"> value="${bid }"</c:when></c:choose>  /></td>
					<c:choose>
						<c:when test="${issueBook eq 'bidNotFound' }">
							<td style="color: red;">*Book Id Incorrect</td>
						</c:when>
					</c:choose>
				</tr>
				<tr>
					<th>Issue Date</th>
					<td><input type="date" name="issuedate" <c:choose><c:when test="${issueBook ne 'success' }"> value="${issuedate}"</c:when></c:choose>  /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Issue Book" /></td>
				</tr>
			</table>

			<c:choose>
				<c:when test="${issueBook eq 'limit exceed' }">
					<h4 style="color: red; text-align: center;">*Limit Exceed (You
						can issue Max 3 Books)</h4>
				</c:when>

				<c:when test="${issueBook eq 'success' }">
					<h2 style="color: Green; text-align: center;">Book Issued
						Successfully</h2>
				</c:when>

				<%-- <c:when test="${issueBook eq null}">
					<h4 style="color: red; text-align: center;">Something went
						Wrong try later...</h4>
				</c:when> 		--%>
			</c:choose>
		</form>
	</div>

</body>
</html>