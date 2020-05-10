<%@ page import="univ.stud.holiday.model.*" %>
<%@ page import="java.util.List" %>
<%
    List<? extends Entity<?>> list = HolidayRepository.fetchVisitsForHoliday((Integer) session.getAttribute("holidayId"));
    String actionPath = "/holiday-app/visits";
    String fieldsetTitle = "Visits";
    String elementId = "visitId";
    String element = "visit";
%>
<html>
<head>
    <title>
        Holiday-App
    </title>
    <link rel="stylesheet" href="../../styles/mainStyle.css">
</head>
<body>
<% boolean isViewable = true; %>
<%@ include file="../other/CRUD.jsp" %>
</body>
</html>