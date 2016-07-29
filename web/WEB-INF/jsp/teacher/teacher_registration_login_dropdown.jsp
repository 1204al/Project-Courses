<ul class="nav nav-pills left" >
    <li class="dropdown" >
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="true">
            <fmt:message key="LOG_IN"/>
        </a>
        <div class="dropdown-menu right" style="width: 350px; padding: 6px">
            <%@include file="teacher_login_form.jsp" %>

        </div>
    </li>

    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="true">
            <fmt:message key="SIGN_UP"/>
        </a>
        <div class="dropdown-menu" style="width: 550px; padding: 6px">
            <%@include file="teacher_registration_form.jsp" %>
        </div>
    </li>
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="true">
            <fmt:message key="TEACHER"/>
        </a>

    </li>
</ul>