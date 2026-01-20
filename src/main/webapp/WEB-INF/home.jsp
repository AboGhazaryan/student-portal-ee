<%@ page import="com.example.studentportalee.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<%User user = (User) session.getAttribute("user");%>
<body>
<h1>Hello Java World!</h1>
<p>
    <%if (user == null){%>
    <a href="/login">LOGIN</a>
    | <a href="/register">REGISTER</a>
    <%} else {%>
    Welcome <%=user.getName() + " " + user.getSurname()%> <a href = "/logout">LOGOUT</a>
    <%}%>

</p>
<br/>
<a href="/courses">Courses</a><br>
<a href="/students">Students</a>
</body>
</html>
