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

public class DefaultCommand implements ICommand {
    private static final String PAGE = "page";
    private static final String LANGUAGE = "language";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        List<Course> list=DAOFactory.getDAOCourse().readAll();
        request.setAttribute("list",list);

        session.setAttribute("default","IT IS DEFAULT COMMAND");

        session.setAttribute(LANGUAGE,"en");
        session.setAttribute(PAGE,Config.COURSES);
        request.getRequestDispatcher(Config.getInstance().getProperty(Config.COURSES)).forward(request, response);

        return null;
    }
}
