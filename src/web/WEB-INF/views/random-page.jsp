    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>Random Fields Page</title>

    </head>
        <body onload='onload()'>
            <form id="form" action="saverandomdata" method="post">
                <input type="button" id="button" value="Generate"/><br/>
                <input type="submit" value="Save To MongoDB"/><br/>
            </form>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script src="../../js/random_fields_generator.js"></script>
        </body>
    </html>
