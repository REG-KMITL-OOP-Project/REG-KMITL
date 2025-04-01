package dev.it22.kmitl.reg.model.grade;

import dev.it22.kmitl.reg.model.grade.GradeModel;
import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;
import java.util.Vector;

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

    public Vector<Vector<String>> getGrades(String studentId) {
        Vector<Vector<String>> data = new Vector<>();
        Database db = new Database();
        String sql = "SELECT c.course_code, c.course_name, c.credits, sc.score1, sc.score2, sc.score3, sc.score4, g.grade FROM enrollment e JOIN score sc ON e.enrollment_id = sc.enrollment_id LEFT JOIN grade g ON e.enrollment_id = g.enrollment_id JOIN section s ON e.section_id = s.section_id JOIN course c ON s.course_id = c.course_code WHERE e.std_id = '" + studentId + "' ORDER BY c.course_code;";
        try {
            ResultSet res = db.getQuery(sql);
            while (res.next()) {
                Vector<String> row = new Vector<>();
                row.add(res.getString("course_code"));
                row.add(res.getString("course_name"));
                row.add(res.getString("score1"));
                row.add(res.getString("score2"));
                row.add(res.getString("score3"));
                row.add(res.getString("score4"));
                row.add(res.getString("grade"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
