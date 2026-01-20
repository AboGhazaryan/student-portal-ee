package com.example.studentportalee.service;

import com.example.studentportalee.db.DBConnectionProvider;
import com.example.studentportalee.model.User;
import com.example.studentportalee.model.UserRole;


import java.sql.*;

public class UserService {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void addUser(User user) {
        String sql = "INSERT INTO user (name, surname, username, password, role) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement pr = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pr.setString(1, user.getName());
            pr.setString(2, user.getSurname());
            pr.setString(3, user.getUsername());
            pr.setString(4, user.getPassword());
            pr.setString(5, user.getRole().toString());
            pr.executeUpdate();
            ResultSet rs = pr.getGeneratedKeys();
            if(rs.next()){
                user.setId(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public User getUserBYUsernameAndPassword(String username, String password){
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try(PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, username);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSurname(rs.getString(3));
                user.setUsername(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setRole(UserRole.valueOf(rs.getString(6)));
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public User getUserBYUsername(String username){
        String sql = "SELECT * FROM user WHERE username = ?";
        try(PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, username);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSurname(rs.getString(3));
                user.setUsername(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setRole(UserRole.valueOf(rs.getString(6)));
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
