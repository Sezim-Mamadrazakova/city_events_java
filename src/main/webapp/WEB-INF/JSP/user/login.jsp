<%--
  Created by IntelliJ IDEA.
  User: Сезим
  Date: 06.04.2023
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <div>

        <form method="post" action="${pageContext.request.contextPath}/login">
            <label for="email">email:
                <input type="text"  name="email" id="email" required>
            </label><br>
            <label for="password">password:
                <input type="password"  name="password" id="password" required>
            </label><br>
            <button type="submit">войти</button>
        </form>

    </div>


</body>
</html>
