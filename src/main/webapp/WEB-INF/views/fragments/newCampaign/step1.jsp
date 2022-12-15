<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div>
    <form action="/user/campaign/new/step2" method="post" id="form">
        <table>

            <tr>
                <td>
                    <spring:message code="basic.campaignName"/>
                    <input type="text" name="campaignName" required>
                </td>
            </tr>

            <tr>
                <td>
                    <spring:message code="basic.campaigndescription"/>
                    <input type="text" name="campaignDescription">
                </td>
            </tr>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        </table>
        <button type="submit"><spring:message code="basic.nextstep"/></button>
    </form>
</div>

