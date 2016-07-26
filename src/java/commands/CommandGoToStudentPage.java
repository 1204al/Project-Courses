package commands;

import controllers.ICommand;
import properties.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandGoToStudentPage implements ICommand {
    private static final String PAGE = "page";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute(PAGE,Config.STUDENT_PAGE);

        request.getRequestDispatcher(Config.getInstance().getProperty(Config.STUDENT_PAGE)).forward(request,response);

        return null;
    }
}
