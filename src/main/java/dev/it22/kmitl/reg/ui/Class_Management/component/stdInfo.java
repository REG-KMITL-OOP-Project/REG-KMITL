package dev.it22.kmitl.reg.ui.Class_Management.component;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.auth.Student;
import dev.it22.kmitl.reg.ui.Class_Management.TeacherAddScore;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class stdInfo extends JPanel{
    private static JLabel ID, name, faculty, branch;
    private Account user;
    private static ResultSet subject_data;
    private static ResultSet student_data;

    public static void setStudentData(ResultSet student_data) {
        stdInfo.student_data = student_data;
    }

    public stdInfo(){

        ID = new JLabel("รหัสนักศึกษา : ");
        name = new JLabel("ชื่อ : ");
        faculty = new JLabel("คณะ : ");
        branch = new JLabel("สาขา : ");

        if(stdInfo.student_data != null){
            try {
                ID = new JLabel("รหัสนักศึกษา : " + student_data.getString("std_id"));
                name = new JLabel("ชื่อ : " + student_data.getString("fname") + " " + student_data.getString("lname"));
                faculty = new JLabel("คณะ : " + student_data.getString("faculty"));
                branch = new JLabel("สาขา : " + student_data.getString("major"));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        ID.setForeground(Color.WHITE);
        name.setForeground(Color.WHITE);
        faculty.setForeground(Color.WHITE);
        branch.setForeground(Color.WHITE);

        ID.setFont(Config.HEADER_SEMIBOLD[3]);
        name.setFont(Config.HEADER_SEMIBOLD[3]);
        faculty.setFont(Config.HEADER_SEMIBOLD[3]);
        branch.setFont(Config.HEADER_SEMIBOLD[3]);

        this.setLayout(new GridLayout(2,2));
        this.setBackground(null);
        this.add(name);
        this.add(ID);
        this.add(faculty);
        this.add(branch);
    }
    public static void setInfo(){
        try {
            stdInfo.ID.setText("รหัสนักศึกษา : " + student_data.getString("std_id"));
            stdInfo.name.setText("ชื่อ : " + student_data.getString("fname") + " " + student_data.getString("lname"));
            stdInfo.faculty.setText("คณะ : " + student_data.getString("faculty"));
            stdInfo.branch.setText("สาขา : " + student_data.getString("major"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
