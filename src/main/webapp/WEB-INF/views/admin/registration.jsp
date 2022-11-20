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

<form:form action="/user/register" method="POST" modelAttribute="userDto">
    <div>
        <label>Nazwa użytkownika:</label>
        <form:input path="username" type="text"/>
        <form:errors path="username"/> <br>

    </div>
    <div>
        <label>Email:</label>
        <form:input path="email" type="email"/>
        <form:errors path="email"/> <br>

    </div>
    <div>
        <label>Hasło:</label>
        <form:input path="password" type="password"/>
        <form:errors path="password"/>
        <form:errors path="password2"/>
        <br>

    </div>
    <div>
        <label>Powtórz hasło</label>
        <form:input path="password2" type="password"/>
        <form:errors path="password2"/>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Zarejestruj Się">
</form:form>

</body>
</html>
