<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
    <form class="alert form-horizontal" action="/controller" method="post">
        <input type="hidden" name="command" value="changeCourse" />



        <div class="form-group" accept-charset="utf-8">
            <label  class="col-lg-3 control-label">Name of Course</label>
            <div class="col-lg-9">
                <input class="form-control" placeholder="Name of Course"type="text" name="name" value="${sessionScope.teacherCourse.nameCourse}">
            </div>
        </div>

        <div class="form-group">
            <label  class="col-lg-3 control-label">Information</label>
            <div class="col-lg-9">
            <textarea  class="form-control" rows="3" name="information">${sessionScope.teacherCourse.information}
            </textarea>
                <span class="help-block">There you can write information about your course</span>
            </div>
        </div>






        <button class="btn btn-primary col-lg-offset-3 " type="submit"  >
            <fmt:message key="UPDATE"/>
        </button>
    </form>


</div>






</body>
</html>