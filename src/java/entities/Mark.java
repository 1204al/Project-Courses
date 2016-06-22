package entities;

import java.util.Date;

public class Mark {
    private int idMark;
    private String mark;
    private Date dateReg;
    private Course course;
    private Student student;

    public Mark() {
    }

    public Mark(int idMark, String mark, Date dateReg, Course course, Student student) {
        this.idMark = idMark;
        this.mark = mark;
        this.dateReg = dateReg;
        this.course = course;
        this.student = student;
    }

    public int getIdMark() {
        return idMark;
    }

    public void setIdMark(int idMark) {
        this.idMark = idMark;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark1 = (Mark) o;

        if (idMark != mark1.idMark) return false;
        if (mark != null ? !mark.equals(mark1.mark) : mark1.mark != null) return false;
        if (dateReg != null ? !dateReg.equals(mark1.dateReg) : mark1.dateReg != null) return false;
        if (course != null ? !course.equals(mark1.course) : mark1.course != null) return false;
        return student != null ? student.equals(mark1.student) : mark1.student == null;

    }

    @Override
    public int hashCode() {
        int result = idMark;
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + (dateReg != null ? dateReg.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (student != null ? student.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "idMark=" + idMark +
                ", mark='" + mark + '\'' +
                ", dateReg='" + dateReg + '\'' +
                ", course=" + course +
                ", student=" + student +
                '}';
    }
}
