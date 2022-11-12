<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@taglib prefix="k" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<k:url value='/r/css/add_caption.css'/>" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Add Caption</title>
</head>
<body>
	<div class="container">
		<%@ include file="navbar.jsp"%>
		<section class="main-section">
			<div class="main-container">

				<form action="processCaption" method="post">
					<h1>Add Caption</h1>
					<div class="custom-field">
						<select id="category-field" name="category" placeholder="Category">
							<k:forEach var="c" items="${categories }">
								<option value="${c.getCname() }">${c.getCname() }</option>

							</k:forEach>
						</select> <label for="category-field" class="placeholder">Select
							Category</label>
					</div>
					<div class="custom-field">
						<select name="language" placeholder="Language">
							<option value="Hindi">Hindi</option>
							<option value="English">English</option>
						</select> <label for="password-conf-field" class="placeholder">Select
							Language</label>
					</div>

					<div class="custom-field">
						<textarea rows="6" name="caption"
							placeholder="Write you caption here..."></textarea>
						<label for="password-conf-field" class="placeholder">Caption</label>
					</div>

					<button type="submit">Post</button>
				</form>
			</div>
		</section>
	</div>
</body>
</html>