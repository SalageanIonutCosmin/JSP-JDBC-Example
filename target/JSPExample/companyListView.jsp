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
    <th colspan="2">
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
                <a href="http://localhost:8080/JSPExample_war_exploded/company/update?id=<c:out value='${company.getId()}' />">Edit</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">
            <a href="http://localhost:8080/JSPExample_war_exploded">Home</a>
        </td>
        <td colspan="3">
            <a href="http://localhost:8080/JSPExample_war_exploded/company/create">Add Company</a>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>
