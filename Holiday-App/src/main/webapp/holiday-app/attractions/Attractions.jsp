<%@ page import="univ.stud.holiday.model.entities.Attraction" %>
<%@ page import="univ.stud.holiday.model.services.database.MySqlDatabaseHoliday" %>
<%@ page import="java.util.List" %>
<%@ page import="static jdk.nashorn.internal.objects.ArrayBufferView.length" %>
<%@ page import="univ.stud.holiday.model.*" %>
<%@ page import="java.util.List" %>
<%
    List<? extends Entity<?>> list = MySqlDatabaseHoliday.getInstance().attractionDao().getElements();
    String actionPath = "/holiday-app/attractions";
    String fieldsetTitle = "Attractions";
    String elementId = "attractionId";
    String element = "attraction";
%>
<html>
<head>
    <title>
        Holiday-App
    </title>
    <link rel="stylesheet" href="../../styles/mainStyle.css">
</head>
<body>
<% boolean isViewable = false; %>
<%@ include file="../other/CRUD.jsp" %>
</body>
</html>

<%--<%@ page import="univ.stud.holiday.model.*" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%--%>
<%--    List<? extends Entity<?>> list = HolidayRepository.fetchVisitsForHoliday((Integer) session.getAttribute("attractionId"));--%>
<%--    String actionPath = "/holiday-app/attractions";--%>
<%--    String fieldsetTitle = "Attractions";--%>
<%--    String elementId = "attractionId";--%>
<%--    String element = "attraction";--%>
<%--%>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>--%>
<%--        Holiday-App--%>
<%--    </title>--%>
<%--    <link rel="stylesheet" href="../../styles/mainStyle.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--<% boolean isViewable = true; %>--%>
<%--<%@ include file="../other/CRUD.jsp" %>--%>
<%--</body>--%>
<%--</html>--%>