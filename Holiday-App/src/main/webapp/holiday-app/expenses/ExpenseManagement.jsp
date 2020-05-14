<%@ page import="univ.stud.holiday.model.entities.Expense" %>
<%
    String errorMessage = request.getAttribute("errorMessage") == null ? "" : (String) request.getAttribute("errorMessage");
    String name = request.getAttribute("name") == null ? "" : (String) request.getAttribute("name");
    String price = request.getAttribute("price") == null ? "" : (String) request.getAttribute("price");
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
<form method="post" action="/holiday-app/expenses/expense-<%=operation%>" autocomplete="on">
    <h1>
        Expense Form
    </h1>
    <br>
    <label for="name">
        Name of the purchase:
    </label>
    <br>
    <input type="text" id="name" name="name" value="<%=name%>" autofocus required>
    <br>
    <br>
    <label for="price">
        Price of the purchase:
    </label>
    <br>
    <input type="number" id="price" name="price" value="<%=price%>" step="any" required min="<%=Expense.PRICE_MIN%>">
    <br>
    <br>
    <input type="submit" value="Submit">
</form>
<% if (errorMessage != null) { %>
<p class="error">
    <%=errorMessage%>
</p>
<% } %>
</body>
</html>