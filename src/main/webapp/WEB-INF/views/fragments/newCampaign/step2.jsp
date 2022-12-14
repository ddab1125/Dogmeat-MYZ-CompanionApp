<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="container">

    <div class="div1">
        <form action="/user/campaign/new/adduser" method="post">
            <select multiple name="players" required>
                <c:forEach items="${playersList}" var="player">
                    <option value="${player.id}">${player.username}</option>
                </c:forEach>
            </select>
            <input type="hidden" name="campaignName" value="${campaignName}">
            <input type="hidden" name="campaignDescription" value="${campaignDescription}">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <c:forEach items="${players}" var="player">
                <input type="hidden" name="currentPlayers" value="${player}"/>
            </c:forEach>
            <button type="submit"><spring:message code="basic.add"/></button>
        </form>

        <form action="/user/campaign/new/finduser" method="post">
            <input type="text" name="username">
            <input type="hidden" name="campaignName" value="${campaignName}">
            <input type="hidden" name="campaignDescription" value="${campaignDescription}">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit"><spring:message code="basic.searchforuser"/></button>
        </form>

        <form action="/user/campaign/new/step3" method="post">
            <input type="hidden" name="campaignName" value="${campaignName}">
            <input type="hidden" name="campaignDescription" value="${campaignDescription}">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <c:forEach items="${players}" var="player">
                <input type="hidden" name="players" value="${player}"/>
            </c:forEach>
            <c:if test="${not empty players}">
                <button type="submit"><spring:message code="basic.nextstep"/></button>
            </c:if>

        </form>
    </div>

    <div class="div2">
        <table>
            <thead>
            <spring:message code="user.players"/>
            </thead>
            <c:forEach items="${currentPlayers}" var="player">
                <tr>
                    <td>${player.username}</td>
                </tr>
            </c:forEach>
        </table>


    </div>
</div>
