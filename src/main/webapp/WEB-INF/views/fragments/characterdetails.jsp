<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="center">
    <h1 style="text-align: center">
        ${mChar.name} - ${mChar.profession}
    </h1>
    <h2 style="text-align: center">${mChar.description}</h2>

    <table class="center" id="skillTable">
        <tr>
            <td>Siła</td>
            <td>${mChar.strengthValue}</td>
        </tr>
        <tr>
            <td>Zręczność</td>
            <td>${mChar.agilityValue}</td>
        </tr>
        <tr>
            <td>Spryt</td>
            <td>${mChar.witsValue}</td>
        </tr>
        <tr>
            <td>Empatia</td>
            <td>${mChar.empathyValue}</td>
        </tr>
    </table>
</div>
