<%@ page import="univ.stud.holiday.model.HolidayRepository" %>
<%@ page import="univ.stud.holiday.model.entities.Holiday" %>
<%@ page import="univ.stud.holiday.model.entities.Region" %>
<%@ page import="univ.stud.holiday.model.services.database.implementations.RegionImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="univ.stud.holiday.model.services.database.MySqlDatabaseHoliday" %>
<html>
<head>
    <Title>Holiday-App</title>
</head>
<body>
<h1 align="center">Regions</h1>
<p align="center">
    <fieldset style="background-color: aquamarine">
            <%
        List<Region> regions = MySqlDatabaseHoliday.getInstance().regionDao().getElements();
%><div style="text-align: center; background-color: aquamarine">
            <% for(Region region: regions) { %>
<p><%=region%> </p>
<% } %>
</fieldset>
</div>
</p>
</body>
</html>