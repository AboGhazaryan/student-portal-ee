package com.example.studentportalee.servlet;

import com.example.studentportalee.model.Course;
import com.example.studentportalee.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/addCourse")
public class AddCourseServlet extends HttpServlet {

    private CourseService courseService =new CourseService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addCourse.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Double price =Double.parseDouble(req.getParameter("price"));

        Course course = new Course();
        course.setName(name);
        course.setPrice(price);
        courseService.addCourse(course);
        resp.sendRedirect("/courses");
    }
}

