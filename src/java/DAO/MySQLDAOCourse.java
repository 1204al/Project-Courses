package DAO;

import datasource.ConnectionSource;
import entities.Course;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MySQLDAOCourse implements IDAOCourse {
    private static String READ_ALL_QUERY = "SELECT * FROM courses;";
    private static String CREATE_QUERY = "INSERT INTO courses (idCourse ,nameCourse,information) VALUES (?,?,?);";
    private static String READ_BY_ID_QUERY = "SELECT * FROM courses WHERE idCourse=?;";
    private static String UPDATE_QUERY = "UPDATE courses SET nameCourse=?,information=? WHERE idCourse=?";


    private final Logger logger = LogManager.getLogger(MySQLDAOCourse.class.getName());

    @Override
    public boolean update(Course course) {
        try (Connection dbConnection = ConnectionSource.getInstance().getConnection();) {

            PreparedStatement preparedStatement = dbConnection.prepareStatement(UPDATE_QUERY);

            preparedStatement.setString(1, course.getNameCourse());
            preparedStatement.setString(2, course.getInformation());
            preparedStatement.setInt(3, course.getIdCourse());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            logger.error(e);
            return false;
        }
    }

    @Override
    public boolean create(Course course) {
        try (Connection dbConnection = ConnectionSource.getInstance().getConnection();) {

            PreparedStatement preparedStatement = dbConnection.prepareStatement(CREATE_QUERY);
            preparedStatement.setInt(1, course.getIdCourse());
            preparedStatement.setString(2, course.getNameCourse());
            preparedStatement.setString(3, course.getInformation());

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            logger.error(e);
            return false;
        }
    }

    @Override
    public Course findByID(int id) {
        Course course = null;
        try (Connection conn = ConnectionSource.getInstance().getConnection();) {
            PreparedStatement ps = conn.prepareStatement(READ_BY_ID_QUERY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                course = courseFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public List<Course> readAll() {
        List<Course> list = new ArrayList<>();
        try (Connection conn = ConnectionSource.getInstance().getConnection();) {
            PreparedStatement ps = conn.prepareStatement(READ_ALL_QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course course = courseFromResultSet(rs);
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    private Course courseFromResultSet(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setIdCourse(rs.getInt("idCourse"));
        course.setNameCourse(rs.getString("nameCourse"));
        course.setInformation(rs.getString("information"));
        return course;
    }


}
