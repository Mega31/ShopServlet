<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: freeze
  Date: 11/19/19
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<% ArrayList<String> fruitList = (ArrayList<String>) request.getAttribute("fruitList"); %>
<p><%System.out.println(fruitList);%></p>
</body>
</html>
