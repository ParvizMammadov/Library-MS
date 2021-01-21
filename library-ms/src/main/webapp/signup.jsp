<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Sign Up</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>
<body>

	<jsp:include page="layouts/header.jsp"/>
	
	<div class="card text-center" style="width: 400px">
		<h3>Sign Up</h3> <br>
		<form action="/add-user" method="post">
			<input type="email" name="email" placeholder="Email" class="form-control" required> <br>
			<input type="password" name="password" placeholder="Password" class="form-control" required> <br>
			<input type="password" name="confirmPassword" placeholder="Confirm Password" class="form-control" required> <br>
			<input type="text" name="username" placeholder="Username" class="form-control" required> <br>
			<input type="submit" class="btn btn-success" value="Sign Up"> <br>
		</form>
	</div>
	
	
	<jsp:include page="layouts/footer.jsp"/>

</body>
</html>