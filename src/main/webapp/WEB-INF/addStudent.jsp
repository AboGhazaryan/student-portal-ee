<%@ page import="com.example.studentportalee.model.Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
Add Student
<% List<Course> courses = (List<Course>) request.getAttribute("courses");%>
<form action="/addStudent" method="post" enctype="multipart/form-data">
    Name: <input type="text" name="name"> <br>
    Surname: <input type="text" name="surname"> <br>
    Email: <input type="text" name="email"> <br>
    Course: <select name="course_id">
    <%for (Course course : courses) { %>
        <option value="<%=course.getId()%>"><%=course.getName()%>
        </option>
    <%}%>
</select>
    <input type="file" name="pic"><br>
    <input type="submit" value="Add Student">

</form>
</body>
</html>
