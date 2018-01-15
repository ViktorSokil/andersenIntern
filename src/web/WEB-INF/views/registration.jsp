<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <style>
        .container{
            width:100%;
            text-align: -webkit-center;
            padding-top: 70px;
        }
    </style>
</head>
<body>
    <div class="container">
        <form action="registration" method="post">
            <h1>Registration Form</h1>
            Name:<input type="text" name="userName"/><br/>
            Password:<input type="password" name="password"/><br/>
            Role (write roles with spase): <input type="text" name="role"/><br/>
            <input type="submit" value="Register"/>
        </form>
        <form action="allusers" method="get">
          <button role="button">All users</button>
        </form>
    </div>
</body>
