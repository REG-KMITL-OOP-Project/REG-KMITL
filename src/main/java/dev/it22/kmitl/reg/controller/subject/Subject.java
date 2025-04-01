package dev.it22.kmitl.reg.controller.subject;

import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;

public class Subject {
    public ResultSet getAllSubject() throws Exception{
        Database db = new Database();
        String sql = "SELECT * FROM course";
        ResultSet rs = db.getQuery(sql);
        return rs;
    }
    public  ResultSet getCourseByIdWithSection(String courseId,int section) throws Exception{
        Database db = new Database();
        //find section id
        String sql = "SELECT * FROM section WHERE section = '" + section + "'" + " AND course_id = '"+ courseId + "'";
        ResultSet rs = db.getQuery(sql);
        if (!rs.next()) {
            throw new Exception("Section ID not found");
        }
        String section_id = rs.getString("section_id");
        System.out.println("Section ID: " + section_id);

        //find enrollment id
        sql = "SELECT * FROM enrollment WHERE section_id = '" + section_id + "'";
        rs = db.getQuery(sql);

        return rs;
    }

    public static void main(String[] args) {
        try {
            new Subject().getCourseByIdWithSection("06066303",2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}

