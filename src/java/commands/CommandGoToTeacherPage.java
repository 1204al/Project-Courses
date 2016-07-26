package commands;

import controllers.ICommand;
import properties.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandGoToTeacherPage implements ICommand{
    private static final String PAGE = "page";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute(PAGE,Config.TEACHER_PAGE);
        request.getRequestDispatcher(Config.getInstance().getProperty(Config.TEACHER_PAGE)).forward(request,response);
        return null;
    }
}
