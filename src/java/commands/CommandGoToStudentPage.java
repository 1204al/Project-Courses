package commands;

import controllers.ICommand;
import datasource.DAOFactory;
import entities.Course;
import properties.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CommandGoToStudentPage implements ICommand {
    private static final String PAGE = "page";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Course> list= DAOFactory.getDAOCourse().readAll();
        request.setAttribute("list",list);
        session.setAttribute(PAGE,Config.STUDENT_PAGE);

        request.getRequestDispatcher(Config.getInstance().getProperty(Config.STUDENT_PAGE)).forward(request,response);

        return null;
    }
}
