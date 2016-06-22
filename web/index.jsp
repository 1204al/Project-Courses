
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var = "language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"/>
<html>
  <head>
    <title>$Title$</title>
      <link rel="stylesheet" href="main.css">
    <script src=""></script>


  </head>
  <body>
  <h1>index.jsp</h1>
  <p>Text in tag p </p>
  Ваша сессия <br>
  ${sessionScope}<br><br>
  </body>
</html>



  <%--ЭТУ СТРАНИЦУ НЕ ТРОГАТЬ.ОНА ДЛЯ КРАСОТЫ--%>
   <%--ОСНАВНАЯ ЭТО courses.jsp--%>










