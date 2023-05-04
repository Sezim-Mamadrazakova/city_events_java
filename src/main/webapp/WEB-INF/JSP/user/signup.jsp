<%--
  Created by IntelliJ IDEA.
  User: Сезим
  Date: 06.04.2023
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<c:if test="${requestScope.getOrDefault('userCreated',false)==false}">

    <div>
        <h2>Регистрация</h2>
        <form method="post" action="${pageContext.request.contextPath}/signup">
            <label for="email">email:
            <input type="text" id="email" name="email">
            </label><br>

            <label for="password">password:
            <input type="password" id="password" name="password">
            </label><br>
            <label for="fullName">fullName:
            <input type="text" id="fullName" name="fullName">
            </label><br>
            <label for="city">city:
            <input type="text" id="city" name="city">
            </label><br>
            <input type="submit" value="зарегистрироваться">
        </form>
        <p><a href="login">войти</a></p>
    </div>
</c:if>
<c:if test="${requestScope.getOrDefault('userCreated',false)==true}">
    <div>

        <form method="get"
              action="${pageContext.request.contextPath}/welcome">
<%--            <h4 style="justify-content: center; display:flex;">Вы зарегистрированы!</h4>--%>
            <div style=" justify-content: center; display:flex;">
                <input type="submit" value="войти">
            </div>
        </form>

    </div>
</c:if>

</body>
</html>