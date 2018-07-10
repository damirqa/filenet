<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<script type="text/javascript">
	window.onload = function() {
		
		getPersons();
		
		function getPersons() {
			var xhttp = new XMLHttpRequest();
			xhttp.open("GET", "../app/ecm/employees", true);
			xhttp.onload = function() {
				var persons = JSON.parse(xhttp.responseText);
				if (xhttp.readyState == 4 && xhttp.status == "200") {
					createTable(persons);
					console.log(persons[1].length);
				}
				else {
					console.error(persons);
				}
			}
			xhttp.send();
		}

		function createTable(persons) {
			for (i = 0; i < persons.length; i++) {
				document.getElementById('pers').innerHTML = "<tr><td>" + persons[i].id + "</td></tr>";
				document.writeln("<tr>" + 
						"<td>" + persons[i].firstName + "</td>" +
						"</tr>");
			}
		}
	}
</script>
<body>
	<table id="pers">
		<tr><th>id</th><th>Имя</th><th>Фамилия</th><th>Отчество</th></tr>
	</table>
</body>
</html>