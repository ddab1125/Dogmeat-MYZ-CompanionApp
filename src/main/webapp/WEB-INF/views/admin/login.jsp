<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title><spring:message code="app.title"/> Admin</title>
    <jsp:include page="../fragments/navbar.jsp"/>
</head>
<body>
<div class="center" style="margin-top: 1%">
<sec:authorize access="isAnonymous()">
    <div>
        <form method="post">
            <div class="center"><label style="text-align: center"> User Name : <input type="text" name="username"/>
            </label></div>
            <div class="center"><label style="text-align: center"> Password: <input type="password" name="password"/>
            </label></div>
            <div class="center"><input type="submit" value="Zaloguj"/></div>
            <input class="center" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</sec:authorize>

<sec:authorize access="isAnonymous()">
    Nie masz konta? Zarejestruj się!
    <form action="<c:url value="/register"/>" method="get">
        <input  type="submit" value="Rejestracja">
    </form>

</sec:authorize>


<sec:authorize access="isAuthenticated()">
    <div>
        <form action="<c:url value="/logout"/>" method="POST">
            <input class="center" type="submit" value="Wyloguj">
            <input class="center" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</sec:authorize>
</div>
</body>
</html>
