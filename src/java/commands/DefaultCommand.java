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
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        List<Course> list=DAOFactory.getDAOCourse().readAll();
        session.setAttribute("list",list);
        session.setAttribute("default","IT IS DEFAULT COMMAND");


        request.getRequestDispatcher(Config.getInstance().getProperty(Config.COURSES)).forward(request, response);

        return null;
    }
}
