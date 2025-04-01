package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import java.sql.ResultSet;

public class MajorComboBox extends JComboBox {
    public MajorComboBox(int facultyID) {
        super();
        try {
            ResultSet rs = new Database().getQuery("SELECT * FROM major WHERE faculty_id = " + facultyID);
            while (rs.next()) {
                this.addItem(rs.getString("major_name"));
                this.setRenderer(new CustomCombobox());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
