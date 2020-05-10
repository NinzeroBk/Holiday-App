<%@ page import="univ.stud.holiday.model.entities.Attraction" %>
<%@ page import="univ.stud.holiday.model.services.database.MySqlDatabaseHoliday" %>
<%
    Object errorMessage = request.getAttribute("errorMessage");
    String endDate = request.getAttribute("endDate") == null ? "" : (String) request.getAttribute("endDate");
    String startDate = request.getAttribute("startDate") == null ? "" : (String) request.getAttribute("startDate");
    String attractionId = request.getAttribute("attractionId") == null ? "" : (String) request.getAttribute("attractionId");
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
<h1>Visit Form</h1>
<form method="post" action="/holiday-app/visits/visit-<%=operation%>">
    <label for="startDate">Start Date:</label>
    <br>
    <input type="datetime-local" id="startDate" name="startDate" value="<%=startDate%>" autofocus required>
    <br>
    <br>
    <label for="endDate">End Date:</label>
    <br>
    <input type="datetime-local" id="endDate" name="endDate" value="<%=endDate%>" required>
    <br>
    <br>
    <p>Select an attraction: </p>
    <% for (Attraction attraction : MySqlDatabaseHoliday.getInstance().attractionDao().getElements()) { %>
    <div style="text-align: left; padding: 12px;background-color: mediumaquamarine; margin-top: 2px; border: 1px solid aquamarine">
        <% if (String.valueOf(attraction.getId()).equals(attractionId)) { %>
        <input type="radio" id="<%=attraction.getId()%>" name="attractionId" value="<%=attraction.getId()%>" required
               checked>
        <% } else { %>
        <input type="radio" id="<%=attraction.getId()%>" name="attractionId" value="<%=attraction.getId()%>" required>
        <% } %>
        <label for="<%=attraction.getId()%>" style="width: 100%; height: 100%">
            <%=attraction%>
        </label>
    </div>
    <% } %>
    <br>
    <input type="submit" value="Submit" style="font-size: 2vw">
</form>
<% if (errorMessage != null) { %>
<p class="error">
    <%=errorMessage%>
</p>
<% } %>
</body>
</html>