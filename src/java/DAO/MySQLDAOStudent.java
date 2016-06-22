package DAO;

import datasource.ConnectionSource;
import entities.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLDAOStudent implements IDAOStudent {
    private static String READ_BY_ID_QUERY = "SELECT * FROM students WHERE idStudent=?";
    private static String READ_BY_EMAIL_QUERY = "SELECT * FROM students WHERE emailStudent=?";
    private static String READ_BY_LOGIN_QUERY = "SELECT * FROM students WHERE loginStudent=?";
    private static String CREATE_QUERY = "INSERT INTO students(emailStudent,passwordStudent,nameStudent,loginStudent) VALUES(?,?,?,?)";

    private final Logger logger = LogManager.getLogger(MySQLDAOStudent.class.getName());

    @Override
    public Student findByID(int idStudent) {
        Student student = null;
        try (Connection conn = ConnectionSource.getInstance().getConnection();) {

            PreparedStatement preparedStatement = conn.prepareStatement(READ_BY_ID_QUERY);
            preparedStatement.setInt(1, idStudent);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = studentFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.error(e);


        }
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        Student student = null;
        try (Connection conn = ConnectionSource.getInstance().getConnection();) {

            PreparedStatement preparedStatement = conn.prepareStatement(READ_BY_EMAIL_QUERY);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            ;
            if (resultSet.next()) {
                student = studentFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return student;
    }

    @Override
    public Student findByLogin(String login) {
        Student student = null;
        try (Connection conn = ConnectionSource.getInstance().getConnection();) {

            PreparedStatement preparedStatement = conn.prepareStatement(READ_BY_LOGIN_QUERY);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            ;
            if (resultSet.next()) {
                student = studentFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return student;
    }


    @Override
    public boolean create(Student student) {
        try (Connection conn = ConnectionSource.getInstance().getConnection();) {
            System.out.println(student.toString());
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_QUERY);
            preparedStatement.setString(1, student.getEmailStudent());
            preparedStatement.setString(2, student.getPasswordStudent());
            preparedStatement.setString(3, student.getNameStudent());
            preparedStatement.setString(4, student.getLoginStudent());
            System.out.println(preparedStatement.toString());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.entry(e);
            return false;
        }
        return true;
    }


    private Student studentFromResultSet(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setIdStudent(resultSet.getInt("idStudent"));
        student.setEmailStudent(resultSet.getString("emailStudent"));
        student.setPasswordStudent(resultSet.getString("passwordStudent"));
        student.setNameStudent(resultSet.getString("nameStudent"));
        student.setLoginStudent(resultSet.getString("loginStudent"));

        return student;
    }
}
