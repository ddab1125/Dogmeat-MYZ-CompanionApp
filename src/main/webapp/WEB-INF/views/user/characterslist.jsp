<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="app.title"/></title>

</head>
<body>
<jsp:include page="../fragments/navbar.jsp"/>

<jsp:include page="../fragments/dash.jsp"/>

<div style="margin-left:15%;padding:1px 16px;height:1000px;">

    <table border="1">
        <tr>
            <td>Imię</td>
            <td>Rola</td>
            <td colspan="2">Akcje</td>
        </tr>
        <c:forEach items="${mCharacters}" var="mCharList">
            <tr>
                <td>${mCharList.name}</td>
                <td><spring:message code="role.${mCharList.profession}"/></td>
                <td><a href="/user/character/details/${mCharList.id}">Szczegóły</a></td>
                <td><a href="/user/character/delete/${mCharList.id}/confirm">Usuń</a></td>
            </tr>
        </c:forEach>
    </table>
    <button><a href="/user/character/new">Nowa Postać</a></button>
</div>
</body>
</html>
