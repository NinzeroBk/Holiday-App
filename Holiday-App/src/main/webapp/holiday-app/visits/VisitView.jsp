<%@ page import="univ.stud.holiday.model.HolidayRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="univ.stud.holiday.model.services.database.MySqlDatabaseHoliday" %>
<%@ page import="univ.stud.holiday.model.entities.Visited" %>
<%@ page import="univ.stud.holiday.model.entities.Attraction" %>
<%@ page import="univ.stud.holiday.model.entities.Holiday" %>
<%
    Visited visited = MySqlDatabaseHoliday.getInstance().visitedDao().readElement((Integer) session.getAttribute("visitedId"));
    Attraction attraction = MySqlDatabaseHoliday.getInstance().attractionDao().readElement(visited.getAttractionId());
    Holiday holiday = MySqlDatabaseHoliday.getInstance().holidayDao().readElement(visited.getHolidayId());
%>
<!DOCTYPE>
<html>
<head>
    <title>
        Holiday-App
    </title>
    <link rel="stylesheet" href="../../styles/mainStyle.css">
</head>
<body>
<div style="padding: 10px; background-color: bisque">
    <h1>
        Visit
    </h1>
    <p>
        <%=visited%>
    </p>
</div>
<div style="margin-top: 10px; padding: 10px; background-color: coral">
    <h1>
        Attraction
    </h1>
    <p>
        <%=attraction%>
    </p>
</div>
<div style="margin-top: 10px; padding: 10px; background-color: olive">
    <h1>
        Holiday
    </h1>
    <p>
        <%=holiday%>
    </p>
</div>
<%
    List<? extends Entity<?>> list = HolidayRepository.fetchReviewsForVisit(visited.getId());
    String actionPath = "/holiday-app/reviews";
    String fieldsetTitle = "Reviews";
    String elementId = "reviewId";
    boolean isViewable = false;
    String element = "review";
%>
<%@ include file="../other/CRUD.jsp" %>
<%
    list = HolidayRepository.fetchExpensesForVisit(visited.getId());
    actionPath = "/holiday-app/expenses";
    fieldsetTitle = "Expenses";
    elementId = "expenseId";
    element = "expense";
%>
<%@ include file="../other/CRUD.jsp" %>
<%
    list = HolidayRepository.fetchResourcesForVisit(visited.getId());
    actionPath = "/holiday-app/resources";
    fieldsetTitle = "Resources";
    elementId = "resourceId";
    element = "resource";
%>
<%@ include file="../other/CRUD.jsp" %>
</body>
</html>