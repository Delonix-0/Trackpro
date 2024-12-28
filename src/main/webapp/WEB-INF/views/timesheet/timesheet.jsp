<%@page import="track.pro.user.entites.User"%>
<%@page import="java.util.Collections"%>
<%@page import="track.pro.task.entites.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Timesheet</title>
<link href="../css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <% if (request.getParameter("success") != null) { %>
        <div class="toast success">
            Timesheet submitted successfully!
        </div>
    <% } %>
    
    
   <%
    List<Task> listOfTasks = (List<Task>) request.getAttribute("listOfTasks");
    if (listOfTasks != null) {
    	Collections.sort(listOfTasks, (r1, r2) -> r1.getTaskId() - r2.getTaskId());
    }
%>

<%
List<User> listOfUsers = (List<User>) request.getAttribute("listOfUsers");
if (listOfUsers != null) {
    Collections.sort(listOfUsers, (r1, r2) -> r1.getUserId() - r2.getUserId());
}

%>

<h1>Timesheet</h1>

<form action="/timesheet/fillTimesheet" method="post" enctype="multipart/form-data">
    
    Task Title:
    <select name="taskId">
        <% if (listOfTasks != null) { 
            for (Task task : listOfTasks) { %>
                <option value="<%= task.getTaskId() %>"><%= task.getTitle() %></option>
        <% } } %>
    </select><br>
    
    
        
      Full Name:
        <select name="userId">
            <% if (listOfUsers != null) { 
                for (User user : listOfUsers) { %>
                    <option value="<%= user.getUserId() %>"><%= user.getFullName() %></option>
            <% } } %>
        </select><br>
    
    <label for="date">Date:</label>
    <input type="datetime-local" id="date" name="date" required/><br/>
    <input type="number" step="0.01" name="hoursLogged" placeholder="Enter Hours Logged" required/><br/>
    
    <label for="createdAt">Created At:</label>
    <input type="datetime-local" id="createdAt" name="createdAt" required/><br/>
   
    <input type="submit" value="Submit"/>
</form>

<script>
    // Hide the toast after 3 seconds
    setTimeout(function() {
        var toast = document.querySelector('.toast');
        if (toast) {
            toast.style.display = 'none';
        }
    }, 3000);
</script>

</body>
</html>