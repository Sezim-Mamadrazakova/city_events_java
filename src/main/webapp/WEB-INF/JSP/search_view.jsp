<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Сезим
  Date: 05.05.2023
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<>
<div>
  <jsp:include page="search.jsp"></jsp:include>
</div>
  <span>ID Event:   </span><c:out value="${event.getIdEvent()}"></c:out>
<br>
  <span>Event name:   </span><c:out value="${event.getEventName()}"></c:out>
<br>
  <span>Event place:   </span><c:out value="${event.getEventPlace()}"></c:out>
<br>
  <span>Event date:   </span><c:out value="${event.getDateStart()}"></c:out>
<br>
  <span>Event duration:   </span><c:out value="${event.getDuration()}"></c:out>
<br>

</body>
</html>
