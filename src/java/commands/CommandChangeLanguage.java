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

public class CommandChangeLanguage implements ICommand {
    private static final String PAGE = "page";
    private static final String LANGUAGE = "language";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        String language= (String) session.getAttribute(LANGUAGE);
        if(language!=null||language.equals("")){
            if(language.equals("en")){
                session.setAttribute(LANGUAGE,"ua");
            }else{
                session.setAttribute(LANGUAGE,"en");
            }
        }else{
            session.setAttribute(LANGUAGE,"en");
        }
       if(((String)session.getAttribute(PAGE)).equals(Config.COURSES)){
           List<Course> list = DAOFactory.getDAOCourse().readAll();
           request.setAttribute("list", list);
       }
        String page= (String) session.getAttribute(PAGE);
        request.getRequestDispatcher(Config.getInstance().getProperty(page)).forward(request, response);




        return null;
    }
}
