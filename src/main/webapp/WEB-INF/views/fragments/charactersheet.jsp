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

<div>
    <form:form action="/user/character/sheet" method="POST" modelAttribute="mChar">
        <div class="mchar-basic">
            <label> <spring:message code="basic.name"/>
                <form:input path="name" type="text"/>
            </label>
            <label> <spring:message code="basic.prof"/>
                <form:select path="profession">
                    <c:forEach items="${rolesList}" var="role">
                        <form:option value="${role}"><spring:message code="role.${role}"/></form:option>
                    </c:forEach>
                </form:select>
            </label>
        </div>

        <div>
            <label><spring:message code="basic.desc"/> <br>
                <form:textarea path="description" style="width: 420px"/>
            </label>
        </div>

        <button type="submit"><spring:message code="basic.continue"/></button>
    </form:form>
</div>


</body>
</html>
