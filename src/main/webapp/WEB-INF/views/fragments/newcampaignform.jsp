<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form modelAttribute="campaign">
    <form:input path="campaignName" type="text"/>
    <form:select path="players" multiple="true">
        <c:forEach items="${playersList}" var="player">
                <form:option value="${player.id}">${player.username}</form:option>
        </c:forEach>
    </form:select>
    <button type="submit">Submit</button>
</form:form>