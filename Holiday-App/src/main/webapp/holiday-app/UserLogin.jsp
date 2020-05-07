<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head lang="en-US">
    <Title>Holiday-App</title>
</head>
<body>
<h1 align="center">User Login</h1>
<h3 align="center">Please log into your account.</h3>
<form align="center" method="post" action="/holiday-app/user-login">
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username" value=
            "<%=
            request.getAttribute("username") == null ? "" : request.getAttribute("username")
            %>"><br><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" value=
            "<%=
            request.getAttribute("password") == null ? "" : request.getAttribute("password")
            %>"><br><br>
    <input type="submit" value="Login">
</form>
<form align="center" method="get" action="/holiday-app/user-create">
    <input type="submit" value="Create Account">
</form>
<p align="center" style="color:red">
    <%=
    request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : ""
    %>
</p>
<%
    String currentUser = (String) request.getAttribute("currentUser");
    if (currentUser != null) {
        session.setAttribute("currentUser", currentUser);
        request.getRequestDispatcher("Holidays.jsp").forward(request, response);
    }
%>
</body>
</html>