package DAO;

import datasource.ConnectionSource;
import entities.Teacher;
import entities.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLDAOTeacher implements IDAOTeacher {
    private static String READ_BY_ID_QUERY="SELECT * FROM teachers WHERE idTeacher=?";
    private static String READ_BY_EMAIL_QUERY="SELECT * FROM teachers WHERE emailTeacher=?";
    private static String READ_BY_LOGIN_QUERY="SELECT * FROM teachers WHERE loginTeacher=?";
    private static String CREATE_QUERY="INSERT INTO teachers(emailTeacher,passwordTeacher,nameTeacher,loginTeacher) VALUES(?,?,?,?)";

    private final Logger logger = LogManager.getLogger(MySQLDAOTeacher.class.getName());

    public Teacher findById(int idTeacher) {
        Teacher teacher=null;
        try( Connection conn= ConnectionSource.getInstance().getConnection();){

            PreparedStatement preparedStatement=conn.prepareStatement(READ_BY_ID_QUERY);
            preparedStatement.setInt(1,idTeacher);
            ResultSet resultSet=preparedStatement.executeQuery();;
            if(resultSet.next()){
                teacher=teacherFromResultSet(resultSet);
            }
        }catch (SQLException e){
            logger.error(e);


        }
        return teacher;
    }

    @Override
    public Teacher findByEmail(String email) {
        Teacher teacher=null;
        try(Connection conn= ConnectionSource.getInstance().getConnection();){

            PreparedStatement preparedStatement=conn.prepareStatement(READ_BY_EMAIL_QUERY);
            preparedStatement.setString(1,email);
            ResultSet resultSet=preparedStatement.executeQuery();;
            if(resultSet.next()){
                teacher=teacherFromResultSet(resultSet);
            }
        }catch (SQLException e){
            logger.error(e);
        }
        return teacher;
    }

    @Override
    public Teacher findByLogin(String login) {
        Teacher teacher=null;
        try( Connection conn= ConnectionSource.getInstance().getConnection();){

            PreparedStatement preparedStatement=conn.prepareStatement(READ_BY_LOGIN_QUERY);
            preparedStatement.setString(1,login);
            ResultSet resultSet=preparedStatement.executeQuery();;
            if(resultSet.next()){
                teacher=teacherFromResultSet(resultSet);
            }
        }catch (SQLException e){
            logger.error(e);
        }
        return teacher;
    }




    @Override
    public boolean create(Teacher teacher) {
        try( Connection conn=ConnectionSource.getInstance().getConnection();){

            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_QUERY);
            preparedStatement.setString(1, teacher.getEmailTeacher());
            preparedStatement.setString(2, teacher.getPasswordTeacher());
            preparedStatement.setString(3, teacher.getNameTeacher());
            preparedStatement.setString(4, teacher.getLoginTeacher());
            preparedStatement.execute();
        }catch (SQLException e){
            logger.entry(e);
            return false;
        }
        return true;
    }


    private Teacher teacherFromResultSet(ResultSet resultSet) throws SQLException {
        Teacher teacher=new Teacher();
        teacher.setIdTeacher(resultSet.getInt("idTeacher"));
        teacher.setEmailTeacher(resultSet.getString("emailTeacher"));
        teacher.setPasswordTeacher(resultSet.getString("passwordTeacher"));
        teacher.setNameTeacher(resultSet.getString("nameTeacher"));
        teacher.setLoginTeacher(resultSet.getString("loginTeacher"));
        return teacher;
    }
}
