<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Categories</h2>
<ul>
    <c:forEach var="category" items="${requestScope.categories}">
        <li><a href="/product?categoryId=${category.id}">${category.name}</a> </li>
    </c:forEach>

</ul>

</body>
</html>
