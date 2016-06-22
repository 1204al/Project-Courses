
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="en_US"/>
<html>
<head>
    <title>Title</title>
    <script src="../../jquery.min.js" type="text/javascript"></script>
    <link href="../../bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="../main.css" rel="stylesheet" type="text/css"/>
    <script src="../../bootstrap.min.js" type="text/javascript"></script>

</head>
<body>


<%@include file="sessionScope.jsp" %>



<h2 class="alert alert-dismissible alert-danger">${sessionScope.error}</h2>

<button  class="btn btn-primary col-lg-offset-3 " onClick="history.back()"><fmt:message key="Back" /></button>
</body>
</html>
