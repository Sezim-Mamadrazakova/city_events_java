<%--
  Created by IntelliJ IDEA.
  User: Сезим
  Date: 06.04.2023
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="org.example.Entity.Event "%>
<%@ page import="java.util.List" %>
<%@ page import="org.example.Service.EventService" %>
<%@ page import="org.example.Repository.EventRepository" %>
<%@ page import="org.example.DaoImplContainer.EventDaoImpl" %>

<html>
<head>
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #F5F5F5;
        }
        table, th, td {
            border: 1px solid black;

        }
        table.center {
            margin-left: auto;
            margin-right: auto;
        }

    </style>

</head>
<body>
<header>
    <ul>
        <li><a href="/java_lab1_war_exploded/welcome?action=list"></a></li>
    </ul>
</header>

<table class="center">
    <thead>
    <tr>
        <th style="width: 50px; text-align: center">ID</th>
        <th style="width: 50px; text-align: center">Name</th>
        <th style="width: 200px; text-align: center">Place</th>
        <th style="width: 600px; text-align: center">Date</th>
        <th style="width: 100px; text-align: center">Duration</th>
        <th style="width: 50px; text-align: center" colspan=2>Action</th>


    </tr>
    </thead>
    <tbody>

            <c:forEach items="${eventList}" var="event" >
                    <tr>
                        <td style="text-align: center"><c:out value="${event.getIdEvent()}"/></td>
                        <td style="text-align: center"><c:out value="${event.getEventName()}"/></td>
                        <td style="text-align: center"><c:out value="${event.getEventPlace()}"/></td>
                        <td style="text-align: center"><c:out value="${event.getDateStart()}"/></td>
                        <td style="text-align: center"><c:out value="${event.getDuration()}"/></td>
                        <td style="text-align: center"><a
                                href="/java_lab1_war_exploded/welcome?action=edit&idEvent=<c:out value="${event.getIdEvent()}"/>">Update</a> </td>
                        <td style="text-align: center"><a
                                href="/java_lab1_war_exploded/welcome?action=delete&idEvent=<c:out value="${event.getIdEvent()}"/>">Delete</a> </td>
                    </tr>
            </c:forEach>
    </tbody>

</table>

<p><a  href="<%=request.getContextPath()%>/new">Add Event</a> </p>
<p><a href="<%=request.getContextPath()%>/search">Search</a></p>




</body>
</html>
