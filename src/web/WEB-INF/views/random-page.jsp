
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>Random Fields Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $ ("#button").click(function () {
                    var count = Math.floor((Math.random() * 5) + 1);
                    $(".field").remove();
                    for (var i = 1; i <= count; i++) {
                        random(i);
                    }
                })

                function random(i) {
                    var element = document.getElementById('form');
                    var input = document.createElement('input')
                    input.setAttribute("class", "field")
                    input.setAttribute("type", "text");
                    input.setAttribute("name", i);
                    var br = document.createElement('br');
                    br.setAttribute("class", "field");
                    var fragment = document.createDocumentFragment();
                    fragment.appendChild(input);
                    fragment.appendChild(br);
                    element.appendChild(fragment);
                }
            });
        </script>
    </head>
        <body onload='onload()'>
            <form id="form" action="saverandomdata" method="post">
                <input type="button" id="button" value="Generate"/><br/>
                <input type="submit" value="Save To MongoDB"/><br/>
            </form>
        </body>
    </html>
