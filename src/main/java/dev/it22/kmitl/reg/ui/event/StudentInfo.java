package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;

public class StudentInfo extends JPanel{
    //private JPanel stdInfo;
    private JLabel ID, name, faculty, branch;

    public StudentInfo() {
        this("670xxxxxx", "Peter the cockroach", "Information", "Outformation");
    }

    public StudentInfo(String stdId, String stdName, String stdFaculty, String stdBranch) {
        this.setBackground(null);

        ID = new JLabel("Student ID : " + stdId);
        name = new JLabel("Name : " + stdName);
        faculty = new JLabel("Faculty : " + stdFaculty);
        branch = new JLabel("Branch : " + stdBranch);

        ID.setForeground(Color.WHITE);
        name.setForeground(Color.WHITE);
        faculty.setForeground(Color.WHITE);
        branch.setForeground(Color.WHITE);

        this.setLayout(new GridLayout(2, 2));
        this.add(ID);
        this.add(name);
        this.add(faculty);
        this.add(branch);
        this.setBackground(Config.bgColor_base.darker());
        this.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
    }
}
