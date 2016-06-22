package controllers;

import commands.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ControllerHelper {
    private static final String COMMAND = "command";
    private static final String DEFAULT_COMMAND_NAME = "default";
    private static ControllerHelper instance = null;

    private static Map<String, ICommand> commands = new HashMap<>();


    static{
        //TODO тут команды
        //commands.put("empty", new EmptyCommand());
        commands.put("test",new TestCommand());
        commands.put("default",new DefaultCommand());

        commands.put("loginStudent",new CommandLogInStudent());
        commands.put("registrationStudent",new CommandRegistrationStudent());
        commands.put("registrationStudentOnCourse",new CommandRegistrationStudentOnCourse());
        commands.put("goToStudentPage",new CommandGoToStudentPage());
        commands.put("leavingTheCourse",new CommandLeavingCourse());


        commands.put("loginTeacher",new CommandLogInTeacher());
        commands.put("registrationTeacher",new CommandRegistrationTeacher());
        commands.put("changeCourse",new CommandChangeCourse());
        commands.put("goToTeacherPage",new CommandGoToTeacherPage());

        commands.put("logout",new CommandLogOut());


    }

    public static ControllerHelper getInstance(){
        if(instance==null){
            instance=new ControllerHelper();
        }
        return instance;
    }

    public static ICommand getCommand(HttpServletRequest request){
        String command = request.getParameter(COMMAND);

        System.out.println("The command is \"" + command+"\"");

        if(command==null) return commands.get(DEFAULT_COMMAND_NAME);
        ICommand t=commands.get(command);
        if(t==null){
            System.out.println("        But this command isn't existing!!!");
            return commands.get(DEFAULT_COMMAND_NAME);
        }

        return t;
    }

}
