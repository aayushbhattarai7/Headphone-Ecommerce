    <%@page import="model.userModel"%>
<%@page import="Utils.StringUtils"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/loginAdmin.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" >
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

</head>
<body>
    
    <div id="loginBox" class="loginBox">
        <form action="${pageContext.request.contextPath}/admin" method ="post">
        <img src="./logo.png" alt="">
        <h1>Login</h1>
       
        <input type="text" name="email" id="email" placeholder="Email" required>
        <input type="password" name="password" id="password" placeholder="Password" required>
        <button type="submit" id="login">Login</button><br>
        <a href ="Login.jsp">Login as a user</a>
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