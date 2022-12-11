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
    <table>
        <tr>
            <td>Nazwa Kampanii</td>
            <td>Mistrz Gry</td>
            <td>Szczegóły</td>
        </tr>
        <c:forEach items="${campaignList}" var="campaign">
            <tr>
                <td>${campaign.campaignName}</td>
                <td>${campaign.gameMaster.username}</td>
                <td><a href="#">Szczegóły</a></td>
            </tr>
        </c:forEach>
    </table>
        <button><a href="/user/campaign/new">Nowa Kampania</a></button>

</div>
</body>
</html>
