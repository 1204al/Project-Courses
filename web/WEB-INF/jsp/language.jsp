
<fmt:setBundle var="messages" basename="properties.messages"/>
<c:choose>
    <c:when test="${sessionScope.language=='ua'}">
        <fmt:setLocale value="ua"/>
    </c:when>
    <c:otherwise>
        <fmt:setLocale value="en"/>
    </c:otherwise>
</c:choose>
