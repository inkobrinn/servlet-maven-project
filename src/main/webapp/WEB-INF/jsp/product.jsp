<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<h2>Products</h2>
<ul>
    <c:forEach var="product" items="${requestScope.products}">
        <li>${product.brand}:${product.name}</li>
    </c:forEach>
</ul>

</body>
</html>
