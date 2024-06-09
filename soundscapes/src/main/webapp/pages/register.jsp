    <%@page import="model.userModel"%>
<%@page import="Utils.StringUtils"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/signup.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">



</head>
<body>

        <div id="signupBox" class="signupBox">
   
    <form action="${pageContext.request.contextPath}/Register" method="post">
    <img src="./logo.png" alt="">
        <h1>Signup</h1>
        <input type="text" name="fullName" id="name" placeholder="FullName" required>
        <input type="text" name="email" id="email" placeholder="Email" required>
        <input type="text" name="phoneNumber" id="phone" placeholder="Phone Number" required>
        <input type="password" name="password" id="password" placeholder="Password" required>
        <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirm Password" required>
        <button type="submit" id="signup">Signup</button><br>
        <a id="" href="Login.jsp">Already have an account?, click here</a>
        <a id="" href=""></a>
    </form>
    <%
        String errorMessage = (String) request.getAttribute(StringUtils.ERROR_MESSAGE);
    
        
        if (errorMessage !=null && !errorMessage.isEmpty()) {
    %>
        <div class="alert alert-danger" role="alert">
            <%= errorMessage %>
        </div>
        <% 
        }
        %>
    </div>

    
</body>
</html>