<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<h2>Welcome to home screen user: <%=request.getAttribute("user")%> </h2>

<form action="signout" method="get">
<input type="submit" value="SignOut"/>
</form>
</body>
</html>