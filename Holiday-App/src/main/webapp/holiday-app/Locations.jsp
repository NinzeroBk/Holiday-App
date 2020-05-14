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
    <%
        List<Location> locations = MySqlDatabaseHoliday.getInstance().locationDao().getElements();
        out.print(locations.toString());
        out.newLine();
    %>
</p>
</body>
</html>