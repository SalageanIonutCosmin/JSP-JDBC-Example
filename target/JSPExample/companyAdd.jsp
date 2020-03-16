<%--
  Created by IntelliJ IDEA.
  User: salag
  Date: 3/16/2020
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Company Add</title>
</head>
<body>
<h1>Add Company</h1>
<form action="/company/create" method="post">
    <table>
        <tr>
            <td>
                Company name
            </td>
            <td>
                <input type="text" name="name" placeholder="Company name">
            </td>
        </tr>
        <tr>
            <td>
                Company domain
            </td>
            <td>
                <input type="text" name="domain" placeholder="Company name">
            </td>
        </tr>
        <tr>
            <td>
                Date
            </td>
            <td>
                <input type="text" name="createdAt" placeholder="Date">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="submit" value="Add!">
            </td>
        </tr>
        <tr>
            <td>
                <a href="http://localhost:8080/JSPExample_war_exploded/company/list">Back</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
