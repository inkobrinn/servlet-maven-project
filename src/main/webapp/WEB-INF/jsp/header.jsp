<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <fmt:setLocale value="${sessionScope.language != null ? sessionScope.language:'en_US'}"/>
    <fmt:setBundle basename="translations"/>

    <c:if test="${not empty sessionScope.user}">
        <div id="logout">
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <button type="submit"><fmt:message key="page.logout.submit.button"/></button>
            </form>
        </div>
    </c:if>
    <div id="locale">
        <form action="/locale" method="post">
            <button type="submit" name="lang" value="ru_RU">RU</button>
            <button type="submit" name="lang" value="en_US">EN</button>
        </form>
    </div>

</div>