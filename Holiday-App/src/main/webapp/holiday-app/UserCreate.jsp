<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <Title>Holiday-App</title>
</head>
<body>
<h1 align="center">New User</h1>
<form align="center" method="post" action="/holiday-app/user-create">
    <label for="username">Username:</label><br><br>
    <input type="text" id="username" name="username" value=
            "<%=
                request.getAttribute("username") == null ? "" : request.getAttribute("username")
            %>"><br><br>

    <label for="password">Password:</label><br><br>
    <input type="password" id="password" name="password" value=
            "<%=
                request.getAttribute("password") == null ? "" : request.getAttribute("password")
            %>"><br><br>

    <label for="firstName">First Name:</label><br><br>
    <input type="text" id="firstName" name="firstName" value=
            "<%=
                request.getAttribute("firstName") == null ? "" : request.getAttribute("firstName")
            %>"><br><br>

    <label for="lastName">Last Name:</label><br><br>
    <input type="text" id="lastName" name="lastName" value=
            "<%=
                request.getAttribute("lastName") == null ? "" : request.getAttribute("lastName")
            %>"><br><br>

    <label for="emailAddress">Email Address:</label><br><br>
    <input type="email" id="emailAddress" name="emailAddress" value=
            "<%=
                request.getAttribute("emailAddress") == null ? "" : request.getAttribute("emailAddress")
            %>"><br><br>

    <label for="imageUrl">Image URL (Optional):</label><br><br>
    <input type="url" id="imageUrl" name="imageUrl" value=
            "<%=
                request.getAttribute("imageUrl") == null ? "" : request.getAttribute("imageUrl")
            %>"><br><br>

    <input type="submit" value="Create Account">
</form>
<p align="center" style="color:red">
    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
            out.print(errorMessage);
        }
    %>
</p>
</body>
</html>