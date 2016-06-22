package datasource;

import DAO.*;

public class DAOFactory {

    public static IDAOTeacher getDAOTeacher() {
        return new MySQLDAOTeacher();
    }

    public static IDAOCourse getDAOCourse() {
        return new MySQLDAOCourse();
    }

    public static IDAOStudent getDAOStudent() {
        return new MySQLDAOStudent();
    }

    public static IDAOMark getDAOMark() {
        return new MySQLDAOMark();
    }

}
