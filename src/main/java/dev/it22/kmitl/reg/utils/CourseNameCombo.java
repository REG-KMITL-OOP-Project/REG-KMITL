package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CourseNameCombo extends JComboBox {
    ArrayList<ArrayList> course2 = new ArrayList<>();
    ArrayList<String> course ;
    public CourseNameCombo() {
        super();
        try {
            ResultSet rs = new Database().getQuery("SELECT * FROM course");
            while (rs.next()) {
                course = new ArrayList<>();
                course.add(rs.getString("course_code"));
                course.add(rs.getString("course_name"));
                course.add(rs.getString("credits"));
                course.add(rs.getString("years"));
                course.add(rs.getString("faculty_id"));
                course.add(rs.getString("major_id"));
                course.add(rs.getString("prerequisite"));
                course.add(rs.getString("note"));
                course2.add(course);
                this.addItem(rs.getString("course_name"));
                this.setRenderer(new CustomCombobox());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCourseCode() {
        return (String) course2.get(this.getSelectedIndex()).get(0);
    }

    public String getCourseName() {
        return (String) course2.get(this.getSelectedIndex()).get(1);
    }

    public int getCredits() {
        return Integer.valueOf((String) course2.get(this.getSelectedIndex()).get(2));
    }

    public String getYears() {
        return (String) course2.get(this.getSelectedIndex()).get(3);
    }

    public String getFacultyId() {
        return (String) course2.get(this.getSelectedIndex()).get(4);
    }

    public String getMajorId() {
        return (String) course2.get(this.getSelectedIndex()).get(5);
    }

    public String getPrerequisite() {
        return (String) course2.get(this.getSelectedIndex()).get(6);
    }

    public String getNote() {
        return (String) course2.get(this.getSelectedIndex()).get(7);
    }

}


