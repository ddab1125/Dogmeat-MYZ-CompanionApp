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
            <td>Opis postaci</td>
            <td>Siła</td>
            <td>Zręczność</td>
            <td>Spryt</td>
            <td>Empatia</td>
        </tr>
            <tr>
                <td>${mCharDetails.name}</td>
                <td>${mCharDetails.profession}</td>
                <td>${mCharDetails.description}</td>
                <td>${mCharDetails.strengthValue}</td>
                <td>${mCharDetails.agilityValue}</td>
                <td>${mCharDetails.witsValue}</td>
                <td>${mCharDetails.empathyValue}</td>
            </tr>
    </table>
    <button><a href="/user/list">Powrót</a></button>
</div>
</body>
</html>
