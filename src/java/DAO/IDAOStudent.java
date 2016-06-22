package DAO;

import entities.Student;

public interface IDAOStudent {
    public Student findByID(int id);
    public Student findByEmail(String email);
    public Student findByLogin(String login);

    public boolean create(Student student);




}
