<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Company List</title>
</head>
<body>
<table border="1px">
    <thead>
    <th>
        Company Id
    </th>
    <th>
        Company Name
    </th>
    <th>
        Company Domain
    </th>
    <th>
        Date
    </th>
    <th colspan="2
">
        Actions
    </th>
    </thead>
    <tbody>
    <c:forEach var="company" items="${companyList}">
        <tr>
            <td>${company.getId()}</td>
            <td>${company.name}</td>
            <td>${company.domain}</td>
            <td>${company.createdAt}</td>
            <td>
                <form method="get" action="/delete">
                    <input type="hidden" name="id" value="${company.getId()}">
                    <input type="submit" name="submit" value="Delete!">
                </form>
            </td>
            <td>
                <form method="get" action="/update">
                    <input type="hidden" name="id" value="${company.getId()}">
                    <input type="submit" name="submit" value="Update!">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form method="post" action="/company/create">
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
                <input type="text" name="name" placeholder="Date">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="submit" value="Add!">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
