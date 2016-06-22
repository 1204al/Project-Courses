<ul class="nav nav-pills right text-success ">
    <li class="dropdown " >
        <a class="dropdown-toggle text-success" data-toggle="dropdown" href="#" aria-expanded="true">
            <fmt:message key="LOG_IN"/>
        </a>
        <div class="dropdown-menu dropdown-menu-left" style="width: 350px; padding: 6px; left: -250px">
            <%@include file="student_login_form.jsp" %>

        </div>
    </li>

    <li class="dropdown">
        <a class="dropdown-toggle text-success" data-toggle="dropdown" href="#" aria-expanded="true">
            <fmt:message key="SIGN_UP"/>
        </a>
        <div class="dropdown-menu" style="width: 550px; padding: 6px;left: -470px">
            <%@include file="student_registration_form.jsp" %>
        </div>
    </li>
</ul>