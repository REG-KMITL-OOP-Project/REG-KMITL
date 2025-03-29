package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class student_checkGrade {
    private JFrame frame;
    private JLabel title;
    private JTextField id,name,faculty,major;
    private JComboBox year,semester;
    private RoundedButton checkgrade;
    private JButton home;
    private JPanel grouptf,grouptc,mixtf_tc,center,south,groupinputuse,table,group_obj,ICON,setposition;
    private JTable tablescore;
    private JScrollPane showdetail_Subject;
    private String columnNames[] = {"รหัสวิชา","ชื่อวิชา","1","2","3","4"};

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

        //Icon home
        ImageIcon homeIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_home.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
        home = new JButton(homeIcon);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setFocusPainted(false);

        ImageIcon logo = new ImageIcon(new ImageIcon("source/Logo.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
        JLabel regLabel = new JLabel(logo);
        ICON = new JPanel();
        ICON.setLayout(new FlowLayout());
        ICON.add(home);
        ICON.add(regLabel);
        ICON.setBackground(null);

        //SETPOSITION HOME BUTTON
        setposition = new JPanel();
        setposition.setLayout(new BorderLayout());
        setposition.add(ICON, BorderLayout.WEST);
        setposition.setBackground(null);

        //setfront
        title.setFont(Config.HEADER_SEMIBOLD[2]);
        title.setForeground(Color.WHITE);
        id.setFont(Config.HEADER_SEMIBOLD[2]);
        name.setFont(Config.HEADER_SEMIBOLD[2]);
        faculty.setFont(Config.HEADER_SEMIBOLD[2]);
        major.setFont(Config.HEADER_SEMIBOLD[2]);
        semester.setFont(Config.HEADER_SEMIBOLD[2]);
        year.setFont(Config.HEADER_SEMIBOLD[2]);
        checkgrade.setFont(Config.HEADER_SEMIBOLD[2]);

        checkgrade.setForeground(Color.BLACK);
        checkgrade.setBackground(Config.primaryColor_base);

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

        //setposition title
        center = new JPanel();
        center.setLayout(new FlowLayout());
        center.add(title);
        center.setBackground(null);

        //setposition checkgrade
        south = new JPanel();
        south.setLayout(new FlowLayout());
        south.add(checkgrade);
        south.setBackground(null);

        //setlayout
        mixtf_tc = new JPanel();
        mixtf_tc.setLayout(new GridLayout(2,1));
        mixtf_tc.add(grouptf);
        mixtf_tc.add(grouptc);
        mixtf_tc.setBackground(null);

        groupinputuse = new JPanel();
        groupinputuse.setLayout(new BorderLayout());
        groupinputuse.add(center,BorderLayout.NORTH);
        groupinputuse.add(mixtf_tc,BorderLayout.CENTER);
        groupinputuse.add(south,BorderLayout.SOUTH);
        groupinputuse.setBackground(null);

        //tablescore
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        tablescore = new JTable(model);
        JTableHeader header = tablescore.getTableHeader();
        tablescore.setRowHeight(30);
        header.setFont(Config.HEADER_SEMIBOLD[2]);

        tablescore.getTableHeader().setReorderingAllowed(false);
        tablescore.getTableHeader().setResizingAllowed(false);

        for (int i = 0; i < tablescore.getColumnCount(); i++) {
            tablescore.getColumnModel().getColumn(i);
        }
        showdetail_Subject = new JScrollPane(tablescore);
        showdetail_Subject.setPreferredSize(new Dimension(700, 400));
        showdetail_Subject.setBackground(null);

        //set layout table
        table = new JPanel();
        table.setLayout(new FlowLayout());
        table.add(showdetail_Subject);
        table.setBackground(null);

        //group obj in page
        group_obj = new JPanel();
        group_obj.setLayout(new BorderLayout());
        group_obj.add(groupinputuse,BorderLayout.CENTER);
        group_obj.add(table,BorderLayout.SOUTH);
        group_obj.setBackground(null);

        frame.setLayout(new BorderLayout());
        frame.add(setposition, BorderLayout.NORTH);
        frame.add(group_obj,BorderLayout.CENTER);
        frame.setSize(1000,700);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new student_checkGrade(Config.createAndShowGUI());
    }
}
