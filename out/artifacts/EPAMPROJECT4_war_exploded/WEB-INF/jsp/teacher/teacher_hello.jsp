<form action="/controller" method="post" class="inlineBlock left">
    <input type="hidden" name="command" value="logout" />
    <button type="submit" class="btn btn-primary inlineBlock">
        <fmt:message key="LOG_OUT"/>
    </button>
</form>
<form action="/controller" method="post" class="inlineBlock left">
    <p class="inlineBlock">
        <fmt:message key="HELLO"/>
        <fmt:message key="TEACHER"/>
    </p>
    <input  type="hidden" name="command" value="goToTeacherPage" class="inlineBlock"/>
    <button class="btn btn-link inlineBlock" type="submit">
        <span>${sessionScope.login}</span>
    </button>
</form>
