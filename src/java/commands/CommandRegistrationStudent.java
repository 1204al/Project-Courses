package commands;

import controllers.ICommand;
import datasource.DAOFactory;
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
import java.util.List;

public class CommandRegistrationStudent implements ICommand {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String ID = "id";
    private static final String ROLE = "role";
    private static final String STUDENT = "student";

    private static final String ERROR = "error";
    private static final String COURSES_ID = "courses";


    private final Logger logger = LogManager.getLogger(CommandRegistrationStudent.class.getName());
    private static final String PAGE = "page";



    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String name = request.getParameter(NAME);
        String email = request.getParameter(EMAIL);

        if (DAOFactory.getDAOStudent().findByLogin(login) != null){
            logger.info(String.format("Login is already in use. Login = %s",login));
            request.getSession().setAttribute(ERROR, Message.WRONG_LOGIN_USED);
            session.setAttribute(PAGE,Config.ERROR_PAGE);
            request.getRequestDispatcher(Config.getInstance().getProperty(Config.ERROR_PAGE)).forward(request,response);
            return null;
        }
        if (DAOFactory.getDAOStudent().findByEmail(email) != null){
            logger.info(String.format("EMAIL is already in use. EMAIL = %s",login));
            request.getSession().setAttribute(ERROR, Message.WRONG_EMAIL_USED);
            session.setAttribute(PAGE,Config.ERROR_PAGE);
            request.getRequestDispatcher(Config.getInstance().getProperty(Config.ERROR_PAGE)).forward(request,response);
            return null;
        }

        Student student=new Student(email, Utils.MD5(password),name,login);
        if(DAOFactory.getDAOStudent().create(student)){
            session.setAttribute(LOGIN, login);
            student= DAOFactory.getDAOStudent().findByLogin(login);
            session.setAttribute(ID, student.getIdStudent());
            session.setAttribute(ROLE,STUDENT);


            session.setAttribute(COURSES_ID,null);



            session.setAttribute(PAGE,Config.STUDENT_PAGE);
            request.getRequestDispatcher(Config.getInstance().getProperty(Config.STUDENT_PAGE)).forward(request, response);

        } else{
            request.getSession().setAttribute(ERROR, Message.RANDOM_ERROR);
            session.setAttribute(PAGE,Config.ERROR_PAGE);
            request.getRequestDispatcher(Config.getInstance().getProperty(Config.ERROR_PAGE)).forward(request,response);
        }




        return null;


    }
}
