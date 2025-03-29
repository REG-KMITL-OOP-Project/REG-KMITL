package dev.it22.kmitl.reg.ui.Class_Management.component;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.auth.Student;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;

public class stdInfo extends JPanel{
    private JLabel ID, name, faculty, branch;
    private Account user;

    public stdInfo(){
        user = new User().getUserAccount();

        ID = new JLabel("รหัสนักศึกษา : "+ ((Student) user).getStudentId());
        name = new JLabel("ชื่อ : "+ ((Student) user).getFullName());
        faculty = new JLabel("คณะ : "+ ((Student) user).getFaculty());
        branch = new JLabel("สาขา : "+ ((Student) user).getMajor());

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
