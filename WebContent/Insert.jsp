<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RegiController?flag=add" method="post">
FirstName:<input type="text" name="fn"><br><br>
LastName:<input type="text" name="ln"><br><br>
<input type="Submit" value="Submit"><br><br>
<a href="<%=request.getContextPath()%>/RegiController?flag=search">Search</a>
</form>
</body>
</html>