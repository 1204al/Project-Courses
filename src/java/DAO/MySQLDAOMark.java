package DAO;

import datasource.ConnectionSource;
import entities.Course;
import entities.Mark;
import entities.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLDAOMark implements IDAOMark {

    private static String CREATE_QUERY = "INSERT INTO marks (idStudent,idCourse,dateReg) VALUES (?,?,NOW())";
    private static String UPDATE_MARK_QUERY = "UPDATE marks SET mark=? where idMark=?";
    private static String FIND_COURSE_ID_BY_STUDENT_ID_QUERY = "SELECT idCourse FROM marks where idStudent=?";

    private static String REMOVE_MARK_BY_STUDENT_ID_AND_COURSE_ID_QUERY = "DELETE FROM marks WHERE idStudent=? and idCourse=?";
    private static String FIND_MARKS_BY_COURSE_ID = "SELECT * FROM marks where idCourse =?";

    @Override
    public List<Integer> findCoursesOfStudentByIdStudent(int idStudent) {
        List<Integer> list=new ArrayList<>();
        try (Connection conn = ConnectionSource.getInstance().getConnection();) {
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_COURSE_ID_BY_STUDENT_ID_QUERY);
            preparedStatement.setInt(1, idStudent);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(resultSet.getInt("idCourse"));
            }

        } catch (SQLException e) {
            logger.entry(e);
            return null;
        }
        return list;

    }

    private final Logger logger = LogManager.getLogger(MySQLDAOMark.class.getName());


    @Override
    public boolean create(int idStudent, int idCourse) {
        try (Connection conn = ConnectionSource.getInstance().getConnection();) {
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_QUERY);
            preparedStatement.setInt(1, idStudent);
            preparedStatement.setInt(2, idCourse);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e);
            return false;
        }
        return true;
    }



    @Override
    public boolean remove(int idStudent, int idCourse) {
        try (Connection conn = ConnectionSource.getInstance().getConnection();) {
            PreparedStatement preparedStatement = conn.prepareStatement(REMOVE_MARK_BY_STUDENT_ID_AND_COURSE_ID_QUERY);
            preparedStatement.setInt(1, idStudent);
            preparedStatement.setInt(2, idCourse);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e);
            return false;
        }

        return true;
    }

    @Override
    public boolean update(Mark mark) {
        return false;
    }




    @Override
    public List<Mark> findByIdCourse(int idCourse) {
        List<Mark> marks=new ArrayList<>();
        try (Connection conn = ConnectionSource.getInstance().getConnection();) {
            PreparedStatement ps = conn.prepareStatement(FIND_MARKS_BY_COURSE_ID);
            ps.setInt(1,idCourse);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                Mark mark = markFromResultSet(rs);
                marks.add(mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


        return marks;
    }

    private Mark markFromResultSet(ResultSet rs) throws SQLException {

        Mark mark = new Mark();
        mark.setIdMark(rs.getInt("idMark"));
        mark.setStudent(new Student(rs.getInt("idStudent")));
        mark.setCourse(new Course(rs.getInt("idCourse")));
        mark.setMark(rs.getString("mark"));
        return mark;
    }
}
