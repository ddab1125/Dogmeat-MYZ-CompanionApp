<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body>
<div style="background-color: black">
    <jsp:include page="fragments/navbar.jsp"/>
    <p style="text-align:center;">
        <a href="/"> <img src="/images/splash.jpg" style="object-fit: contain"> </a>
    </p>

</div>
</body>
</html>
