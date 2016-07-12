package commands;

import com.sun.org.apache.xpath.internal.SourceTree;
import controllers.ICommand;
import datasource.DAOFactory;
import entities.Course;
import entities.Mark;
import entities.Student;
import entities.Teacher;
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
import java.util.List;

public class CommandLogInTeacher implements ICommand {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String ID = "id";
    private static final String TEACHER_COURSE = "teacherCourse";
    private static final String ROLE = "role";
    private static final String TEACHER = "teacher";
    private static final String MARKS = "marks";



    private static final String ERROR = "error";


    private final Logger logger = LogManager.getLogger(CommandLogInTeacher.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();


        String login=request.getParameter(LOGIN);
        String password= Utils.MD5(request.getParameter(PASSWORD));
        Teacher teacher= DAOFactory.getDAOTeacher().findByLogin(login);

        System.out.println(teacher);
        if(teacher==null){
            logger.info(String.format("Wrong login. Login=%s", login));
            session.setAttribute(ERROR, Message.getInstance().getProperty(Message.WRONG_LOGIN));
            request.getRequestDispatcher(Config.getInstance().getProperty(Config.ERROR_PAGE)).forward(request, response);
        }else if(!teacher.getPasswordTeacher().equals(password)){
            logger.info(String.format("Wrong password. Login=%s  Password=%s",login,password));
            session.setAttribute(ERROR,Message.getInstance().getProperty(Message.WRONG_PASSWORD));
            request.getRequestDispatcher(Config.getInstance().getProperty(Config.ERROR_PAGE)).forward(request, response);
        } else{
            //login and password are  OK!!

            Course course=DAOFactory.getDAOCourse().findByID(teacher.getIdTeacher());

            //course exists
            session.setAttribute(LOGIN, login);
            session.setAttribute(ID, teacher.getIdTeacher());
            session.setAttribute(ROLE,TEACHER);
            if(course!=null){
                session.setAttribute(TEACHER_COURSE,course);
            }

            System.out.println("teacher.getIdTeacher() = " + teacher.getIdTeacher());
            List<Mark> marks=DAOFactory.getDAOMark().findByIdCourse(teacher.getIdTeacher());
            System.out.println("marks = " + marks);
            if(marks.size()>0){
                for (int i = 0; i < marks.size(); i++) {
                    Student student=DAOFactory.getDAOStudent().findByID(marks.get(i).getStudent().getIdStudent());
                    marks.get(i).setStudent(student);
                }
                session.setAttribute(MARKS,marks);
            }

            request.getRequestDispatcher(Config.getInstance().getProperty(Config.TEACHER_PAGE)).forward(request, response);

        }

        return null;
    }
}
