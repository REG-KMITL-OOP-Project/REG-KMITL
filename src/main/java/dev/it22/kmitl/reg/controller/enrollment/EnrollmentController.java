package dev.it22.kmitl.reg.controller.enrollment;

import dev.it22.kmitl.reg.model.enrollment.EnrollmentModel;
import dev.it22.kmitl.reg.model.enrollment.EnrollmentDAO;

public class EnrollmentController {
    private EnrollmentDAO EnrollmentDAO;

    public EnrollmentController() {
        this.EnrollmentDAO = new EnrollmentDAO();
    }

    public void addEnrollment(String enrollmentId, String studentId, String sectionId) {
        EnrollmentModel newEnrollment = new EnrollmentModel(enrollmentId, studentId, sectionId);
        EnrollmentDAO.addEnrollment(newEnrollment);
    }

    public String getStudentById(String studentId) {
        return EnrollmentDAO.getStudentById(studentId);
    }
}
