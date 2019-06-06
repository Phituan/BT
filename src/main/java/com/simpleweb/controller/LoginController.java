package com.simpleweb.controller;

import com.google.gson.Gson;
import com.simpleweb.entity.Student;
import com.simpleweb.model.StudentModel;
import com.simpleweb.utility.HandleString;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private StudentModel model = new StudentModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                System.out.println(cookie.getName() + "-" + cookie.getValue() + "-" + cookie.getDomain());
            }
        }
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("currentloggerIn");
        req.setAttribute("student", student);
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String inputPassword = req.getParameter("password");
        String inputUsername = req.getParameter("username");
        try {

            Student student = model.findByUsernameAndStatus(inputUsername, Student.Status.DEATIVE);
            if (student == null) {
                resp.getWriter().println("Account not found");
                resp.setStatus(404);
            } else {
                String password = student.getSalt() + HandleString.stringHash(inputPassword);
                System.out.println(password);
                if (password.equals(student.getPassword())) {
                    HttpSession session = req.getSession();
                    session.setAttribute("currentLoggerIn", student);
                    resp.getWriter().println("Login success" + new Gson().toJson(student));
                    resp.setStatus(200);
                } else {
                    resp.getWriter().println("Login failure");
                    resp.setStatus(401);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            Student student = model.findByUsernameAndStatus(inputUsername,Student.Status.ACTIVE);
//            if (student == null){
//                resp.setStatus(404);
//                resp.getWriter().println("Tài khoản không tồn tại hoạc đã xóa.");
//            }else {
//                String password = student.getSalt() + HandleString.stringHash(inputPassword);
//                System.out.println(password);
//                if (inputPassword.equals(student.getPassword())){
//                    HttpSession session = req.getSession();
//                    session.setAttribute("currentLoggerIn", student);
//                    resp.setStatus(200);
//                    resp.getWriter().println("Login thành công");
//                }else {
//                    resp.setStatus(404);
//                    resp.getWriter().println("Sai thông tin tài khoản");
//                }
//            }
//        }catch (Exception ex){
//           ex.fillInStackTrace();
//        }
    }
}
