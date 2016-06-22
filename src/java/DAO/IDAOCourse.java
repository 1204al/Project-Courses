package DAO;

import entities.Course;

import java.util.List;

public interface IDAOCourse {
    public List<Course> readAll();
    public boolean create(Course course);
    public Course findByID(int id);
    public boolean update(Course course);



}
