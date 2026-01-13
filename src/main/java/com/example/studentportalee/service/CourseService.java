package com.example.studentportalee.service;

import com.example.studentportalee.db.DBConnectionProvider;
import com.example.studentportalee.model.Course;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CourseService {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void addCourse(Course course){
        String sql = "INSERT INTO course(name,price) VALUES (?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,course.getName());
            statement.setString(2,String.valueOf(course.getPrice()));
            statement.execute();
            ResultSet resulltKeys = statement.getGeneratedKeys();
            if(resulltKeys.next()){
                course.setId(resulltKeys.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteCourse(int id){
        String sql = "DELETE FROM course WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Course> getAllCourses(){
        String sql = "Select * from course";
        List<Course> courseList = new ArrayList<>();
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Course course = new Course();
                course.setId(resultSet.getInt("id"));
                course.setName(resultSet.getString("name"));
                course.setPrice(resultSet.getDouble("price"));
                courseList.add(course);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return courseList;
    }


    public Course getCourseById(int id){
        String sql = "SELECT * FROM course WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Course course = new Course();
                course.setId(resultSet.getInt("id"));
                course.setName(resultSet.getString("name"));
                course.setPrice(resultSet.getDouble("price"));
                return course;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void changeCourse(Course course){
        String sql = "UPDATE course SET name = ?, price = ? WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,course.getName());
            statement.setString(2, String.valueOf(course.getPrice()));
            statement.setInt(3,course.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
