<!DOCTYPE html>
<html>
	<head>
		<title>HTML Injection Example</title>
	</head>
	<body>
		<h1>What you submit will display below this line</h1>
		<h2>${param.stuff}</h2>
		<form method="POST" action="index.jsp">
			Type stuff: <input type="text" name="stuff"/>
			<input type="submit"/>
		</form>
	</body>
</html>