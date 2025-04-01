package dev.it22.kmitl.reg.controller.score;

import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;

public class ScoreDatabase {
    private Database db = new Database();

    public ResultSet getStudentData(String studentId) throws Exception {
        String sql = "SELECT * FROM user WHERE std_id = '" + studentId + "'";
        ResultSet rs = db.getQuery(sql);
        // not found student
        if (!rs.next()) {
            throw new Exception("Student ID not found: " + studentId);
        }
        return rs;
    }

    public ResultSet getSubjectData(String subjectId) throws Exception {
        String sql = "SELECT * FROM course WHERE course_code = '" + subjectId + "'";
        ResultSet rs = db.getQuery(sql);
        // not found subject
        if (!rs.next()) {
            throw new Exception("Subject ID not found: " + subjectId);
        }
        return rs;
    }

    public String getEnrollmentId(String studentId, String subjectId) throws Exception {
        //find student
        String sql = "SELECT * FROM user WHERE std_id = '" + studentId + "'";
        ResultSet rs = db.getQuery(sql);
        if (!rs.next()) {
            throw new Exception("Student ID not found: " + studentId);
        }
        String section = rs.getString("section_id");

        //find section id
        sql = "SELECT * FROM section WHERE section = '" + section + "'" + " AND course_id = '"+ subjectId + "'";
        rs = db.getQuery(sql);
        if (!rs.next()) {
            throw new Exception("Section ID not found for student ID: " + studentId);
        }
        String section_id = rs.getString("section_id");
        System.out.println("Section ID: " + section_id);

        //find enrollment id
        sql = "SELECT * FROM enrollment WHERE std_id = '" + studentId + "' AND section_id = '" + section_id + "'";
        rs = db.getQuery(sql);
        if (!rs.next()) {
            throw new Exception("Enrollment ID not found for student ID: " + studentId + " and section ID: " + section_id);
        }
        String enrollment_id = rs.getString("enrollment_id");
        System.out.println("Enrollment ID: " + enrollment_id);

        return enrollment_id;
    }

    public void addScore(String enrollmentId, int scoreIndex ,double scoreValue) throws Exception {
        //check score exists
        boolean scoreExists = false;
        String sql = "SELECT * FROM score WHERE enrollment_id = '" + enrollmentId + "'";
        ResultSet rs = db.getQuery(sql);
        if (rs.next()) {
            scoreExists = true;
        }
        if (scoreExists) {
            //update score
            sql = "UPDATE score SET score" + scoreIndex + " = '" + scoreValue + "' WHERE enrollment_id = '" + enrollmentId + "'";
        } else {
            //insert new score
            sql = "INSERT INTO score (enrollment_id, score1, score2, score3, score4) VALUES ('" + enrollmentId + "', 0, 0, 0, 0)";
            db.postQuery(sql);
            sql = "UPDATE score SET score" + scoreIndex + " = '" + scoreValue + "' WHERE enrollment_id = '" + enrollmentId + "'";
        }
        db.postQuery(sql);
    }

    public static void main(String[] args) {
        try {
            String enrollID = new ScoreDatabase().getEnrollmentId("67070174","06016408");
            new ScoreDatabase().addScore(enrollID, 3, 50);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
