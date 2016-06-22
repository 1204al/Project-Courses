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

public class CommandChangeCourse implements ICommand {
    private static final String NAME = "name";
    private static final String INFORMATION = "information";
    private static final String ID = "id";
    private static final String TEACHER_COURSE = "teacherCourse";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String  name=request.getParameter(NAME);
        String  information=request.getParameter(INFORMATION);
        int id= (int) session.getAttribute(ID);

        Course course=null;
        boolean isFullfilled=false;
        if(DAOFactory.getDAOCourse().findByID(id)==null){

            course=new Course(id,name,information);
            isFullfilled=DAOFactory.getDAOCourse().create(course);
            System.out.println("create");
        }else{
            course=new Course(id,name,information);
            isFullfilled=DAOFactory.getDAOCourse().update(course);
        }

        if(isFullfilled){
            session.setAttribute(TEACHER_COURSE,course);
        }


        request.getRequestDispatcher(Config.getInstance().getProperty(Config.TEACHER_PAGE)).forward(request, response);


        return null;
    }
}
