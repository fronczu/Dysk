
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Załóż Konto</title>
    <script src=
                    "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script>
        $(document).ready(function() {
            $("li:parent").css("background-color", "green");
        });
    </script>
</head>
</head>
<body>

<h1 style="color:green">
    GeeksForGeeks
</h1>

<h2>
    jQuery ajax() Method
</h2>

<h3 id="h11"></h3>

<button>Click</button>

<!-- Script to use ajax() method to
    add text content -->
<script>
    $(document).ready(function() {
        $("button").click(function() {
            $.ajax({url: "geeks.txt",
                success: function(result) {
                    $("#h11").html(result);
                }});
        });
    });
</script>




<form method="POST"  action="CreateUserServlet" >
    <input type="Text" name="UserName" />
    <br>
    <input type="Password" name="Password" />
    <BR>
    <input type="submit" value="Załóż Konto" />
</form>

</body>
</html>
