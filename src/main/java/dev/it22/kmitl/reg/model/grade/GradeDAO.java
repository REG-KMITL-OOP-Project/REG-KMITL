package dev.it22.kmitl.reg.model.grade;

import dev.it22.kmitl.reg.model.grade.GradeModel;
import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;

public class GradeDAO {
    public String getEnrollmentId(String studentId, String courseCode) {
        Database db = new Database();
        String sql = "SELECT e.enrollment_id FROM enrollment e JOIN section s ON e.section_id = s.section_id WHERE e.std_id = '" + studentId + "' AND s.course_id = '" + courseCode + "';";
        String enrollment = "";
        try {
            ResultSet res = db.getQuery(sql);
            if (res.next()) {
                enrollment = res.getString("enrollment_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enrollment;
    }

    public void addGrade(String enrollmentId, String grade) {
        Database db = new Database();
        String sql = "INSERT INTO grade (enrollment_id, grade) VALUES ('" + enrollmentId + "', '" + grade + "');";
        try {
            int res = db.postQuery(sql);
            System.out.println("Add grade success : " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
