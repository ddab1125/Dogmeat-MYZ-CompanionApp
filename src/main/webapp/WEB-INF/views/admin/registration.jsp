<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Rejestracja <spring:message code="app.title"/></title>
</head>
<body>
<form:form action="/user/register" method="POST" modelAttribute="user">
    <div>
        <label>Nazwa użytkownika:</label>
        <form:input path="username" type="text"/>
        <form:errors path="username" > <br>
            <span>Nazwa użytkownika nie może być pusta</span>
        </form:errors>
    </div>
    <div>
        <label>Email:</label>
        <form:input path="email" type="email"/>
        <form:errors path="email" > <br>
            <span>Email nie może być pusty</span>
        </form:errors>
    </div>
    <div>
        <label>Hasło:</label>
        <form:input path="password" type="password"/>
        <form:errors path="password"> <br>
            <span>Hasło nie może być puste</span>
        </form:errors>
    </div>
    <div>
        <label>Powtórz hasło</label>
        <form:input path="password2" type="password"/>
        <form:errors path="password2" > <br>
            <span>Błąd</span>
        </form:errors>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Zarejestruj Się">
</form:form>
</body>
</html>
