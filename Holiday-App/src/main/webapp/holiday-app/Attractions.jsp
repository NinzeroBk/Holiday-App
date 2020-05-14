<%@ page import="univ.stud.holiday.model.entities.Attraction" %>
<%@ page import="univ.stud.holiday.model.services.database.MySqlDatabaseHoliday" %>
<%@ page import="java.util.List" %>
<%@ page import="static jdk.nashorn.internal.objects.ArrayBufferView.length" %>
<html>
<head>
    <Title>Holiday-App</title>
</head>
<body>
<h1 align="center">Attractions</h1>
<p align="center">
    <%
        List<Attraction> attractions = MySqlDatabaseHoliday.getInstance().attractionDao().getElements();
        request.setAttribute("list",attractions);
    %>
<table border="1" width="90%">
    <tr><th>AttractionId</th><th>Description</th><th>BaseCost</th><th>LocationId</th>
        <th>Name</th><th>Year</th>
        <c:forEach items="${list}" var="attraction">
    <tr><td>${list.attractionId}</td>
        </c:forEach>
</table>
</p>
</body>
</html>