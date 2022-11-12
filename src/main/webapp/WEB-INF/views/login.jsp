<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@taglib prefix="k" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<k:url value='/r/css/login.css'/>" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Login</title>
</head>

<body>
	<div class="container">
		<%@ include file="navbar.jsp" %>
		<section class="main-section">
			<div class="main-container">
			
				<form action="processLogin" method="post">
					<h1>Login</h1>
					<div class="custom-field">
						<input id="email-field" name="username" type="text" placeholder="Enter Username" />
						<label for="email-field" class="placeholder">Username</label>
					</div>
					<div class="custom-field">
						<input id="password-field" type="password" name="password"
							placeholder="Enter Password" /> <label for="password-field"
							class="placeholder">Password</label>
					</div>
					<h5>Don't have Account? <a href="signup">Signup</a></h5>
					<button>Login</button>
				</form>
			</div>
		</section>
	</div>
</body>

</html>