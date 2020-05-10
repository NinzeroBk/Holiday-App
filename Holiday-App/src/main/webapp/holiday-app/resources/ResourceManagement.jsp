<%@ page import="univ.stud.holiday.model.entities.Resource" %>
<%
    String title = request.getAttribute("title") == null ? "" : (String) request.getAttribute("title");
    String imageUrl = request.getAttribute("imageUrl") == null ? "" : (String) request.getAttribute("imageUrl");
    String timestamp = request.getAttribute("timestamp") == null ? "" : (String) request.getAttribute("timestamp");
    String errorMessage = request.getAttribute("errorMessage") == null ? "" : (String) request.getAttribute("errorMessage");
%>
<!DOCTYPE>
<html>
<head>
    <title>
        Holiday-App
    </title>
    <link rel="stylesheet" href="../../styles/mainStyle.css">
</head>
<body>
<form method="post" action="/holiday-app/resources/resource-<%=operation%>" autocomplete="on">
    <h1>Resource Form</h1>
    <label for="title">
        Title:
    </label>
    <br>
    <input name="title" id="title" value="<%=title%>" required autofocus maxlength="<%=Resource.TITLE_MAX_LENGTH%>">
    <br>
    <br>
    <label for="timestamp">
        Timestamp:
    </label>
    <br>
    <input type="datetime-local" id="timestamp" name="timestamp" value="<%=timestamp%>" required>
    <br>
    <br>
    <label for="imageUrl">
        Image Url:
    </label>
    <br>
    <input type="url" name="imageUrl" id="imageUrl" value="<%=imageUrl%>" required>
    <br>
    <br>
    <input type="submit" name="Submit">
</form>
<% if (errorMessage != null) { %>
<p class="error">
    <%=errorMessage%>
</p>
<% } %>
</body>
</html>