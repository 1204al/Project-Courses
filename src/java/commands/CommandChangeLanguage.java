package commands;


import controllers.ICommand;
import properties.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandChangeLanguage implements ICommand {
    private static final String PAGE = "page";
    private static final String LANGUAGE = "language";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        String language= (String) session.getAttribute(LANGUAGE);
        System.out.println("language = " + language);
        if(language!=null){
            if(language.equals("en")){
                session.setAttribute(LANGUAGE,"ua");
            }else{
                session.setAttribute(LANGUAGE,"en");
            }
        }else{
            session.setAttribute(LANGUAGE,"en");
        }

        String page= (String) session.getAttribute(PAGE);
        request.getRequestDispatcher(Config.getInstance().getProperty(page)).forward(request, response);




        return null;
    }
}
