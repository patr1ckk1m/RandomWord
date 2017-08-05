<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Random word generator</title>
</head>
<body>
	<h1>you have generated a word ${wordcount} times</h1>
	<h1>${randomString}</h1>
	<form action = "/RandomWord/Random" method = "post">
		<input type = "submit" value = "Generate">
	</form>
	<h1>The last time you generated a word was: </h1>
	<h1>This is where date goes</h1>
</body>
</html>