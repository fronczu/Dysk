<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<meta charset="utf-8">
<html>
<head>
    <title>Dysk</title>
</head>
<body>
<form method="POST"  action="UploadServlet" enctype="multipart/form-data">
    <input type="file" name="file" />
    <BR>
    <input type="submit" value="Upload" />
</form>
<form  action="DownloadServlet">
    <input type = "text"  name="filename">
    <input type="submit" value="Download" />
</form>

<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="CreateUserServlet">Utwórz użytkownika</a>
<br>
<a href="LoginServlet">Zaloguj się</a>
<br>
<a href="helloServlet">Check</a>
<br>
<a href="UploadServlet">Wyślij plik</a>>
<br>
<a href="DownloadServlet">Pobierz pliki</a>>
</body>
</html>