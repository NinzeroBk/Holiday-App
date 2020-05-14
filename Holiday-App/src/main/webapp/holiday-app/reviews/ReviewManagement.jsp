<%@ page import="univ.stud.holiday.model.entities.Review" %>
<%
    String title = request.getAttribute("title") == null ? "" : (String) request.getAttribute("title");
    String rating;
    if (request.getAttribute("rating") == null) {
        rating = String.valueOf(Review.RATING_MIN / 2 + (Review.RATING_MAX - Review.RATING_MIN) / 2);
    } else {
        rating = (String) request.getAttribute("title");
    }
    String content = request.getAttribute("content") == null ? "" : (String) request.getAttribute("content");
    String timestamp = request.getAttribute("timestamp") == null ? "" : (String) request.getAttribute("timestamp");
    String errorMessage = request.getAttribute("errorMessage") == null ? "" : (String) request.getAttribute("errorMessage");
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
<h1>
    Review Form
</h1>
<form autocomplete="on" method="post" action="/holiday-app/reviews/review-<%=operation%>">
    <label for="title">Title:</label>
    <br>
    <input type="text" id="title" name="title" value="<%=title%>" maxlength="<%=Review.TITLE_MAX_LENGTH%>" required
           autofocus>
    <br>
    <br>
    <label for="rating">
        Rating:
    </label>
    <br>
    <%=Review.RATING_MIN%>
    <input type="range" id="rating" name="rating" min="<%=Review.RATING_MIN%>" max="<%=Review.RATING_MAX%>"
           step="0.01" value="<%=rating%>" required>
    <%=Review.RATING_MAX%>
    <output name="x" for="rating rating"></output>
    <br>
    <br>
    <label for="content">
        Content:
    </label>
    <br>
    <textarea id="content" name="content" maxlength="<%=Review.CONTENT_MAX_LENGTH%>" required cols="20"
              rows="10"><%=content%></textarea>
    <br>
    <br>
    <label for="timestamp">
        Timestamp:
    </label>
    <br>
    <input type="datetime-local" id="timestamp" name="timestamp" value="<%=timestamp%>" required>
    <br>
    <br>
    <input type="submit" value="Submit">
</form>
<% if (errorMessage != null) { %>
<p>
    <%=errorMessage%>
</p>
<% } %>
</body>
</html>