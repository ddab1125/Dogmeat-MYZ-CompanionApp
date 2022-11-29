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
    <form:form action="/user/character/new" method="POST" modelAttribute="mChar">
        <div class="mchar-attributes">
            <table>
                <thead>
                <tr>
                    <th colspan="2"><spring:message code="stat.at"/></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><spring:message code="stat.strength"/> <form:input path="strengthValue" type="number" min="0"
                                                                           max="5"/></td>
                    <td><spring:message code="stat.damage"/>
                        <div>
                            <form:input path="damageValue" type="range" min="0" max="5"/>
                            <jsp:include page="tickmarks.jsp"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td><spring:message code="stat.agility"/> <form:input path="agilityValue" type="number" min="0"
                                                                          max="5"/></td>
                    <td><spring:message code="stat.fatigue"/>
                        <div>
                            <form:input path="fatigueValue" type="range" min="0" max="5"/>
                            <jsp:include page="tickmarks.jsp"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td><spring:message code="stat.wits"/> <form:input path="witsValue" type="number" min="0"
                                                                       max="5"/></td>
                    <td><spring:message code="stat.confusion"/>
                        <div>
                            <form:input path="confusionValue" type="range" min="0" max="5"/>
                            <jsp:include page="tickmarks.jsp"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td><spring:message code="stat.empathy"/> <form:input path="empathyValue" type="number" min="0"
                                                                          max="5"/></td>
                    <td><spring:message code="stat.doubt"/>
                        <div>
                            <form:input path="doubtValue" type="range" min="0" max="5"/>
                            <jsp:include page="tickmarks.jsp"/>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="mchar-basic">
            <label> <spring:message code="basic.name"/>
                <form:input path="name" type="text"/>
            </label>
            <label> <spring:message code="basic.prof"/>
                <form:select path="profession">
                    <c:forEach items="${rolesList}" var="role">
                        <form:option value="${role.roleName}">${role.roleName}</form:option>
                    </c:forEach>
                </form:select>
            </label>
        </div>
        <div>
            <label><spring:message code="basic.desc"/> <br>
                <form:textarea path="description" style="width: 420px"/>
            </label>
        </div>

        <div class="mchar-skills">
            <table>
                <thead>
                <tr>
                    <th><spring:message code="skill.skill"/></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><spring:message code="skill.endure"/> <form:input path="endureValue" type="number" min="0"
                                                                          max="5"/></td>
                </tr>
                <tr>
                    <td><spring:message code="skill.force"/> <form:input path="forceValue" type="number" min="0"
                                                                         max="5"/></td>
                </tr>
                <tr>
                    <td><spring:message code="skill.fight"/> <form:input path="fightValue" type="number" min="0"
                                                                         max="5"/></td>
                </tr>
                <tr>
                    <td><spring:message code="skill.sneak"/> <form:input path="sneakValue" type="number" min="0"
                                                                         max="5"/></td>
                </tr>
                <tr>
                    <td><spring:message code="skill.move"/> <form:input path="moveValue" type="number" min="0"
                                                                        max="5"/></td>
                </tr>
                <tr>
                    <td><spring:message code="skill.shoot"/> <form:input path="shootValue" type="number" min="0"
                                                                         max="5"/></td>
                </tr>
                <tr>
                    <td><spring:message code="skill.scout"/> <form:input path="scoutValue" type="number" min="0"
                                                                         max="5"/></td>
                </tr>
                <tr>
                    <td><spring:message code="skill.comprehend"/> <form:input path="comprehendValue" type="number"
                                                                              min="0" max="5"/></td>
                </tr>
                <tr>
                    <td><spring:message code="skill.knowthezone"/> <form:input path="knowTheZoneValue" type="number"
                                                                               min="0" max="5"/></td>
                </tr>
                <tr>
                    <td><spring:message code="skill.senseemotion"/> <form:input path="senseEmotionValue" type="number"
                                                                                min="0" max="5"/></td>
                </tr>
                <tr>
                    <td><spring:message code="skill.manipulate"/> <form:input path="manipulateValue" type="number"
                                                                              min="0" max="5"/></td>
                </tr>
                <tr>
                    <td><spring:message code="skill.heal"/> <form:input path="healValue" type="number" min="0"
                                                                        max="5"/></td>
                </tr>
                </tbody>
            </table>
        </div>


        <input type="submit">
    </form:form>
</div>


</body>
</html>
