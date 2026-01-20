package com.example.studentportalee.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.Date;

@WebListener
public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setMaxInactiveInterval(1 * 60);
        System.out.println("Session Created at " + new Date() + " " + se.getSession().getId());
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session Destroyed at " + new Date() + " " + se.getSession().getId());
    }
}
