<%--
  Created by IntelliJ IDEA.
  User: Michał
  Date: 09.11.2021
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="POST"  action="UploadServlet" enctype="multipart/form-data">
    <input type="file" name="file" />
    <BR>
    <input type="submit" value="Upload" />
</form>

</body>
</html>
