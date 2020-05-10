<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="univ.stud.holiday.model.entities.User" %>
<%
    String imageUrl = request.getAttribute("imageUrl") == null ? "" : (String) request.getAttribute("imageUrl");
    String username = request.getAttribute("username") == null ? "" : (String) request.getAttribute("username");
    String password = request.getAttribute("password") == null ? "" : (String) request.getAttribute("password");
    String lastName = request.getAttribute("lastName") == null ? "" : (String) request.getAttribute("lastName");
    String firstName = request.getAttribute("firstName") == null ? "" : (String) request.getAttribute("firstName");
    String emailAddress = request.getAttribute("emailAddress") == null ? "" : (String) request.getAttribute("emailAddress");
    String errorMessage = request.getAttribute("errorMessage") == null ? "" : (String) request.getAttribute("errorMessage");
%>
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <Title>Holiday-App</title>
    <link rel="stylesheet" href="../../styles/mainStyle.css">
</head>
<body>
<h1>New User</h1>
<form method="post" action="/holiday-app/user-create" autocomplete="on">
    <label for="username">Username:</label>
    <br>
    <input type="text" id="username" name="username" value="<%=username%>" required autofocus>
    <br>
    <br>
    <label for="password">Password:</label>
    <br>
    <input type="password" id="password" name="password" value="<%=password%>" required
           minlength="<%=User.PASS_MIN%>" maxlength="<%=User.PASS_MAX%>">
    <br>
    <br>
    <label for="firstName">First Name:</label>
    <br>
    <input type="text" id="firstName" name="firstName" value="<%=firstName%>" required>
    <br>
    <br>
    <label for="lastName">Last Name:</label>
    <br>
    <input type="text" id="lastName" name="lastName" value="<%=lastName%>" required>
    <br>
    <br>
    <label for="emailAddress">Email Address:</label>
    <br>
    <input type="email" id="emailAddress" name="emailAddress" value="<%=emailAddress%>" required
           pattern="<%=User.EMAIL_PATTERN%>">
    <br>
    <br>
    <label for="imageUrl">Image URL (Optional):</label>
    <br>
    <input type="url" id="imageUrl" name="imageUrl" value="<%=imageUrl%>">
    <br>
    <br>
    <input type="submit" value="Create Account">
</form>

<% if (errorMessage != null) { %>
<p class="error">
    <%=errorMessage%>
</p>
<% } %>

</body>
</html>