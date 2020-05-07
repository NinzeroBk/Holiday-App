<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:catch var="catcher">
        <%
            //User user = HolidayRepository.fetchUser((String) request.getAttribute("username"));
            //List<Holiday> holidays = HolidayRepository.fetchHolidaysForUser(user.getUsername());
            out.print("Hello, \n" + session.getAttribute("currentUser"));
            //out.newLine();
            //out.print(holidays);
        %>
    </c:catch>
    <c:if test="${catcher != null}">
        <c:out value="OOPS a problem occurred!!"/>
    </c:if>
</p>
</body>
</html>