<%@page import="ru.damirqa.storage.Employees"%>
<%@page import="ru.damirqa.storage.Repository"%>
<%@page import="ru.damirqa.model.documents.Document"%>
<%@page import="java.util.SortedSet"%>
<%@page import="ru.damirqa.model.staff.Person"%>
<%@page import="java.util.Map.Entry"%>
<%@page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	if (request.getParameter("id") != null) {
		for (Entry<Person, SortedSet<Document>> link : Repository.report.entrySet()) {
			if (link.getKey().getId() == Integer.parseInt(request.getParameter("id"))) {
				for (Document document : link.getValue()) {
					out.print("Идентификатор документа: <a href='../views/document.jsp?id=" + document.getId() + "'> " + document.getId() + "</a></br>" );
				}
			}
		}
	} 
	else {
		out.print("error");
	}
%>
</body>
</html>