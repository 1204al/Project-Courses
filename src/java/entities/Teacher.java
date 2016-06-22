package entities;

public class Teacher {
    private int idTeacher;

    private String emailTeacher;
    private String passwordTeacher;
    private String nameTeacher;
    private String loginTeacher;

    public Teacher() {
    }

    public Teacher(int idTeacher) {

        this.idTeacher = idTeacher;
    }

    public Teacher(String emailTeacher, String passwordTeacher, String nameTeacher, String loginTeacher) {
        this.emailTeacher = emailTeacher;
        this.passwordTeacher = passwordTeacher;
        this.nameTeacher = nameTeacher;
        this.loginTeacher = loginTeacher;
    }

    public Teacher(int idTeacher, String emailTeacher, String passwordTeacher, String nameTeacher, String loginTeacher) {
        this.idTeacher = idTeacher;
        this.emailTeacher = emailTeacher;
        this.passwordTeacher = passwordTeacher;
        this.nameTeacher = nameTeacher;
        this.loginTeacher = loginTeacher;
    }

    public String getLoginTeacher() {
        return loginTeacher;
    }

    public void setLoginTeacher(String loginTeacher) {
        this.loginTeacher = loginTeacher;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getEmailTeacher() {
        return emailTeacher;
    }

    public void setEmailTeacher(String emailTeacher) {
        this.emailTeacher = emailTeacher;
    }

    public String getPasswordTeacher() {
        return passwordTeacher;
    }

    public void setPasswordTeacher(String passwordTeacher) {
        this.passwordTeacher = passwordTeacher;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "idTeacher=" + idTeacher +
                ", emailTeacher='" + emailTeacher + '\'' +
                ", passwordTeacher='" + passwordTeacher + '\'' +
                ", nameTeacher='" + nameTeacher + '\'' +
                ", loginTeacher='" + loginTeacher + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (idTeacher != teacher.idTeacher) return false;
        if (emailTeacher != null ? !emailTeacher.equals(teacher.emailTeacher) : teacher.emailTeacher != null)
            return false;
        if (passwordTeacher != null ? !passwordTeacher.equals(teacher.passwordTeacher) : teacher.passwordTeacher != null)
            return false;
        if (nameTeacher != null ? !nameTeacher.equals(teacher.nameTeacher) : teacher.nameTeacher != null) return false;
        return loginTeacher != null ? loginTeacher.equals(teacher.loginTeacher) : teacher.loginTeacher == null;

    }

    @Override
    public int hashCode() {
        int result = idTeacher;
        result = 31 * result + (emailTeacher != null ? emailTeacher.hashCode() : 0);
        result = 31 * result + (passwordTeacher != null ? passwordTeacher.hashCode() : 0);
        result = 31 * result + (nameTeacher != null ? nameTeacher.hashCode() : 0);
        result = 31 * result + (loginTeacher != null ? loginTeacher.hashCode() : 0);
        return result;
    }
}
