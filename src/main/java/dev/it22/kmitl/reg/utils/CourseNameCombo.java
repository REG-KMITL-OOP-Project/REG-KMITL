package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import java.sql.ResultSet;

public class CourseNameCombo extends JComboBox {
    public CourseNameCombo() {
        super();
        try {
            ResultSet rs = new Database().getQuery("SELECT * FROM course");
            while (rs.next()) {
                this.addItem(rs.getString("course_name"));
                this.setRenderer(new CustomCombobox());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}


