<%@ page import="univ.stud.holiday.model.entities.Holiday" %>

<%
    String username = (String) session.getAttribute("username");
    String title = request.getAttribute("title") == null ? "" : (String) request.getAttribute("title");
    String endDate = request.getAttribute("endDate") == null ? "" : (String) request.getAttribute("endDate");
    String startDate = request.getAttribute("startDate") == null ? "" : (String) request.getAttribute("startDate");
    String description = request.getAttribute("description") == null ? "" : (String) request.getAttribute("description");
    request.setAttribute("username", username);
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
<h1>Holiday Form</h1>
<form method="post" action="/holiday-app/holidays/<%=holidayOperation%>" autocomplete="on">
    <label for="username">For User:</label>
    <br>
    <input type="text" id="username" name="username" value="<%=username%>" readonly>
    <br>
    <br>
    <label for="title">Title:</label>
    <br>
    <input type="text" id="title" name="title" value="<%=title%>" autofocus maxlength="<%=Holiday.TITLE_MAX_LENGTH%>"
           required>
    <br>
    <br>
    <label for="startDate">Start Date:</label>
    <br>
    <input type="date" id="startDate" name="startDate" value="<%=startDate%>" required>
    <br>
    <br>
    <label for="endDate">End Date:</label>
    <br>
    <input type="date" id="endDate" name="endDate" value="<%=endDate%>" required>
    <br>
    <br>
    <label for="description">Description:</label>
    <br>
    <textarea id="description" name="description" cols="25" rows="10"
              maxlength="<%=Holiday.DESCRIPTION_MAX_LENGTH%>"><%=description%></textarea>
    <br>
    <br>
    <input type="submit" value="<%=submitOperation%>">
</form>
<% if (request.getAttribute("errorMessage") != null) { %>
<p class="error">
    <%=request.getAttribute("errorMessage")%>
</p>
<% } %>
</body>
</html>