<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/header.css" />
</head>
<body>    
	<div id="header">
		<header class="header">
			<div class="class-1">
				<a href="#">
					<img src="${pageContext.request.contextPath}/Images/Final Logo without bg.png" class="Logo" />
				</a>
			</div>
			<div class="class-2">
				<ul class="main-nav">
					<li><a href="#">Home</a></li>
					<li><a href="#">Product</a></li>
					<li><a href="#">About Us</a></li>	
				</ul>
			</div>
			<div class="class-3">
				<div class="search-bar">
					<input type="text" placeholder="Search">
					<button class="cart-button"><img src="${pageContext.request.contextPath}/Images/grocery-store.png" class="cart"/></button>
					<button class="signup-button">Sign Up</button>
					<button class="login-button">Sign In</button>
				</div> 
			</div>
		</header>
	</div>
</body>
</html>