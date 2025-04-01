package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MajorComboBox extends JComboBox {
    private ArrayList<String> list;
    public MajorComboBox(int facultyID) {
        list = new ArrayList<>();
        super();
        try {
            ResultSet rs = new Database().getQuery("SELECT * FROM major WHERE faculty_id = " + facultyID);
            while (rs.next()) {
                list.add(rs.getString("major_id"));
                this.addItem(rs.getString("major_name"));
                this.setRenderer(new CustomCombobox());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refresh(int facultyID) {
        list.clear();
        this.removeAllItems();
        try {
            ResultSet rs = new Database().getQuery("SELECT * FROM major WHERE faculty_id = " + facultyID);
            while (rs.next()) {
                list.add(rs.getString("major_id"));
                this.addItem(rs.getString("major_name"));
                this.setRenderer(new CustomCombobox());
            }
        }catch (Exception e) {
                e.printStackTrace();
        }
    }

    public String getName(){
        return (String)this.getSelectedItem();
    }

    public int getCode(){
        return Integer.valueOf(list.get(this.getSelectedIndex()));
    }
}
