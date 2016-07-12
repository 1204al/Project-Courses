
<c:forEach var="item" items="${sessionScope.marks}" varStatus="myIndex">
    <div class="border">
        <form  action="controller" method="post">
            <input type="hidden" name="command" value="setMark"> <br>
            <input type="hidden" name="idMark" value="${item.idMark}"> <br>

            <label>Name:</label>
            <label>${item.student.nameStudent}</label><br>
            <label>Login:</label>
            <label>${item.student.loginStudent}</label><br>
            <label>Email:</label>
            <label>${item.student.emailStudent}</label><br>



            <input type="text" class="form-control"  name="mark"><br>
            <%--TODO   доделать отправку оценки, написать комманду получения и изменения оценки в БД и дао--%>

            <button type="submit" class="btn btn-primary">
                <fmt:message key="SUBMIT"/>
            </button>
        </form>
    </div>



</c:forEach>