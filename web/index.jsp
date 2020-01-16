<%--
  Created by IntelliJ IDEA.
  User: freeze
  Date: 11/15/19
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <link rel="stylesheet" href="login.css">
  <div style="text-align:center" >

    <form action="login" method="post" id="div" >
      Username:<br>
      <input type="text" name="Username"><br>
      Password:<br>
      <input type="password" name="Password"><br>
      <input type="submit" value="login">
    </form>
  </div>
  <p>New to website signup <a href="${pageContext.request.contextPath}/Reg";>here</a></p>
  </body>
</html>
