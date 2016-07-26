package commands;

import controllers.ICommand;
import datasource.DAOFactory;
import properties.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CommandRegistrationStudentOnCourse implements ICommand {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String ID = "id";
    private static final String ROLE = "role";
    private static final String STUDENT = "student";

    private static final String ERROR = "error";
    private static final String COURSES_ID = "coursesId";

    private static final String ID_COURSE = "idCourse";

    private static final String PAGE = "page";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idStudent = (int) session.getAttribute(ID);
        int idCourse = Integer.parseInt(request.getParameter(ID_COURSE));
        DAOFactory.getDAOMark().create(idStudent,idCourse);
        List<Integer> studentCoursesId=DAOFactory.getDAOMark().findCoursesOfStudentByIdStudent(idStudent);
        session.setAttribute(COURSES_ID, studentCoursesId);

        session.setAttribute(PAGE,Config.STUDENT_PAGE);
        request.getRequestDispatcher(Config.getInstance().getProperty(Config.STUDENT_PAGE)).forward(request, response);
        return null;
    }
}
