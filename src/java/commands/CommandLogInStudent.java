package commands;

import com.sun.xml.internal.bind.v2.TODO;
import controllers.ICommand;
import datasource.DAOFactory;
import entities.Course;
import entities.Student;
import entities.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.Config;
import properties.Message;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandLogInStudent implements ICommand {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String ID = "id";
    private static final String ROLE = "role";
    private static final String STUDENT = "student";
    private static final String ERROR = "error";
    private static final String COURSES_ID = "coursesId";


    private final Logger logger = LogManager.getLogger(CommandLogInStudent.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        String login = request.getParameter(LOGIN);
        String password = Utils.MD5(request.getParameter(PASSWORD));
        Student student = DAOFactory.getDAOStudent().findByLogin(login);

        System.out.println(student);
        if (student == null) {
            logger.info(String.format("Wrong login. Login=%s", login));
            session.setAttribute(ERROR, Message.getInstance().getProperty(Message.WRONG_LOGIN));
            request.getRequestDispatcher(Config.getInstance().getProperty(Config.ERROR_PAGE)).forward(request, response);
        } else if (!student.getPasswordStudent().equals(password)) {
            logger.info(String.format("Wrong password. Login=%s  Password=%s", login, password));
            session.setAttribute(ERROR, Message.getInstance().getProperty(Message.WRONG_PASSWORD));
            request.getRequestDispatcher(Config.getInstance().getProperty(Config.ERROR_PAGE)).forward(request, response);
        } else {
            //login and password are  OK!!

            Course course = DAOFactory.getDAOCourse().findByID(student.getIdStudent());

            //course exists
            session.setAttribute(LOGIN, login);
            int idStudent = student.getIdStudent();
            session.setAttribute(ID, idStudent);
            session.setAttribute(ROLE, STUDENT);

            List<Integer> studentCoursesId = DAOFactory.getDAOMark().findCoursesOfStudentByIdStudent(idStudent);

            session.setAttribute(COURSES_ID, studentCoursesId);


            // TODO: 5/28/2016  Достать инфу про курсы, id курсов на которых есть этот студент
            //Чтоб потом отметить, где он есть где нет
            //Тоже самое добавить в команду регистрации!!
            // TODO: 5/28/2016 Дописать дао для этого


            request.getRequestDispatcher(Config.getInstance().getProperty(Config.STUDENT_PAGE)).forward(request, response);

        }

        return null;


    }
}
