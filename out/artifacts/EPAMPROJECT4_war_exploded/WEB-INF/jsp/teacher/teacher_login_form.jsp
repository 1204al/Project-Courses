<form  action="controller" method="post">

    <input type="hidden" name="command" value="loginTeacher"> <br>
    <input type="text" class="form-control"  placeholder="<fmt:message key="LOGIN"/>" name="login"><br>
    <input type="password" class="form-control" placeholder="<fmt:message key="PASSWORD"/>" name="password"> <br>
    <button type="submit" class="btn btn-primary">
        <fmt:message key="LOG_IN"/>
    </button>
</form>