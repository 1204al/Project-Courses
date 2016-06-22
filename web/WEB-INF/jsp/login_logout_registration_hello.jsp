<c:choose>
    <c:when test="${empty sessionScope.login and empty sessionScope.id}">
        <%@include file="teacher/teacher_registration_login_dropdown.jsp" %>
        <%@include file="student/student_registration_login_dropdown.jsp" %>
    </c:when>
    <c:otherwise>

        <c:choose>
            <c:when test="${sessionScope.role=='teacher'}">
                <%@include file="teacher/teacher_hello.jsp" %>
            </c:when>
            <c:when test="${sessionScope.role=='student'}">
                <%@include file="student/student_hello.jsp" %>

            </c:when>
        </c:choose>


    </c:otherwise>
</c:choose>


