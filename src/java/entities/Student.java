package entities;

public class Student {
    private int idStudent;
    private String emailStudent;
    private String passwordStudent;
    private String nameStudent;
    private String loginStudent;

    public String getLoginStudent() {
        return loginStudent;
    }

    public void setLoginStudent(String loginStudent) {
        this.loginStudent = loginStudent;
    }


    public Student() {
    }

    public Student(int idStudent) {

        this.idStudent = idStudent;
    }

    public Student(String emailStudent, String passwordStudent, String nameStudent, String loginStudent) {
        this.emailStudent = emailStudent;
        this.passwordStudent = passwordStudent;
        this.nameStudent = nameStudent;
        this.loginStudent = loginStudent;
    }

    public Student(int idStudent, String emailStudent, String passwordStudent, String nameStudent, String loginStudent) {

        this.idStudent = idStudent;
        this.emailStudent = emailStudent;
        this.passwordStudent = passwordStudent;
        this.nameStudent = nameStudent;
        this.loginStudent = loginStudent;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getEmailStudent() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    public String getPasswordStudent() {
        return passwordStudent;
    }

    public void setPasswordStudent(String passwordStudent) {
        this.passwordStudent = passwordStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }


    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", emailStudent='" + emailStudent + '\'' +
                ", passwordStudent='" + passwordStudent + '\'' +
                ", loginStudent='" + loginStudent + '\'' +
                ", nameStudent='" + nameStudent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (idStudent != student.idStudent) return false;
        if (emailStudent != null ? !emailStudent.equals(student.emailStudent) : student.emailStudent != null)
            return false;
        if (passwordStudent != null ? !passwordStudent.equals(student.passwordStudent) : student.passwordStudent != null)
            return false;
        if (loginStudent != null ? !loginStudent.equals(student.loginStudent) : student.loginStudent != null)
            return false;
        return nameStudent != null ? nameStudent.equals(student.nameStudent) : student.nameStudent == null;

    }

    @Override
    public int hashCode() {
        int result = idStudent;
        result = 31 * result + (emailStudent != null ? emailStudent.hashCode() : 0);
        result = 31 * result + (passwordStudent != null ? passwordStudent.hashCode() : 0);
        result = 31 * result + (loginStudent != null ? loginStudent.hashCode() : 0);
        result = 31 * result + (nameStudent != null ? nameStudent.hashCode() : 0);
        return result;
    }
}
