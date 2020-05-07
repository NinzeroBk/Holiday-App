<%@ page import="univ.stud.holiday.model.entities.User" %>
<%@ page import="univ.stud.holiday.model.HolidayRepository" %>
<%@ page import="univ.stud.holiday.model.entities.Holiday" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <Title>Holiday-App</title>
</head>
<body>
<h1 align="center">Holiday-App</h1>
<p align="center">
    <%
        User user = HolidayRepository.fetchUser((String) request.getAttribute("username"));
        List<Holiday> holidays = HolidayRepository.fetchHolidaysForUser(user.getUsername());
        out.print("Hello, \n" + user.toString());
        out.newLine();
        out.print(holidays);
    %>
</p>
</body>
</html>