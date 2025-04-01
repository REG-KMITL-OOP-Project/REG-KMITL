package dev.it22.kmitl.reg.model.grade;

public class GradeModel {
    private String enrollmentId;
    private String grade;

    public GradeModel(String enrollmentId, String grade) {
        this.enrollmentId = enrollmentId;
        this.grade = grade;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
