<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="univ.stud.holiday.model.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    String username = request.getAttribute("username") == null ? "" : (String) request.getAttribute("username");
    String password = request.getAttribute("password") == null ? "" : (String) request.getAttribute("password");
    String error = request.getAttribute("errorMessage") == null ? "" : (String) request.getAttribute("errorMessage");
%>

<!DOCTYPE>
<html>

<head>
    <meta charset="UTF-8">
    <Title>Holiday-App</title>
    <link rel="stylesheet" href="../../styles/mainStyle.css">
</head>

<body>

<h1>User Login</h1>

<h3>Please log into your account.</h3>

<form method="post" action="/holiday-app/user-login" autocomplete="on">
    <label for="username">Username:</label>
    <br>
    <input type="text" id="username" name="username" value="<%=username%>" required autofocus>
    <br>
    <br>
    <label for="password">Password:</label>
    <br>
    <input type="password" id="password" name="password" value="<%=password%>" required
           minlength="<%=User.PASS_MIN%>" maxLength="<%=User.PASS_MAX%>">
    <br>
    <br>
    <input type="submit" value="Login">
</form>

<form method="get" action="/holiday-app/user-create">
    <input type="submit" value="Create Account">
</form>

<% if (!error.isEmpty()) {%>
<p class="error">
    <%=error%>
</p>
<%}%>

</body>
</html>