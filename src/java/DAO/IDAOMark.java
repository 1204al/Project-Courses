package DAO;

import entities.Mark;

import java.util.List;

public interface IDAOMark {
    public boolean create(int idStudent,int idCourse);
    public List<Mark> findByIdCourse(int idCourse);

    public boolean remove(int idStudent,int idCourse);
    public boolean update(Mark mark);
    public List<Integer> findCoursesOfStudentByIdStudent(int id);

}
