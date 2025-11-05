<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Accounts</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 100px;
            background-color: #f8f9fa;
        }
        h1 {
            color: #333;
        }
        a {
            display: inline-block;
            margin: 20px;
            padding: 10px 20px;
            text-decoration: none;
            color: white;
            background-color: #007BFF;
            border-radius: 5px;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%
    String success = (String) request.getAttribute("success");
    String error = (String) request.getAttribute("error");
%>

<% if (success != null) { %>
    <p style="color: green; font-weight: bold;"><%= success %></p>
<% } %>

<% if (error != null) { %>
    <p style="color: red; font-weight: bold;"><%= error %></p>
<% } %>
<h1>Welcome to User Account System</h1>
<a href="signin">Sign In</a>
<a href="signup">Sign Up</a>
</body>
</html>
