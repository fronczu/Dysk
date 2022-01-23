<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Podaj Nazwe Pliku</h1>
<form action="LoginServlet" method="POST">
<input name="file" type="file"> </input>
<a href="helloServlet">Wyślij</a>
</form>
</body>
</html>