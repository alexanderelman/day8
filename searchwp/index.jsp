<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Search War and Peace</title>
	</head>
	<body>
		<h1>Search War and Peace for the Term Below</h1>
		<h2><font color="red">${flash}</font></h2>
		<form method="POST" action="search">
			Search Term: <input type="text" name="term"/>
			<br/>
			<input type="submit"/>
		</form>
		<c:if test="${not empty count and count ne 0}">
		<h2>
			"<strong>${param.term}</strong>" occurs ${count} time${countPL}

			on line${linePL}
		</h2>
		<ul>
		<c:forEach var="line" items="${lines}">
			<li>${line}</li>
		</c:forEach>
		</ul>
		</c:if>		
	</body>
</html>








