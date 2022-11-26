<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body>
<jsp:include page="fragments/navbar.jsp"/>

<jsp:include page="fragments/characterdetails.jsp"/>

<sec:authorize access="isAuthenticated()">
    <div>
        <form action="<c:url value="/char/random"/>" method="POST">
            <input class="center" type="submit" value="Dodaj do teczki">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</sec:authorize>
</body>
</html>
