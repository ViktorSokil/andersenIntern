<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
        <title>All users</title>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <style>
            .container{
                width:90%;
                text-align: -webkit-center;
                padding-top: 70px;
            }
            table,th,td {
                width: auto;
                border:1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <h1 class="container">User List</h1>
    <div class="container">
        <table class="container">
            <tr><th>Id</th><th>Name</th><th>Role</th>
            <c:if test="${not empty list}">
                <c:forEach var="userDTO" items="${list}" varStatus="status">
                    <tr>
                        <td><c:out value="${userDTO.userId}"/></td>
                        <td><c:out value="${userDTO.userName}"/></td>
                        <td><c:out value="${userDTO.roles}"/></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>
    <br/>
    <a href="/">Add New User</a>
