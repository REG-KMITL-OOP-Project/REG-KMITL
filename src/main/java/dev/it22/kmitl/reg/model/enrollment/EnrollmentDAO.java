package dev.it22.kmitl.reg.model.enrollment;

import dev.it22.kmitl.reg.utils.Database;
import dev.it22.kmitl.reg.model.auth.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrollmentDAO {
    public void addEnrollment(EnrollmentModel enrollment) throws Exception {
        Database db = new Database();
        try {
            String query = "INSERT INTO enrollment (enrollment_id, std_id, section_id) VALUES ('" + enrollment.getEnrollmentId() + "', '" + enrollment.getStudentId() + "', '" + enrollment.getSectionId() + "');";
            int res = db.postQuery(query);
            System.out.println("Enrollment success : " + res);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    public String getStudentById(String studentId) {
        Database db = new Database();
        String fullname = "";
        try {
            String query = "SELECT * FROM user WHERE std_id = '" + studentId + "';";
            ResultSet rs = db.getQuery(query);
            String fname = rs.getString("fname");
            String lname = rs.getString("lname");
            fullname = fname + " " + lname;
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fullname;
    }
}
