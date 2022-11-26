<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body>
<button><a href="/user/character/details/delete/${mCharId}">Usuń</a></button>
<button><a href="/user/list">Powrót</a></button>
</body>
</html>
