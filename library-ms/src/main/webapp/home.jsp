<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Home Page</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>
<body>

	<jsp:include page="layouts/header.jsp"/>
	
	<h1 class="text-center" style="margin-top: 150px">Welcome to the Library Management System</h1> <br>
	
	<h3 class="text-center">If you already have an account, please
	<a href="/login">Login</a> to continue</h3> <br>
	<h3 class="text-center" style="margin-bottom: 200px">If you don't have an account yet, please
	<a href="/signup">Sign Up</a></h3>
	
	<jsp:include page="layouts/footer.jsp"/>

</body>
</html>