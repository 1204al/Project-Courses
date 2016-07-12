<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../../../jquery.min.js" type="text/javascript"></script>

    <link href="../../../bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="../../../main.css" rel="stylesheet" type="text/css"/>
    <script src="../../../bootstrap.min.js" type="text/javascript"></script>


</head>
<body>
<%@include file="../header.jsp" %>


<%@include file="../sessionScope.jsp" %>

<div class="col-lg-6 col-md-8 col-sm-9 ">
    <%@include file="teacher_form_for_course.jsp" %>
</div>


<div  class="col-lg-7 col-md-9 col-sm-10">
    <div>
        <%@include file="teacher_forms_for_marks.jsp" %>

    </div>


</div>

</body>
</html>