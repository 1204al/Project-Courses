package commands;

import datasource.DAOFactory;
import controllers.ICommand;
import entities.Course;
import entities.Student;
import entities.Teacher;
import properties.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TestCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return null;
    }
}
