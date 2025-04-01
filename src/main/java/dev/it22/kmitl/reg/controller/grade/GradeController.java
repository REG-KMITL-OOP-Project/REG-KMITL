package dev.it22.kmitl.reg.controller.grade;

import dev.it22.kmitl.reg.model.grade.GradeDAO;
import dev.it22.kmitl.reg.model.grade.GradeModel;

import java.sql.SQLException;
import java.util.Vector;

public class GradeController {
    private GradeDAO gradeDAO;

    public GradeController() {
        this.gradeDAO = new GradeDAO();
    }

    public String getEnrollmentId(String studentId, String courseCode) {
        return gradeDAO.getEnrollmentId(studentId, courseCode);
    }

    public String getSubjectNameById(String courseCode) {
        return gradeDAO.getSubjectNameById(courseCode);
    }

    public boolean addGrade(String enrollmentId, String grade) throws SQLException {
        return gradeDAO.addGrade(enrollmentId, grade);
    }

    public Vector<Vector<String>> getGrades(String enrollmentId) {
        return gradeDAO.getGrades(enrollmentId);
    }
}
