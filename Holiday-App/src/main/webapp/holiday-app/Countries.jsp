<%@ page import="univ.stud.holiday.model.entities.Country" %>
<%@ page import="univ.stud.holiday.model.services.database.MySqlDatabaseHoliday" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <Title>Holiday-App</title>
</head>
<body>
<h1 align="center">Countries</h1>
    <fieldset style="background-color: aquamarine">
        <%
        List<Country> countries = MySqlDatabaseHoliday.getInstance().countryDao().getElements();
%><div style="text-align: center; background-color: aquamarine">
        <% for(Country country: countries) { %>
<p><%=country%> </p>
<% } %>
    </fieldset>
</body>
</html>