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
