package entities;

public class Course {
    private int idCourse;
    private String nameCourse;
    private String information;

    public Course(int idCourse, String nameCourse, String information) {
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
        this.information = information;
    }



    public Course() {
    }

    public Course(int idCourse) {
        this.idCourse = idCourse;
    }


    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }



     public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (idCourse != course.idCourse) return false;
        if (nameCourse != null ? !nameCourse.equals(course.nameCourse) : course.nameCourse != null) return false;
        return information != null ? information.equals(course.information) : course.information == null;

    }

    @Override
    public int hashCode() {
        int result = idCourse;
        result = 31 * result + (nameCourse != null ? nameCourse.hashCode() : 0);
        result = 31 * result + (information != null ? information.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "idCourse=" + idCourse +
                ", nameCourse='" + nameCourse + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}

