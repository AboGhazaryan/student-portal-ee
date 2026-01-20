<%@ page import="com.example.studentportalee.model.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Course</title>
</head>
<%Course course = (Course) request.getAttribute("course"); %>

<body>

<a href="/">Home</a>
<a href="/courses">Courses</a>

<form action="/changeCourse" method="post">
    <input type="hidden" name="id" value="<%=course.getId()%>">
    Name: <input type="text" name="name" value="<%=course.getName()%>"><br>
    Price: <input type="number" name="price" value="<%=course.getPrice()%>"><br>
    <input type="submit" value="Change Course">
</form>
</body>
</html>
