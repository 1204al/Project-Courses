<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fm:message key="REGISTED_STUDENTS"/>
<c:forEach var="item" items="${sessionScope.marks}" varStatus="myIndex">

    <div class="border">



            <label>${item.student.emailStudent}</label><br>


    </div>



</c:forEach>