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
    <form:form action="personreg" method="post" commandName="personDTO">
        <form:hidden id="id" path="id"/>
        <h1>Registration Form</h1>
        Name:<form:input id="name" path="name"/><br/>
        Address:<form:input id="address" path="address" /><br/>
        <input id="btn-save" type="submit" value="Register"/>
    </form:form>

    <div>
        <a href = "/allpersons">All Persons</a>
    </div>
</div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="../../js/person_page.js"></script>
</body>
