<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div>
    STEP 3
    <form action="/user/campaign/new/finish" method="post">
                <select multiple name="characters">
                    <c:forEach items="${mCharacters}" var="mChars">
                        <c:forEach items="${mChars}" var="mChar">
                            <option value="${mChar.id}">${mChar.name}</option>
                        </c:forEach>
                    </c:forEach>
                </select>

        <input type="hidden" name="campaignName" value="${campaignName}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <c:forEach items="${players}" var="player">
            <input type="hidden" name="players" value="${player}"/>
        </c:forEach>

        <input type="submit">
    </form>

</div>
