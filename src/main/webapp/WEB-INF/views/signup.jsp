<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@taglib prefix="k" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<k:url value='/r/css/signup.css'/>" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Signup</title>
</head>

<body>
	<div class="container">
		<%@ include file="navbar.jsp" %>
		<section class="main-section">
			<div class="main-container">

				<form action="processSignup" method="post" enctype="multipart/form-data">
					<h1>Sign up</h1>
					<div class="custom-field">
						<input id="username-field" name="username" type="text"
							placeholder="Username" /> <label for="username-field"
							class="placeholder">Username</label>
					</div>
					<div class="custom-field">
						<input id="email-field" name="email" type="email"
							placeholder="Email" /> <label for="email-field"
							class="placeholder">Email</label>
					</div>
					<div class="custom-field">
						<input id="password-field" name="password" type="password"
							placeholder="Password" /> <label for="password-field"
							class="placeholder">Password</label>
					</div>

					<div class="custom-field">
						<input id="password-conf-field" name="confirm-password"
							type="password" placeholder="Confirm Password" /> <label
							for="password-conf-field" class="placeholder">Confirm
							Password</label>
					</div>
					<div class="custom-field">
						<input id="password-conf-field" name="pimg" type="file"
							value="Select Profile Image" /> <label for="password-conf-field"
							class="placeholder">Select Profile Image</label>
					</div>
					<h5>Already have account? <a href="login">Login</a></h5>
					<button>Signup</button>
				</form>
			</div>
		</section>
	</div>
</body>

</html>