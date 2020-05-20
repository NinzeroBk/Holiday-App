<%@ page import="univ.stud.holiday.model.entities.Location" %>
<%@ page import="univ.stud.holiday.model.services.database.MySqlDatabaseHoliday" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <Title>Holiday-App</title>
</head>
<body>
<h1 align="center">Locations</h1>
<p align="center">
    <fieldset style="background-color: aquamarine">
            <%
        List<Location> locations = MySqlDatabaseHoliday.getInstance().locationDao().getElements();
%><div style="text-align: center; background-color: aquamarine">
            <% for(Location location: locations) { %>
<p><%=location%> </p>
<% } %>
</fieldset>
</p>
</body>
</html>