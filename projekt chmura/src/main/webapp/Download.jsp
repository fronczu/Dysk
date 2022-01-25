<%--
  Created by IntelliJ IDEA.
  User: Michał
  Date: 09.11.2021
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <title>Title</title>
    <script>

        $(document).ready(function(){
            $("#mojdysk").click(function(){
                console.log("XDDD");
                $.ajax({url: "FetchAjaxRequest",
                    type:'POST',
                    success: function(result){
                        $("#centralContainer").html(result);
                    }});
            });
        });
    </script>


</head>
<body>
<a id = "mojdysk">Klikaj mnie  </a>
</body>
</html>
