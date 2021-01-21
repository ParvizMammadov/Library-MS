<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Books</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>
<body>
	<jsp:include page="layouts/header-internal-admin.jsp"/>
	
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
		if(session.getAttribute("username") == null) {
			response.sendRedirect("login");
		}
	%>
	
	<h4 class="text-right"><b>Username: </b>${username}</h4>
	
	<h3>Books</h3>
	
	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th scope="col">ISBN</th>
	      <th scope="col">Title</th>
	      <th scope="col">Author</th>
	      <th scope="col">Publisher</th>
	      <th scope="col">Status</th>
	      <th scope="col">Borrower</th>
	      <th scope="col">Borrow date</th>
	      <th scope="col">Return date</th>
	      <th scope="col">Operations</th>
	    </tr>
	  </thead>
	  <tbody>
	  
	  	
	  	<c:forEach items="${books}" var="b">
	  		
		  	<tr>
		      <th scope="row">${b.isbn}</th>
		      <td>${b.title}</td>
		      <td>${b.author}</td>
		      <td>${b.publisher}</td>
		      <td>${b.status}</td>
		      <td>${b.borrower.username}</td>
		      <td>${b.borrowDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))}</td>
		      <td>${b.returnDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))}</td>
		      <td>
		      
		      	<c:choose>
		      	<c:when test="${b.status eq 'Ready' || b.status eq 'Reserved'}">
		      		<form action="/give-book-to-user" method="post">
			      		<button type="submit" name="isbn" class="btn btn-success" value="${b.isbn}">Give Book</button>
			      	</form>
			      	<form action="/return-book" method="post">
			      		<button type="submit" name="isbn" class="btn btn-primary" value="${b.isbn}" disabled="disabled">Return Book</button>
			      	</form>
			      	<form action="/send-book-for-repair" method="post">
			      		<button type="submit" name="isbn" class="btn btn-warning" value="${b.isbn}">Send Book for Repair</button>
			      	</form>
		      	</c:when>
		      	<c:otherwise>
		      		<form action="/give-book-to-user" method="post">
			      		<button type="submit" name="isbn" class="btn btn-success" value="${b.isbn}" disabled="disabled">Give Book</button>
			      	</form>
			      	<form action="/return-book" method="post">
			      		<button type="submit" name="isbn" class="btn btn-primary" value="${b.isbn}">Return Book</button>
			      	</form>
			      	<form action="/send-book-for-repair" method="post">
			      		<button type="submit" name="isbn" class="btn btn-warning" value="${b.isbn}" disabled="disabled">Send Book for Repair</button>
			      	</form>
		      	</c:otherwise>
		      </c:choose>
		      
		      </td>
		    </tr>
	  	
	  	</c:forEach>
	    
	    
	  </tbody>
	</table>
	
	<jsp:include page="layouts/footer.jsp"/>
</body>
</html>