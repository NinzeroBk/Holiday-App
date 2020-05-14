<%@ page import="univ.stud.holiday.common.Pair" %>
<%@ page import="univ.stud.holiday.model.HolidayRepository" %>
<%@ page import="univ.stud.holiday.model.entities.Holiday" %>
<%@ page import="univ.stud.holiday.model.entities.Location" %>
<%@ page import="univ.stud.holiday.model.entities.User" %>
<%@ page import="univ.stud.holiday.model.services.database.MySqlDatabaseHoliday" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    User user = HolidayRepository.fetchUser((String) session.getAttribute("username"));
    double totalCosts = MySqlDatabaseHoliday.getInstance().userDao().totalCost(user.getId());
    Location location = MySqlDatabaseHoliday.getInstance().locationDao().mostVisitedAttraction(user.getId());
    Holiday longestHoliday = MySqlDatabaseHoliday.getInstance().holidayDao().longestHoliday(user.getId());
    Pair<Holiday, Double> mostExpensiveHoliday = MySqlDatabaseHoliday.getInstance().holidayDao().mostExpensiveHoliday(user.getId());
%>
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <Title>Holiday-App</title>
    <link rel="stylesheet" href="../../styles/mainStyle.css">
</head>
<body>
<fieldset style="background-color: aquamarine">
    <legend>Hello, <%=user.getId()%> &#9995;</legend>
    <table style="width: 100%; font-size: 2vw">
        <tr>
            <td rowspan="9">
                <img class="avatar" src="<%=user.getImageUrl()%>" title="<%=user.getId()%>" alt="">
            </td>
        </tr>
        <tr>
            <td>
                <b>First Name:</b> <%=user.getFirstName()%>
            </td>
        </tr>
        <tr>
            <td>
                <b>Last Name:</b> <%=user.getLastName()%>
            </td>
        </tr>
        <tr>
            <td>
                <b>Email Address:</b>
                <a href="mailto:<%=user.getEmailAddress()%>">
                    <%=user.getEmailAddress()%>
                </a>
            </td>
        </tr>
        <tr>
            <td>
                <b>Total money spent:</b> $<%=totalCosts%>.
            </td>
        </tr>
        <tr>
            <td>
                <b>Most visited location:</b> <%=location%>
            </td>
        </tr>
        <tr>
            <td>
                <b>Longest holiday:</b> <%=longestHoliday%>
            </td>
        </tr>
        <tr>
            <td>
                <b>
                    Most expensive holiday
                    ($<% if (mostExpensiveHoliday != null) out.print(mostExpensiveHoliday.getSecondKey());%>):
                </b>
                <% if (mostExpensiveHoliday != null) out.print(mostExpensiveHoliday.getFirstKey()); %>
            </td>
        </tr>
        <tr>
            <td>
                <form method="post" action="/holiday-app/holidays">
                    <input style="font-size: 2vw" type="submit" name="operation" value="Logout">
                </form>
                <form method="post" action="/holiday-app/holidays">
                    <input style="font-size: 2vw" type="submit" name="operation" value="Delete Account">
                </form>
            </td>
        </tr>
    </table>
</fieldset>
<%
    List<? extends Entity<?>> list = HolidayRepository.fetchHolidaysForUser(user.getId());
    String actionPath = "/holiday-app/holidays";
    String fieldsetTitle = "Holidays";
    boolean isViewable = true;
%>
<%@ include file="../other/CRUD.jsp" %>
</body>
</html>