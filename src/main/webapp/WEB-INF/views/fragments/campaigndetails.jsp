<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body>

<div>
        <spring:message code="basic.campaignName"/>
    <h3>
        ${campaign.campaignName}
    </h3>
</div>


</body>
</html>
