<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="app.title"/> Admin</title>
</head>
<body>
<jsp:include page="../fragments/navbar.jsp"/>

<div class="center">

    <form method="post">
        <div><label style="text-align: center"> User Name : <input type="text" name="username"/> </label></div>
        <div><label style="text-align: center"> Password: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Sign In"/></div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

</div>
</body>
</html>
