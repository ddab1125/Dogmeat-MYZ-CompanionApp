<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body>
<jsp:include page="../../fragments/navbar.jsp"/>

<jsp:include page="../../fragments/dash.jsp"/>

<div style="margin-left:15%;padding:1px 5px;height:1000px;">
    <div class="container">
        <jsp:include page="../../fragments/campaigndetails.jsp"/>
        <table>
            <tr>
                <td><spring:message code="basic.name"/></td>
                <td><spring:message code="basic.prof"/></td>
                <td><spring:message code="user.player"/></td>
                <td colspan="2"></td>
            </tr>
            <c:forEach items="${campaignCharacterList}" var="mCharList">
                <tr>
                    <td>${mCharList.name}</td>
                    <td><spring:message code="role.${mCharList.profession}"/></td>
                    <td>${mCharList.user.username}</td>
                    <td><a href="/user/character/details/${mCharList.id}"><spring:message code="basic.details"/></a>
                    </td>
                    <sec:authorize access="hasAuthority('gameMaster')">
                        <td><a href="/user/campaign/character/delete/${campaign.id}/${mCharList.id}"><spring:message
                                code="basic.deletecharacterfromcampaign"/></a></td>
                    </sec:authorize>

                </tr>
            </c:forEach>
        </table>


    </div>


</div>
</body>
</html>
