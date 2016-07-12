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