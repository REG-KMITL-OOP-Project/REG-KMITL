package dev.it22.kmitl.reg.utils;

import dev.it22.kmitl.reg.model.classroom.CourseData;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CourseNameCombo extends JComboBox {
    CourseData course2;
    public CourseNameCombo() {
        this(new CourseData("SELECT * FROM course"));
    }

    public CourseNameCombo(CourseData courseData) {
        super();
        course2 = courseData;
        for (int i = 0; i < courseData.getCourseName().size(); i++) {
            this.addItem(courseData.getCourseName().get(i));
            this.setRenderer(new CustomCombobox());
        }
    }

    public String getCourseCode() {
        return course2.getCourseCode().get(this.getSelectedIndex());
    }

    public String getCourseName() {
        return course2.getCourseName().get(this.getSelectedIndex());
    }

    public int getCredits() {
        return course2.getCredits().get(this.getSelectedIndex());
    }

    public String getYears() {
        return course2.getYears().get(this.getSelectedIndex());
    }

    public String getFacultyId() {
        return course2.getFacultyID().get(this.getSelectedIndex());
    }

    public String getMajorId() {
        return course2.getMajorID().get(this.getSelectedIndex());
    }

    public String getPrerequisite() {
        return course2.getPrerequisite().get(this.getSelectedIndex());
    }

    public String getNote() {
        return course2.getNote().get(this.getSelectedIndex());
    }

}


