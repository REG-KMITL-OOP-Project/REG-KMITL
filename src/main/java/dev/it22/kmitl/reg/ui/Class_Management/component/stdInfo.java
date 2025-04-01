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
    private JLabel ID, name, faculty, branch;
    private Account user;
    private static ResultSet subject_data;
    private static ResultSet student_data;

    public static void setSubject(ResultSet subject) {
        stdInfo.subject_data = subject;

    }
    public static void setStudentData(ResultSet student_data) {
        stdInfo.student_data = student_data;
    }

    public stdInfo(){
        user = new User().getUserAccount();

        ID = new JLabel("รหัสนักศึกษา : ");
        name = new JLabel("ชื่อ : ");
        faculty = new JLabel("คณะ : ");
        branch = new JLabel("สาขา : ");

        if(stdInfo.subject_data != null){
            try {
                ID = new JLabel("รหัสนักศึกษา : " + subject_data.getString("std_id"));
                name = new JLabel("ชื่อ : " + subject_data.getString("fname") + " " + subject_data.getString("lname"));
                faculty = new JLabel("คณะ : " + subject_data.getString("faculty"));
                branch = new JLabel("สาขา : " + subject_data.getString("major"));
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
}
