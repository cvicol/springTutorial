<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Success Page</title>
</head>
<body>
User Details
<hr>
User Name   : ${user.name} <br/>
Gender      : ${user.gender} <br/>
Country     : ${user.country} <br/>
About You   : ${user.aboutYou} <br/>
Community   : ${user.community[0]}  ${user.community[1]} ${user.community[2]}<br/>
Mailing List: ${user.mailingList}
</body>
</html>