<%@page import="track.pro.task.entites.Task"%>
<%@page import="track.pro.user.entites.User"%>
<%@page import="java.util.Collections"%>
<%@page import="track.pro.project.entites.Project"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Task</title>
<link href="../css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<h1>Update Task</h1>

<% if (request.getParameter("success") != null) { %>
    <div class="toast success">
        Task added successfully!
    </div>
<% } %>

 <%
    List<Task> listOfTasks = (List<Task>) request.getAttribute("listOfTasks");
    if (listOfTasks != null) {
    	Collections.sort(listOfTasks, (r1, r2) -> r1.getTaskId() - r2.getTaskId());
    }
%>


<%
    List<Project> listOfProjects = (List<Project>) request.getAttribute("listOfProjects");
    if (listOfProjects != null) {
        Collections.sort(listOfProjects, (r1, r2) -> r1.getProjectId() - r2.getProjectId());
    }
%>
<%
List<User> listOfUsers = (List<User>) request.getAttribute("listOfUsers");
if (listOfUsers != null) {
    Collections.sort(listOfUsers, (r1, r2) -> r1.getUserId() - r2.getUserId());
}
%>



<form action="/task/task" method="post" enctype="multipart/form-data">
    
    
    Task Title:
    <select name="taskId">
        <% if (listOfTasks != null) { 
            for (Task task : listOfTasks) { %>
                <option value="<%= task.getTaskId() %>"><%= task.getTitle() %></option>
        <% } } %>
    </select><br>
    
   
    
    Start Time:
    <input type="datetime-local" name="startTime" required/><br/>
    
    Completion Time:
    <input type="datetime-local" name="compTime" required/><br/>
    
    Duration:
    <input type="number" step="0.01" name="duration" required/><br/>
    
    Assigned To:    
    <select name="assignedTo">
        <% if (listOfUsers != null) { 
            for (User user : listOfUsers) { %>
                <option value="<%= user.getUserId() %>"><%= user.getFullName() %></option>
        <% } } %>
    </select><br/>
    
     Project:
    <select name="projectId">
        <% if (listOfProjects != null) { 
            for (Project project : listOfProjects) { %>
                <option value="<%= project.getProjectId() %>"><%= project.getProjectName() %></option>
        <% } } %>
    </select><br/>
    
    
    
   
    
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