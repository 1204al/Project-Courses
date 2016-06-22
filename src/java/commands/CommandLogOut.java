package commands;

import controllers.ICommand;
import datasource.DAOFactory;
import entities.Course;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CommandLogOut implements ICommand {
    private final Logger logger = LogManager.getLogger(CommandLogOut.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().invalidate();
        HttpSession session=request.getSession();

        List<Course> list= DAOFactory.getDAOCourse().readAll();
        session.setAttribute("list",list);
        request.getRequestDispatcher(Config.getInstance().getProperty(Config.COURSES)).forward(request,response);
        return null;
    }
}
