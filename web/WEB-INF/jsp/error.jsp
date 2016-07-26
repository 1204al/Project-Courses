
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="err" uri="/WEB-INF/TLDs/errorTag.tld"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="language.jsp" %>



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


<err:error        errorType="${sessionScope.error}"        locale="${sessionScope.language}"/>



<button  class="btn btn-primary col-lg-offset-3 " onClick="history.back()"><fmt:message key="BACK" /></button>
</body>
</html>
