<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<%@include file="header.jsp"%>
<img src="/image/users/wp2587551.jpg" alt="User image">
<form action="/registration" method="post" enctype="multipart/form-data">
    <label for="userName"><fmt:message key="page.registration.name"/>:
        <input type="text" name="name" id="userName" required>
    </label>
    <br>
    <label for="surname"><fmt:message key="page.registration.surname"/>:
        <input type="text" name="surname" id="surname" required>
    </label>
    <br>
    <label for="phone"><fmt:message key="page.registration.phone"/>:
        <input type="text" name="phone" id="phone">
    </label>
    <br>
    <label for="email"><fmt:message key="page.registration.email"/>:
        <input type="text" name="email" id="email" required>
    </label>
    <br>
    <label for="birthday"><fmt:message key="page.registration.birthday"/>:
        <input type="date" name="birthday" id="birthday">
    </label>
    <br>
    <label for="password"><fmt:message key="page.registration.password"/>:
        <input type="password" name="password" id="password" required>
    </label>
    <br>
    <label>
        <c:forEach var="gender" items="${requestScope.gender}">
            <input type="radio" name="gender" value="${gender}">${gender}
        </c:forEach>
    </label>
    <br>
    <label for="image"><fmt:message key="page.registration.image"/>:
        <input type="file" name="image" id="image">
    </label>
    <br>
    <button type="submit"><fmt:message key="page.registration.submit.button"/></button>
    <c:if test="${not empty requestScope.errors}">
        <div style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span><br>
            </c:forEach>
        </div>
    </c:if>
</form>
</body>
</html>
