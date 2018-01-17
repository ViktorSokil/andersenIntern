<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <form:form action="registration" method="post" modelAttribute="userDTO">
            <form:hidden path="userId"/>
            <h1>Registration Form</h1>
            Name:<form:input path="userName"/><br/>
            Password:<form:input type="password" path="userPassword" /><br/>
            Role (write roles with spase): <form:input path="roles"/><br/>
            <input type="submit" value="Register"/>
        </form:form>

        <div>
            <a href = "/allusers">All Users</a>
        </div>
    </div>
</body>
