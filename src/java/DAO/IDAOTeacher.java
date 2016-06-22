package DAO;

import entities.Student;
import entities.Teacher;

public interface IDAOTeacher {
    public Teacher findById(int id);
    public Teacher findByEmail(String email);
    public Teacher findByLogin(String login);

    public boolean create(Teacher student);


}
