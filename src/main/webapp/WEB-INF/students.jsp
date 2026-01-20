<%@ page import="com.example.studentportalee.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.studentportalee.model.User" %>
<%@ page import="com.example.studentportalee.model.UserRole" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
<%User user = (User) session.getAttribute("user");%>
<%List<Student> students = (List<Student>) request.getAttribute("students");%>
<a href="/">Home</a>
<a href="/addStudent">Add Student</a>
<h2>Students</h2>

<table border="1">
    <tr>
        <th>Student ID</th>
        <th>Picture</th>
        <th>Student Name</th>
        <th>Student Surname</th>
        <th>Student Email</th>
        <th>Course Name</th>
        <%if(user.getRole() == UserRole.ADMIN){%>
        <th>Action</th>
        <%}%>
    </tr>
        <%for (Student student : students) { %>
    <tr>
        <td><%=student.getId()%></td>
        <td>
            <%if(student.getPictureName() == null || student.getPictureName().isEmpty()){%>
            <img width="50" src="/img/img.png"/>
            <%}else{%>
            <img width="50" src="/getImage?picture_name=<%=student.getPictureName()%>">
            <%}%>
        </td>
        <td><%=student.getName()%></td>
        <td><%=student.getSurname()%></td>
        <td><%=student.getEmail()%></td>
        <td><%=student.getCourse().getName()%></td>
        <%if(user.getRole() == UserRole.ADMIN){%>
        <td><a href="/deleteStudent?id=<%=student.getId()%>">delete</a> | <a href="/changeStudent?id=<%=student.getId()%>">change</a> </td>
        <%}%>
    </tr>
    <%}%>
</table>
</body>
</html>
