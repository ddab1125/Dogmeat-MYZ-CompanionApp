<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
            <td>
                <form method="post" action="/user/campaign/details">
                    <input type="hidden" value="${campaign.id}" name="campaignId">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit">
                </form>
                <form method="post" action="/user/campaign/delete">
                    <input type="hidden" value="${campaign.id}" name="campaignId">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<button><a href="/user/campaign/new">Nowa Kampania</a></button>
