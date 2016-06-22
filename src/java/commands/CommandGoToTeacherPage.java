package commands;

import controllers.ICommand;
import properties.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandGoToTeacherPage implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(Config.getInstance().getProperty(Config.TEACHER_PAGE)).forward(request,response);
        return null;
    }
}
