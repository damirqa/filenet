<%@page import="ru.damirqa.storage.Repository"%>
<%@page import="ru.damirqa.model.documents.Document"%>
<%@page import="java.util.SortedSet"%>
<%@page import="ru.damirqa.model.staff.Person"%>
<%@page import="java.util.Map.Entry"%>
<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
	<table>
		<tr><th>id</th><th>Имя</th><th>Фамилия</th><th>Отчество</th></tr>
		<%
			for(Entry<Person, SortedSet<Document>> link : Repository.report.entrySet()) {
				out.print("<tr onclick=location.href='../views/authorDocuments.jsp?id=" + link.getKey().getId() + "'>" + 
							"<td>" + link.getKey().getId() + "</td>" +
							"<td>" + link.getKey().getFirstName() + "</td>" +
							"<td>" + link.getKey().getLastName() + "</td>" + 
							"<td>" + link.getKey().getMiddleName() + "</td>" +				
						  "</tr>");
			}
		%>
	</table>
</body>
</html>