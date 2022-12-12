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
    <jsp:include page="../fragments/campaignlist.jsp"/>
</div>
</body>
</html>
