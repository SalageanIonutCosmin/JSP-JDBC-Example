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
    <th>Date</th>
    </thead>
    <tbody>
    <c:forEach items="${companyList}" var="c">
        <tr>
            <td>${c.getId()}</td>
            <td>${c.getName()}</td>
            <td>${c.getDomain()}</td>
            <td>${c.getCreatedAt()}</td>
            <td>
                <form method="get" action="/company/delete">
                    <input type="hidden" name="id" value="${c.getId()}">
                    <input type="submit" name="submit" value="Delete!">
                </form>
            </td>
            <td>
                <form method="get" action="/company/update">
                    <input type="hidden" name="id" value="${c.getId()}">
                    <input type="submit" name="submit" value="Update!">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form method="post" action="/create">
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
