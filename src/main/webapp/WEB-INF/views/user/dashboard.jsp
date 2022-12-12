<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body>
<jsp:include page="../fragments/navbar.jsp"/>

<jsp:include page="../fragments/dash.jsp"/>

<div style="margin-left:15%;padding:1px 5px;height:1000px;">

    <sec:authorize access="isAuthenticated()">
        <p>Witaj <sec:authentication property="principal.username"/>!</p>
    </sec:authorize>
    <div>

        <jsp:include page="../fragments/manageuser.jsp"/>
        <form action="<c:url value="/logout"/>" method="POST">
            <input class="center" type="submit" value="Wyloguj">
            <input class="center" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>

</div>
</body>
</html>
