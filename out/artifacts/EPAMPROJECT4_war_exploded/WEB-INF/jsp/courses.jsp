<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="en_US"/>
<%--<fmt:setLocale value="ru"/>--%>


<html>
<head>
    <title>Title</title>
    <script src="../../jquery.min.js" type="text/javascript"></script>

    <link href="../../bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="../main.css" rel="stylesheet" type="text/css"/>
    <script src="../../bootstrap.min.js" type="text/javascript"></script>


</head>
<body>
<mytags:lecturerTable/>
<%@include file="header.jsp" %>


<%@include file="sessionScope.jsp" %>
<%--
<form action="controller" method="post">
    <input type="hidden" name="command" value="registrationStudentOnCourse"/>
    <input type="text" name="idCourse" value=""/>

    <button type="submit" class="btn btn-primary">
        TEST
    </button>
</form>
--%>
<%@include file="course_board.jsp" %>

</body>
</html>
