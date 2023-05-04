<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Сезим
  Date: 27.04.2023
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <ul>
        <li><a href="<%=request.getContextPath()%>/list"></a></li>
    </ul>
</header>
<div>


    <c:if test="${event.getIdEvent()!=null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${event.getIdEvent()==null}">
        <form method="post" action="insert">
            </c:if>
            <caption>
                <c:if test="${event.getIdEvent()!=null}">
                    Edit
                </c:if>
                <c:if test="${event.getIdEvent()==null}">
                    Add
                </c:if>


            </caption>
            <c:if test="${event!=null}">
                <input type="hidden" name="idEvent" value="<c:out value="${event.getIdEvent()}" />"/>
            </c:if>
            <%--    Event ID: <input type="text" readonly="readonly" name="idEvent"--%>
            <%--                     value="<c:out value="${event.getIdEvent()}" />"/> <br/>--%>
            Event Name : <input type="text" id="eventName" name="eventName"
                                value="<c:out value="${event.getEventName()}"/>"/><br/>
            Event Place : <input type="text" id="eventPlace" name="eventPlace"
                                 value="<c:out value="${event.getEventPlace()}" />"/> <br/>
            Event date : <input type="text" id="dateStart" name="dateStart"
                                value="<c:out value="${event.getDateStart()}" />"/> <br/>
            Event duration : <input type="text" id="duration" name="duration"
                                    value="<c:out value="${event.getDuration()}" />"/> <br/>
            <input type="submit" >Save</input>
        </form>

</div>
<%--    <form method="post" action="${pageContext.request.contextPath}/WelcomePageServlet" name="addEvent">--%>
<%--        Event ID: <input type="text" readonly="readonly" name="idEvent"--%>
<%--                         value="<c:out value="${event.getIdEvent()}" />"/> <br/>--%>
<%--        Event Name : <input type="text" name="eventName"--%>
<%--                           value="<c:out value="${event.getEventName()}"/>"/><br/>--%>
<%--        Event Place : <input type="text" name="eventPlace"--%>
<%--                             value="<c:out value="${event.getEventPlace()}" />"/> <br/>--%>
<%--        Event date : <input type="text" name="dateStart"--%>
<%--                            value="<c:out value="${event.getDateStart()}" />"/> <br/>--%>
<%--        Event duration : <input type="text" name="duration"--%>
<%--                                value="<c:out value="${event.getDuration()}" />"/> <br/>--%>
<%--        <input type="submit" value="Submit"/>--%>


<%--    </form>--%>
<div>
    <a href="${pageContext.request.contextPath}/welcome">Back to list</a>
</div>

</body>
</html>
