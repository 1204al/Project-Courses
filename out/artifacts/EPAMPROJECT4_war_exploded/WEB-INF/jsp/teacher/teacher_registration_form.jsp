<form action="controller" method="post">

    <input type="hidden" name="command" value="registrationTeacher"><br>
    <label class="col-lg-2 control-label"><fmt:message key="LOGIN"/> </label>
    <div class="col-lg-10">
        <input type="text"class="form-control" placeholder="<fmt:message key="LOGIN"/> " name="login">
    </div>
    <br>
    <label class="col-lg-2 control-label"><fmt:message key="PASSWORD"/></label>
    <div class="col-lg-10">
        <input type="password"class="form-control" placeholder="<fmt:message key="PASSWORD"/> " name="password">
    </div>
    <br>

    <label class="col-lg-2 control-label"><fmt:message key="NAME"/> </label>

    <div class="col-lg-10">
        <input type="text"class="form-control" placeholder="<fmt:message key="NAME"/> " name="name" value="Andrey">
    </div>
    <br>
    <label class="col-lg-2 control-label"><fmt:message key="EMAIL"/> </label>
    <div class="col-lg-10">
        <input type="email"class="form-control" placeholder="<fmt:message key="EMAIL"/> " name="email">
    </div>
    <br>


    <button type="col-lg-offset-2 submit" class="btn btn-primary">
        <fmt:message key="SIGN_UP"/>
    </button>

</form>