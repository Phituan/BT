package com.simpleweb.controller;

import com.google.gson.Gson;
import com.simpleweb.entity.Student;
import com.simpleweb.model.StudentModel;
import com.simpleweb.utility.HandleString;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {

    private static StudentModel model = new StudentModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        req.setAttribute("student", student);
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        try {
            String salt = HandleString.generateSalt();
            String passwords = salt + HandleString.stringHash(password);

            Student student = new Student();

            student.setUsername(username);
            student.setEmail(email);
            student.setPassword(passwords);
            student.setAddress(address);
            student.setPhone(phone);
            student.setSalt(salt);

            boolean isSuccess = model.save(student);
            if (isSuccess) {
                resp.getWriter().println("Register success" + new Gson().toJson(student));
            } else {
                resp.getWriter().println("Register failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
