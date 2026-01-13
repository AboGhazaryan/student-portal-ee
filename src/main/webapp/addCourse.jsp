
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Course</title>
</head>
<body>

<a href="/">Home</a>
<a href="/courses">Coures</a>
<form action="/addCourse" method="post">
    Name:<input type="text" name="name"><br>
    Price:<input type="number" name="price"><br>
    <input type="submit" value="Add Course"><br>
</form>
</body>
</html>
