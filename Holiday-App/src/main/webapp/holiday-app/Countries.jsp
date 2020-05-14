<%@ page import="univ.stud.holiday.model.entities.Country" %>
<%@ page import="univ.stud.holiday.model.services.database.MySqlDatabaseHoliday" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <Title>Holiday-App</title>
</head>
<body>
<h1 align="center">Countries</h1>
<p align="center">
    <%
        List<Country> countries = MySqlDatabaseHoliday.getInstance().countryDao().getElements();
        out.newLine();
        out.print(countries.toString());
    %>
</p>
</body>
</html>