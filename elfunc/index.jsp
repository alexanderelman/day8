<%@ taglib prefix="acc" uri="DiceFunctions" %>
<!DOCTYPE html>
<html>
	<body>
		<h1>Using an EL Function</h1>
		<p>The die roll is: ${acc:rollIt()}.</p>
		<p>The random double is: ${acc:b()}.</p>
		<jsp:useBean id="d" class="edu.acc.j2ee.elfunc.DieBean"
			scope="request"/>
		<p>The D20 is: ${d.roll(20)}</p>
	</body>
</html>