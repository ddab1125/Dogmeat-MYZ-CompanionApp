<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="div1">
        <div>
            <form:form action="/user/character/sheet" method="POST" modelAttribute="mCharDetails">
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
        <div>
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
                <tr>
                    <td><c:choose>
                        <c:when test="${mCharDetails.profession == 'Osiłek'}"><spring:message
                                code="skill.intimidate"/></c:when>
                        <c:when test="${mCharDetails.profession == 'Monter'}"><spring:message
                                code="skill.jurryrig"/></c:when>
                        <c:when test="${mCharDetails.profession == 'Szperacz'}"><spring:message
                                code="skill.findthepath"/></c:when>
                        <c:when test="${mCharDetails.profession == 'Macher'}"><spring:message
                                code="skill.makeadeal"/></c:when>
                        <c:when test="${mCharDetails.profession == 'Psiarz'}"><spring:message
                                code="skill.sicadog"/></c:when>
                        <c:when test="${mCharDetails.profession == 'Kronikarz'}"><spring:message
                                code="skill.inspire"/></c:when>
                        <c:when test="${mCharDetails.profession == 'Szef'}"><spring:message
                                code="skill.command"/></c:when>
                        <c:when test="${mCharDetails.profession == 'Robol'}"><spring:message
                                code="skill.shakeitoff"/></c:when>
                    </c:choose>
                        <form:input path="professionSkillValue" type="number" min="0"
                                    max="5"/></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="div2">
        <div>
            <label> <spring:message code="basic.name"/>
                <form:input path="name" type="text" placeholder="${mCharDetails.name}" disabled="true"/>
            </label>
            <label> <spring:message code="basic.prof"/>
                <form:select path="profession" itemValue="${mCharDetails.profession}" disabled="true">
                    <c:forEach items="${rolesList}" var="role">
                        <form:option value="${mCharDetails.profession}"/>
                    </c:forEach>
                </form:select>
            </label>
            <div>
                <label><spring:message code="basic.desc"/> <br>
                    <form:textarea path="description" style="width: 420px" value="${mCharDetails.description}"/>
                </label>
            </div>
        </div>

    </div>
    <div class="div3">
        <div>
          <h4 style="margin-bottom: auto"><spring:message code="basic.talents"/></h4><br>
            <form:select path="talents" multiple="true">
                <c:forEach items="${talentList}" var="talent">
                    <form:option value="${talent.id}"><spring:message code="talent.${talent.talentName}"/></form:option>
                </c:forEach> <br>
            </form:select>
            <button type="submit" name="submitTalent"><spring:message code="basic.add"/></button>
            <ol>
                <c:forEach items="${mCharDetails.talents}" var="talent">
                    <li><spring:message code="talent.${talent.talentName}"/></li>
                </c:forEach>
            </ol>
        </div>

        <div>
           <h4 style="margin-bottom: auto"><spring:message code="basic.mutations"/></h4><br>
            <form:select path="mutations" multiple="true">
                <c:forEach items="${mutationList}" var="mutation">
                    <form:option value="${mutation.id}"><spring:message
                            code="mutation.${mutation.mutationName}"/></form:option>
                </c:forEach>
            </form:select>
            <button type="submit" name="submitMutation"><spring:message code="basic.add"/></button>
            <ol>
                <c:forEach items="${mCharDetails.mutations}" var="mutation">
                    <li><spring:message code="mutation.${mutation.mutationName}"/></li>
                </c:forEach>
            </ol>
        </div>
    </div>


    <form:hidden path="id"/>
    <button type="submit" name="submitMChar"><spring:message code="basic.save"/></button>
    </form:form>

    <div class="div2" style="margin-top: 20%">

        <table>
            <thead>
            <tr>
                <th><spring:message code="basic.eq"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${eqList}" var="item">
                <tr>
                    <td>${item.itemName}
                        <spring:message code="item.quantity"/>: <c:out value="${item.itemQuantity}"/>
                        <spring:message code="item.weight"/>: <c:out
                                value="${item.itemQuantity * item.itemWeight}"/>
                        <a href="/user/character/equipment/delete/${mCharDetails.id}/${item.id}"><spring:message
                                code="basic.delete"/></a></td>
                </tr>
            </c:forEach>
            <tr>
                <td><spring:message code="item.carrycap"/>:
                    <c:set var="totalWeight" value="${0}" />
                    <c:forEach var="item" items="${eqList}">
                        <c:set var="totalWeight" value="${totalWeight + (item.itemWeight * item.itemQuantity)}" />
            </c:forEach>
            ${totalWeight} / <c:out value="${mCharDetails.strengthValue * 2}"/> </td>
            </tr>
            </tbody>

        </table>
        <br>
        <br>
        <form:form action="/user/character/equipment" method="POST" modelAttribute="eq">
            <form:input path="itemName" type="text"/>
            <spring:message code="item.quantity"/>
            <form:input path="itemQuantity" type="number" min="1"/>
            <spring:message code="item.weight"/>
            <form:input path="itemWeight" type="number" min="0.5" step="0.5"/>


            <input type="hidden" name="mCharId" value="${mCharDetails.id}"/>
            <button type="submit" name="submitEq"><spring:message code="basic.add"/></button>
        </form:form>
    </div>

</div>

<button><a href="/user/list">Powrót</a></button>