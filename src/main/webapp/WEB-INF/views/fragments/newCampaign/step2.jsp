<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div>
    STEP 2
    <form action="/user/campaign/new/step3" method="post">
        <select multiple name="players">
            <c:forEach items="${playersList}" var="player">
                <option value="${player.id}">${player.username}</option>
            </c:forEach>
        </select>
        <input type="hidden" name="campaignName" value="${campaignName}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit">
    </form>

</div>
