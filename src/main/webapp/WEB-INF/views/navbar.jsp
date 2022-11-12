<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@page isELIgnored="false"%>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

:root {
	--white:#ffffff;
    --light-white:rgb(220, 220, 220);
    --black:#000;
    --light-black:rgb(34, 34, 34);
    --grey:rgb(49, 49, 49);
    --main-color:orangered;
    --bg-color: var(--light-black);
    --secondary-bg-color: var(--black);
    --on-secondary: var(--white);
    --on-secondary-light:var(--grey);
}

body {
	background: var(--bg-color);
}
.container {
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: left;
    align-items: top;
}

nav {
	width: 5vw;
	height: 100vh;
	padding: 5px;
}

.nav-container {
	width: 100%;
	height: 100%;
	background-color: var(--secondary-bg-color);
	border-radius: 10px;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	align-items: center;
	padding:25px 1px;
}

.nav-container .logo {
	color: var(--main-color);
}

.nav-container .menu {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.nav-container .menu a {
	color: var(--on-secondary);
	margin:30px 0px 30px 0px;
}
.nav-container .menu a:hover {
	color: var(--main-color);
}

.nav-container .setting a {
	color: var(--on-secondary);
}

.nav-container .setting a:hover {
	color: var(--main-color);
}
</style>
</head>
<body>
	<nav>
		<div class="nav-container">
			<div class="logo">
				<i class="fa-brands fa-slack fa-2xl"></i>
			</div>
			<div class="menu">
				<a href="dashboard"><i class="fa-solid fa-house fa-lg"></i>	</a>			 
				<a
					href="search"><i class="fa-brands fa-squarespace fa-lg"></i></a>
				<a href="add_caption"><i
					class="fa-solid fa-circle-plus fa-lg"></i></a> <a href="profile"><i
					class="fa-solid fa-user fa-lg"></i></a>
			</div>
			<div class="setting">
				<a href="logout"><i class="fa-solid fa-gear fa-lg"></i></a>
			</div>
		</div>
	</nav>
</body>
</html>