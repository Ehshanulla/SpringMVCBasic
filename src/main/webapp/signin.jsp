<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
</head>
<body>
<%
    String error = (String) request.getAttribute("error");
%>

<% if (error != null) { %>
    <p style="color: red; font-weight: bold;"><%= error %></p>
<% } %>
<form action="signin" method="post">
    <label>EmailId</label>
    <input type="email" name="email"/><br/>
    <label>Password</label>
    <input type="password" name="password"/><br/>
    <input type="submit" value="SignIn"/>
    <input type="reset" value="reset"/>
</form>
</body>
</html>