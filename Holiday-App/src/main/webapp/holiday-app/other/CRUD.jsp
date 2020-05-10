<%@ page import="univ.stud.holiday.model.entities.Entity" %>
<fieldset>
    <legend>
        <%=fieldsetTitle%>
    </legend>
    <form style="text-align: left" method="post" action="<%=actionPath%>" target="_self">
        <% for (Entity<?> entity : list) { %>
        <div style="padding: 12px;background-color: mediumaquamarine; margin-top: 2px; border: 1px solid aquamarine">
            <input type="radio" id="<%=entity.getId()%>" name="id" value="<%=entity.getId()%>"
                   required>
            <label style="height: 100%; width: 100%;" for="<%=entity.getId()%>">
                <%=entity%>
            </label>
            <br>
        </div>
        <% } %>
        <table id="baseTable" style="width: 100%">
            <tr>
                <td>
                    <input type="submit" name="operation" value="Create" style="width: 100%"
                           formnovalidate>
                </td>
                <% if (isViewable) { %>
                <td>
                    <input type="submit" name="operation" value="View" style="width: 100%">
                </td>
                <% } %>
                <td>
                    <input type="submit" name="operation" value="Edit" style="width: 100%">
                </td>
                <td>
                    <input type="submit" name="operation" value="Delete" style="width: 100%">
                </td>
            </tr>
        </table>
    </form>
</fieldset>