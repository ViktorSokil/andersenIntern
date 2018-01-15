<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
        <title>All users</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <style>
            .container{
                width:100%;
                text-align: -webkit-center;
                padding-top: 70px;
            }
            table,th,td {
                border:1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <div class="container">
        <%-- Using JSTL forEach and out to loop a list and display items in table --%>
            <table>
                <tbody>
                    <tr>
                        <h1>User details</h1>
                    </tr>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Roles</th>
                    </tr>
                    <c:forEach items="${requestScope.users}" var="user">
                        <tr>
                            <td><c:out value="${user.userId}"></c:out></td>
                            <td><c:out value="${user.userName}"></c:out></td>
                            <td><c:forEach items="${user.roles}" var="roles">
                                    <c:out value="${roles}"></c:out>
                                </c:forEach>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
