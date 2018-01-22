<%--
  Created by IntelliJ IDEA.
  User: Viktor
  Date: 22.01.2018
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>Random Fields Page</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
        <script type="text/javascript">
            var gRandLength = 7;

            $(document).ready(function() {
                $('#button').click(function() {
                    var num = Math.floor(1 + (Math.random() * Math.pow(10, gRandLength)));
                    $('#input').val(num);
                });
            });
        </script>
    </head>
        <body onload='onload()'>
            <form action="saverandomdata" method="post">
                <input type="text" value="" id="input" />
                <input type="button" id="button" value="Generate"/>
                <input type="submit" value="Save To MongoDB"/>
            </form>
        </body>
    </html>
