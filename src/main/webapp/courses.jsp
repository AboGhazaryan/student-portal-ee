<%@ page import="com.example.studentportalee.model.Course" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Courses</title>
</head>
<body>
<%List<Course> courses = (List<Course>) request.getAttribute("courses");%>
<a href="/">Home</a>
<h2>Courses</h2>

<a href="/addCourse" >Add Course</a>
<table border="1">
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Course Price</th>
        <th>Action</th>
    </tr>
    <%for (Course cours : courses) { %>
    <tr>
        <td><%=cours.getId()%></td>
        <td><%=cours.getName()%></td>
        <td><%=cours.getPrice()%></td>
        <td><a href="/deleteCourse?id=<%=cours.getId()%>">Delete</a> | <a href="/changeCourse?id=<%=cours.getId()%>">change</a></td>
    </tr>

    <% }%>
</table>
</body>
</html>
