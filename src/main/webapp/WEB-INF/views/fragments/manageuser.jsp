<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div>
    <form action="/user/role" method="post">
        <select multiple name="roles" required>
            <option value="player" ><spring:message code="user.player"/></option>
            <option value="gameMaster" ><spring:message code="user.gamemaster"/></option>
        </select>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit"><spring:message code="basic.save"/></button>
    </form>
</div>