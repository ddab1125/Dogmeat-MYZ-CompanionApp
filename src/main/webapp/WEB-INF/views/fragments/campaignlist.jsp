<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
    <div class="div1">
        <table>
            <thead>
            <h4 style="text-align: left"><spring:message code="user.curremtcampaigns"/></h4>
            </thead>
            <tr>
                <td>Nazwa Kampanii</td>
                <td>Mistrz Gry</td>
                <td>Szczegóły</td>
            </tr>
            <c:forEach items="${campaignList}" var="campaign">
                <tr>
                    <td>${campaign.campaignName}</td>
                    <td>${campaign.gameMaster.username}</td>
                    <td>
                        <form method="post" action="/user/campaign/details">
                            <input type="hidden" value="${campaign.id}" name="campaignId">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input type="submit">
                        </form>
                </tr>
            </c:forEach>
        </table>

    </div>
<sec:authorize access="hasAuthority('gameMaster')">
    <div class="div2">
        <table>
            <thead>
            <h4 style="text-align: left"><spring:message code="user.gmcurrentcampaigns"/></h4>
            </thead>
            <tr>
                <td><spring:message code="basic.campaignName"/></td>
                <td><spring:message code="basic.details"/></td>
            </tr>
            <c:forEach items="${gmCampaignList}" var="gmcampaign">
                <tr>
                    <td>${gmcampaign.campaignName}</td>
                    <td>
                        <form method="post" action="/user/campaign/details">
                            <input type="hidden" value="${gmcampaign.id}" name="campaignId">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button type="submit"><spring:message code="basic.details"/></button>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="/user/campaign/delete">
                            <input type="hidden" value="${gmcampaign.id}" name="campaignId">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button type="submit"><spring:message code="basic.delete"/></button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>


</div>
    <button><a href="/user/campaign/new">Nowa Kampania</a></button>
</sec:authorize>