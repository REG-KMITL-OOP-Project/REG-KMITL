package dev.it22.kmitl.reg.model.classroom;

import dev.it22.kmitl.reg.utils.CustomCombobox;
import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CourseData {
    private ArrayList<String> courseCode = new ArrayList<>();
    private ArrayList<String> courseName = new ArrayList<>();
    private ArrayList<Integer> credits = new ArrayList<>();
    private ArrayList<String> years = new ArrayList<>();
    private ArrayList<String> facultyID = new ArrayList<>();
    private ArrayList<String> majorID = new ArrayList<>();
    private ArrayList<String> prerequisite = new ArrayList<>();
    private ArrayList<String> note = new ArrayList<>();

    public CourseData(String sql) {
        try {
            ResultSet rs = new Database().getQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("course_code"));
                courseCode.add( rs.getString("course_code"));
                courseName.add( rs.getString("course_name"));
                credits.add( rs.getInt("credits"));
                years.add( rs.getString("years"));
                facultyID.add( rs.getString("faculty_id"));
                majorID.add( rs.getString("major_id"));
                prerequisite.add( rs.getString("prerequisite"));
                note.add( rs.getString("note"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getCourseCode() {
        return courseCode;
    }

    public ArrayList<String> getCourseName() {
        return courseName;
    }

    public ArrayList<Integer> getCredits() {
        return credits;
    }

    public ArrayList<String> getYears() {
        return years;
    }

    public ArrayList<String> getFacultyID() {
        return facultyID;
    }

    public ArrayList<String> getMajorID() {
        return majorID;
    }

    public ArrayList<String> getPrerequisite() {
        return prerequisite;
    }

    public ArrayList<String> getNote() {
        return note;
    }
}
