
<c:forEach var="item" items="${sessionScope.marks}" varStatus="myIndex">
    <div class="border">



         <%--   <label>${item.student.nameStudent}</label><br>
            <label>Login:</label>
            <label>${item.student.loginStudent}</label><br>
            <label>Email:</label>--%>
            <label>${item.student.emailStudent}</label><br>


    </div>



</c:forEach>