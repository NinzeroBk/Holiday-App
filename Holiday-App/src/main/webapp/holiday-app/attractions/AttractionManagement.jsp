<%@ page import="univ.stud.holiday.model.entities.Attraction" %>
<%@ page import="univ.stud.holiday.model.entities.Location" %>
<%@ page import="univ.stud.holiday.model.services.database.MySqlDatabaseHoliday" %>
<%
    Object errorMessage = request.getAttribute("errorMessage");
    String description = request.getAttribute("description") == null ? "" : (String) request.getAttribute("description");
    String baseCost = request.getAttribute("baseCost") == null ? "" : (String) request.getAttribute("baseCost");
    String locationId = request.getAttribute("locationId") == null ? "" : (String) request.getAttribute("locationId");
    String name = request.getAttribute("name") == null ? "" : (String) request.getAttribute("name");
    String year = request.getAttribute("year") == null ? "" : (String) request.getAttribute("year");
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
<form method="post" action="/holiday-app/attractions/attraction-<%=attractionOperation%>">
    <label for="description">Description:</label>
    <br>
    <textarea id="description" name="description" cols="25" rows="10"
              maxlength="<%=Attraction.DESCRIPTION_MAX_LENGTH%>" required><%=description%></textarea>
    <br>
    <br>
    <label for="baseCost">Base Cost:</label>
    <br>
    <input type="number" id="baseCost" name="baseCost" value="<%=baseCost%>"
           min="0" required>
    <br>
    <br>
    <label for="name">Name:</label>
    <br>
    <input type="text" id="name" name="name" value="<%=name%>"
           maxlength="<%=Attraction.NAME_MAX_LENGTH%>" required>
    <br>
    <br>
    <label for="year">Year:</label>
    <br>
    <input type="number" id="year" name="year" value="<%=year%>"
           min="0" required>
    <br>
    <br>
    <p>Select a location: </p>
    <% for (Location location : MySqlDatabaseHoliday.getInstance().locationDao().getElements()) { %>
    <div style="text-align: left; padding: 12px;background-color: mediumaquamarine; margin-top: 2px; border: 1px solid aquamarine">
        <% if (String.valueOf(location.getId()).equals(locationId)) { %>
        <input type="radio" id="<%=location.getId()%>" name="locationId" value="<%=location.getId()%>" required
               checked>
        <% } else { %>
        <input type="radio" id="<%=location.getId()%>" name="locationId" value="<%=location.getId()%>" required>
        <% } %>
        <label for="<%=location.getId()%>" style="width: 100%; height: 100%">
            <%=location%>
        </label>
    </div>
    <% } %>
    <br>
    <input type="submit" value="<%=submitOperation%>">
</form>
<% if (errorMessage != null) { %>
<p class="error">
    <%=errorMessage%>
</p>
<% } %>
</body>
</html>