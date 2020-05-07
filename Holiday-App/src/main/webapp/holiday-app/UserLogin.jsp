<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <Title>Holiday-App</title>
</head>
<body>
<h1 align="center">User Login</h1>
<h3 align="center">Please log into your account.</h3>
<form align="center" method="post" action="/holiday-app/user-login">
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username" value=
            "<%
                out.print(request.getAttribute("username") == null ? "" : request.getAttribute("username"));
            %>"><br><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" value=
            "<%
                out.print(request.getAttribute("password") == null ? "" : request.getAttribute("password"));
            %>"><br><br>
    <input type="submit" value="Login">
    <input type="button" value="Create Account">
</form>
<p align="center">
    <%
        Object isLoginValid = request.getAttribute("isLoginValid");
        if (isLoginValid != null && !(Boolean) isLoginValid) {
            request.getAttribute("username");
            out.print("Invalid username or password!");
        }
    %>
</p>
</body>
</html>