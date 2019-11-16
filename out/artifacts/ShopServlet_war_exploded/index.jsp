<%--
  Created by IntelliJ IDEA.
  User: freeze
  Date: 11/15/19
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <link rel="stylesheet" href="login.css">
  <div style="text-align:center" >
      <%System.out.println("${cursor}");%>
    <form action ="panel" method="post" id="div" >
      Username:<br>
      <input type="text" name="Username"><br>
      Password:<br>
      <input type="password" name="Password"><br>
      <input type="submit" value="login">
    </form>
  </body>
</html>
