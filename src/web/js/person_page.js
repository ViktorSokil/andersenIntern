jQuery(document).ready(
    function($) {

        $("#btn-save").click(function(event) {

            var data = {}
            data["id"] = $("#id").val();
            data["name"] = $("#name").val();
            data["address"] = $("#address").val();

            $("#btn-save").prop("disabled", true);

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/personreg",
                data: JSON.stringify(data),
                dataType: 'json',
                timeout: 600000,
                success: function (data) {
                    $("#btn-save").prop("disabled", false);
                    //...
                },
                error: function (e) {
                    $("#btn-save").prop("disabled", false);
                    //...
                }
            });


        });

    });
