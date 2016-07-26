<c:set var="colors" scope="session"
       value="${['panel-primary','panel-success','panel-warning','panel-danger','panel-info']}"/>
<c:forEach var="item" items="${requestScope.list}" varStatus="myIndex">
    <div class="col-xs-6 col-md-4">

        <div class="panel ${sessionScope.colors[myIndex.index%fn:length(colors)]}">
            <div class="panel-heading">
                <h3 class="panel-title">${item.nameCourse}</h3>
            </div>
            <div class="panel-body">
                    ${item.information}
            </div>

            <c:if test="${sessionScope.role=='student'}">


                <%--   ${fn:contains([18,19], 8)}  вернет true, так как работает с текстом,  поэтому пишем такую штуку--%>
                <c:set var="containsCoursesId" value="false"/>
                <c:forEach var="itemCoursesId" items="${requestScope.coursesId}">
                    <c:if test="${itemCoursesId==item.idCourse}">
                        <c:set var="containsCoursesId" value="true"/>
                    </c:if>
                </c:forEach>


                <c:choose>
                    <c:when test="${containsCoursesId}">
                        <form action="controller" method="post">
                            <input type="hidden" name="command" value="leavingTheCourse"/>
                            <input type="hidden" name="idCourse" value="${item.idCourse}"/>

                            <button type="submit" class="btn btn-danger center-btn">
                                Leave the course
                            </button>

                        </form>

                    </c:when>
                    <c:otherwise>
                        <form action="controller" method="post">
                            <input type="hidden" name="command" value="registrationStudentOnCourse"/>
                            <input type="hidden" name="idCourse" value="${item.idCourse}"/>

                            <button type="submit" class="btn btn-registration center-btn">
                                REGISTER
                            </button>

                        </form>

                    </c:otherwise>
                </c:choose>





            </c:if>

        </div>
    </div>

</c:forEach>
