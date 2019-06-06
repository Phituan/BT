<%@ page import="com.simpleweb.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/11/2019
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!------ Include the above in your HEAD tag ---------->
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Fonts -->
  <link rel="dns-prefetch" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

  <title>ABC</title>
    <style>
        @import url(https://fonts.googleapis.com/css?family=Raleway:300,400,600);


        body{
            margin: 0;
            font-size: .9rem;
            font-weight: 400;
            line-height: 1.6;
            color: #212529;
            text-align: left;
            background-color: #f5f8fa;
        }

        .navbar-laravel
        {
            box-shadow: 0 2px 4px rgba(0,0,0,.04);
        }

        .navbar-brand , .nav-link, .my-form, .login-form
        {
            font-family: Raleway, sans-serif;
        }

        .my-form
        {
            padding-top: 1.5rem;
            padding-bottom: 1.5rem;
        }

        .my-form .row
        {
            margin-left: 0;
            margin-right: 0;
        }

        .login-form
        {
            padding-top: 1.5rem;
            padding-bottom: 1.5rem;
        }

        .login-form .row
        {
            margin-left: 0;
            margin-right: 0;
        }
    </style>
  <%
    Student student = (Student) request.getAttribute("student");
    if (student == null){
      student = new Student();
    }
  %>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light navbar-laravel">
  <div class="container">
    <a class="navbar-brand" href="#">Hello My Love</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="/user/login">Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Register</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<main class="my-form">
  <div class="cotainer">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header">Register</div>
          <div class="card-body">
            <form name="my-form" action="/student/register" method="post">
              <div class="form-group row">
                <label class="col-md-4 col-form-label text-md-right">User Name</label>
                <div class="col-md-6">
                  <input type="text" class="form-control" name="username" value="<%=student.getUsername()%>">
                </div>
              </div>
              <div class="form-group row">
                <label class="col-md-4 col-form-label text-md-right">Password</label>
                <div class="col-md-6">
                  <input type="password" class="form-control" name="password">
                </div>
              </div>
              <div class="form-group row">
                <label  class="col-md-4 col-form-label text-md-right">E-Mail</label>
                <div class="col-md-6">
                  <input type="text" class="form-control" name="email" value="<%=student.getEmail()%>">
                </div>
              </div>
              <div class="form-group row">
                <label  class="col-md-4 col-form-label text-md-right">Full Name</label>
                <div class="col-md-6">
                  <input type="text" class="form-control" name="fullName" value="<%=student.getFullName()%>">
                </div>
              </div>
              <div class="form-group row">
                <label  class="col-md-4 col-form-label text-md-right">Address</label>
                <div class="col-md-6">
                  <input type="text" class="form-control" name="address" value="<%=student.getAddress()%>">
                </div>
              </div>
              <div class="form-group row">
                <label  class="col-md-4 col-form-label text-md-right">Phone Number</label>
                <div class="col-md-6">
                  <input type="text" class="form-control" name="phone" value="<%=student.getPhone()%>">
                </div>
              </div>
              <div class="form-group row">
                <label  class="col-md-4 col-form-label text-md-right">Role</label>
                <div class="dropdown show">
                  <div class="col-md-6">
                    <a class="btn btn-secondary dropdown-toggle" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Role
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                      <a class="dropdown-item" href="#">User</a>
                      <a class="dropdown-item" href="#">Admin</a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-6 offset-md-4">
                <button type="submit" class="btn btn-primary" value="Submit">
                  Register
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</main>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>