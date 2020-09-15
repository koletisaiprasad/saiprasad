<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script >
  function deleteConfirm(){
	 return  confirm("Are you Sure, you want to delete?");
  }
</script>
</head>
<body>

	<h2>View Contacts Here</h2>
				<a href="/">+Add contact</a>
				<br>
				
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Contact Number</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${contacts}" var="contact">
			<tr>
				<td>${contact.contactName}</td>
				<td>${contact.contactEmail}</td>
				<td>${contact.phno}</td>
				<td><a href="/editContact?cid=${contact.contactId}">Edit</a>
				<a href="/deleteContact?cid=${contact.contactId}" onclick="return deleteConfirm()">Delete</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>