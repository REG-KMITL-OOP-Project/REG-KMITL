package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import java.sql.ResultSet;

public class FacultyComboBox extends JComboBox {
    public FacultyComboBox() {
        super();
        try {
            ResultSet rs = new Database().getQuery("SELECT * FROM faculty");
            while (rs.next()) {
                this.addItem(rs.getString("faculty_name"));
                this.setRenderer(new CustomCombobox());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
