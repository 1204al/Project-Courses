<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="bootstrap.css">
    <link rel="stylesheet" href="WEB-INF/main.css">
    <script src="bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<h1>THIS IS TEST PAGE</h1>
<ul class="nav nav-pills">
    <li class="dropdown ">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="true">
            Dropdown
        </a>
        <div class="dropdown-menu">
            <form class="border" action="controller" method="post">
                TEACHER_LOGIN_FORM
                <input type="hidden" name="command" value="loginTeacher"> <br>
                <input type="text" class="form-control"  placeholder="<fmt:message key="LOGIN"/>" name="login"><br>
                <input type="password" class="form-control" placeholder="<fmt:message key="PASSWORD"/>" name="password"> <br>
                <button type="submit" class="btn btn-primary">
                    <fmt:message key="LOG_IN"/>
                </button>
            </form>
        </div>
    </li>
</ul>
</body>
</html>
