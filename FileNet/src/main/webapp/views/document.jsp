<%@page import="ru.damirqa.model.documents.Document"%>
<%@page import="java.util.SortedSet"%>
<%@page import="ru.damirqa.model.staff.Person"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="ru.damirqa.storage.Repository"%>
<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	if (request.getParameter("id") != null) {
		for (Document document : Repository.STORAGE) {
			if (document.getId() == Integer.parseInt(request.getParameter("id"))) {
				out.print("Идентификатор документа - " + document.getId() + "</br>");
				out.print("Регистрационный номер документа - " + document.getRegistrationNumber() + "</br>");
				out.print("Дата регистрации документа - " + document.getDateRegistration() + "</br>");
				out.print("Автор документа - " + document.getAuthor() + "</br>");
			}
		}
	}
%>
</body>
</html>