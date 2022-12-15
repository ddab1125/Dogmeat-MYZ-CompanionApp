<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body style="background-color: black">

<a href="/">
<p style="text-align:center;"><img src="/images/error.jpg">
<div style="position: absolute; top: 40%; left: 50%; transform: translate(-50%, -50%)">
    <h1 style="color: black; font-size: 160px">405</h1>
</div>
<div style="position: absolute; top: 60%; left: 50%; transform: translate(-50%, -50%)">
    <h2 style="color: white; font-size: 50px; text-align: center"><spring:message code="app.somethingwentwrong"/></h2>
</div>
</p>
</a>



</body>
</html>
