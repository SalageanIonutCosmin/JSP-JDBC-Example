<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: salag
  Date: 3/17/2020
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Company Update</title>
</head>
<body>
<h2>Company Update</h2>
<form method="post" action="http://localhost:8080/JSPExample_war_exploded//company/update">
    <table>
        <tr>
            <td>
                <input type="hidden" name="id" value="<c:out value='${companyToBeUpdate.getId()}' />" class="form-control">
            </td>
        </tr>
        <tr>
            <td>
                Company Name:
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="name" value="<c:out value='${companyToBeUpdate.getName()}' />" class="form-control">
            </td>
        </tr>
        <tr>
            <td>
                Company Domain:
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="domain" value="<c:out value='${companyToBeUpdate.getDomain()}' />" class="form-control">
            </td>
        </tr>
        <tr>
            <td>
                Created At:
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="createdAt" value="<c:out value='${companyToBeUpdate.getCreatedAt()}' />" class="form-control">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="submit" value="Update!">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
