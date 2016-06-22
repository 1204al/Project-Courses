<form action="/controller" method="post" class="inlineBlock text-success right " >
    <input type="hidden" name="command" value="logout" />
    <button type="submit" class="btn btn-primary inlineBlock">
        <fmt:message key="LOG_OUT"/>
    </button>
</form>
<form action="/controller" method="post" class="inlineBlock text-success right">
    <p class="inlineBlock">
        <fmt:message key="HELLO"/>
        <fmt:message key="STUDENT"/>
    </p>
    <input  type="hidden" name="command" value="goToStudentPage" class="inlineBlock"/>
    <button class="btn btn-link inlineBlock" type="submit">
        <span>${sessionScope.login}</span>
    </button>
</form>
