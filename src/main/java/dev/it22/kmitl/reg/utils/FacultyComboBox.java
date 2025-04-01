package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FacultyComboBox extends JComboBox {
    private ArrayList<String> list = new ArrayList();
    public FacultyComboBox() {
        super();
        try {
            ResultSet rs = new Database().getQuery("SELECT * FROM faculty");
            while (rs.next()) {
                list.add(rs.getString("faculty_id"));
                this.addItem(rs.getString("faculty_name"));
                this.setRenderer(new CustomCombobox());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFacultyName(){
        return (String)this.getSelectedItem();
    }

    public int getFacultyCode(){
        return Integer.valueOf(list.get(this.getSelectedIndex()));
    }
}
