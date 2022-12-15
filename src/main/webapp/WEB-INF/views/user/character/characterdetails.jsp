<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title><spring:message code="app.title"/></title>
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page="../../fragments/navbar.jsp"/>
<jsp:include page="../../fragments/dash.jsp"/>


<div style="margin-left:15%;padding:1px 5px;height:1000px;">
    <jsp:include page="../../fragments/characterdetails.jsp"/>
</div>

</body>
</html>
