<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/registration" method="post">
    <label for="userName">Name:
        <input type="text" name="name" id="userName">
    </label>
    <br>
    <label for="surname">Surname:
        <input type="text" name="surname" id="surname">
    </label>
    <br>
    <label for="phone">Phone:
        <input type="text" name="phone" id="phone">
    </label>
    <br>
    <label for="email">Email:
        <input type="text" name="email" id="email">
    </label>
    <br>
    <label for="birthday">Birthday:
        <input type="date" name="birthday" id="birthday">
    </label>
    <br>
    <label for="password">Password:
        <input type="password" name="password" id="password">
    </label>
    <br>
    <label>
        <c:forEach var="gender" items="${requestScope.gender}">
            <input type="radio" name="gender" value="${gender}">${gender}
        </c:forEach>
    </label>
    <br>
    <button type="submit">Send</button>
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
