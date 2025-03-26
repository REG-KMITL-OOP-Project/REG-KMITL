package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import java.awt.*;
import javax.swing.*;

public class student_checkGrade {
    private JFrame frame;
    private JLabel title;
    private JTextField id,name,faculty,major;
    private JComboBox year,semester;
    private RoundedButton checkgrade;
    private JPanel grouptf,grouptc,mixtf_tc,groupinputuse;

    public student_checkGrade(JFrame frame){
        title = new JLabel("ตรวจสอบผลการเรียน");
        id = new JTextField("รหัสนักศึกษา");
        name = new JTextField("ชื่อ-นามสกุล");
        faculty = new JTextField("คณะ");
        major = new JTextField("สาขา");
        semester = new JComboBox();
        semester.addItem("ภาคการศึกษา");
        year = new JComboBox();
        year.addItem("ปีการศึกษา");
        checkgrade = new RoundedButton("ดูผลการเรียน",22);

        //setfront
        title.setFont(Config.HEADER_SEMIBOLD[2]);
        id.setFont(Config.HEADER_SEMIBOLD[2]);
        name.setFont(Config.HEADER_SEMIBOLD[2]);
        faculty.setFont(Config.HEADER_SEMIBOLD[2]);
        major.setFont(Config.HEADER_SEMIBOLD[2]);
        semester.setFont(Config.HEADER_SEMIBOLD[2]);
        year.setFont(Config.HEADER_SEMIBOLD[2]);
        checkgrade.setFont(Config.HEADER_SEMIBOLD[2]);

        //grouptextfield
        grouptf = new JPanel();
        grouptf.setLayout(new FlowLayout());
        grouptf.add(id);
        grouptf.add(name);
        grouptf.add(faculty);
        grouptf.setBackground(null);

        //grouptextfieldwithCombo
        grouptc = new JPanel();
        grouptc.setLayout(new FlowLayout());
        grouptc.add(major);
        grouptc.add(semester);
        grouptc.add(year);
        grouptc.setBackground(null);

        //setlayout
        mixtf_tc = new JPanel();
        mixtf_tc.setLayout(new GridLayout(2,1));
        mixtf_tc.add(grouptf);
        mixtf_tc.add(grouptc);
        mixtf_tc.setBackground(null);

        groupinputuse = new JPanel();
        groupinputuse.setLayout(new BorderLayout());
        groupinputuse.add(title,BorderLayout.NORTH);
        groupinputuse.add(mixtf_tc,BorderLayout.CENTER);
        groupinputuse.add(checkgrade,BorderLayout.SOUTH);
        groupinputuse.setBackground(null);

        frame.add(groupinputuse);
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new student_checkGrade(Config.createAndShowGUI());
    }
}
