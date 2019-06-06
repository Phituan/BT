package com.simpleweb.model;

import com.simpleweb.entity.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentModel {
    public static boolean save (Student student){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sqlCommand = "insert into students (username, password, email, fullName, address, phone,sail) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, student.getUsername());
            preparedStatement.setString(2, student.getPassword());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getFullName());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setString(6, student.getPhone());
            preparedStatement.setString(7, student.getSalt());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public Student findByUsernameAndStatus(String username, Student.Status status){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = ConnectionHelper.getConnection();
            String sqlString = "select * from students where username = ? and status = ?";
            PreparedStatement statement = connection.prepareStatement(sqlString);
            statement.setString(1, username);
            statement.setInt(2, status.getValue());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String Name = resultSet.getString("UserName");
                String Email = resultSet.getString("Email");
                String Password = resultSet.getString("Password");
                String FullName = resultSet.getString("FullName");
                String Address = resultSet.getString("Address");
                String Phone = resultSet.getString("Phone");
                int Status = resultSet.getInt("Status");
                String Salt = resultSet.getString("Salt");

                Student student = new Student();
                student.setUsername(Name);
                student.setEmail(Email);
                student.setFullName(FullName);
                student.setPassword(Password);
                student.setAddress(Address);
                student.setPhone(Phone);
                student.setStatus(Student.Status.findByValue(Status));
                student.setSalt(Salt);
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
//        try {
//            String sqlCommand = "select * from students where  username = ? and status = ?";
//            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
//            preparedStatement.setString(1, username);
//            preparedStatement.setInt(2, status.getValue());
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()){
//                String rsUsername = resultSet.getString(1);
//                String rsPassword = resultSet.getString(2);
//                String rsEmail = resultSet.getString(3);
//                String rsFullName = resultSet.getString(4);
//                String rsAddress = resultSet.getString(5);
//                String rsPhone = resultSet.getString(6);
//                String Salt = resultSet.getString(7);
//                int rsStatus = resultSet.getInt(8);
//                Student student = new Student();
//                student.setUsername(rsUsername);
//                student.setPassword(rsPassword);
//                student.setEmail(rsEmail);
//                student.setFullName(rsFullName);
//                student.setAddress(rsAddress);
//                student.setPhone(rsPhone);
//                student.setSalt(Salt);
//                student.setStatus(Student.Status.findByValue(rsStatus));
//                return student;
//            }
//        }catch (SQLException ex){
//            ex.printStackTrace();
//        }
//        return null;
    }

    public ArrayList<Student> getList() {
        ArrayList<Student> results = new ArrayList<>();
        try {
            String sqlCommand = "select * from students";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Student student = new Student();
                student.setUsername(username);
                student.setPassword(password);
                student.setFullName(fullName);
                student.setEmail(email);
                student.setAddress(address);
                student.setPhone(phone);
                results.add(student);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }


}
