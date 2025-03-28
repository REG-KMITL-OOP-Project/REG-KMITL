package dev.it22.kmitl.reg.ui.Classes_Management;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public  class SubjectHomepage {
    private JFrame frame;
    private JButton home;
    private JLabel regLabel;
    private RoundedButton addclass,addtime,addsubjec;
    private JPanel botton,combobox,tablesubject,ICON,groupbotton_box,setposition;
    private JComboBox Faculty,Semester;
    private JTable table;
    private JScrollPane showdetail_Subject;
    private String columnNames[] = {"รหัสวิชา","ชื่อวิชา", "กลุ่มเรียน","ห้องเรียน","อาจารย์ผู้สอน","เงื่อนไข","หมายเหตุ","วันสอบ","รับ"};

    public SubjectHomepage(JFrame frame){
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

        this.frame = frame;
        addsubjec = new RoundedButton("เพิ่ม-เปลี่ยนวิชา",22);
        addtime = new RoundedButton("เพิ่ม-เปลี่ยนเวลาเรียน",22);
        addclass = new RoundedButton("ชั้นเรียน",22);

        addsubjec.setFont(Config.HEADER_SEMIBOLD[2]);
        addtime.setFont(Config.HEADER_SEMIBOLD[2]);
        addclass.setFont(Config.HEADER_SEMIBOLD[2]);

        addsubjec.setForeground(Color.BLACK);
        addsubjec.setBackground(Config.primaryColor_base);

        addtime.setForeground(Color.BLACK);
        addtime.setBackground(Config.primaryColor_base);

        addclass.setForeground(Color.BLACK);
        addclass.setBackground(Config.primaryColor_base);

        botton = new JPanel();
        botton.add(addsubjec);
        botton.add(addtime);
        botton.add(addclass);
        botton.setLayout(new FlowLayout());
        botton.setBackground(null);

        Faculty = new JComboBox();
        Faculty.addItem("คณะ");
        Faculty.setFont(Config.HEADER_SEMIBOLD[2]);

        Semester = new JComboBox();
        Semester.addItem("ภาคการศึกษา");
        Semester.setFont(Config.HEADER_SEMIBOLD[2]);

        combobox = new JPanel();
        combobox.add(Faculty);
        combobox.add(Semester);
        combobox.setLayout(new FlowLayout());
        combobox.setBackground(null);

        //table//
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        table = new JTable(model);
        JTableHeader header = table.getTableHeader();
        table.setRowHeight(30);
        header.setFont(Config.HEADER_SEMIBOLD[2]);

        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i);
        }

        showdetail_Subject = new JScrollPane(table);
        showdetail_Subject.setPreferredSize(new Dimension(1000, 400));
        showdetail_Subject.setBackground(null);

        setposition = new JPanel();
        setposition.setLayout(new BorderLayout());
        setposition.add(ICON, BorderLayout.WEST);
        setposition.setBackground(null);

        groupbotton_box = new JPanel();
        groupbotton_box.setLayout(new GridLayout(2,1));
        groupbotton_box.add(botton);
        groupbotton_box.add(combobox);
        groupbotton_box.setBackground(null);

        tablesubject = new JPanel(new BorderLayout());
        tablesubject.add(setposition, BorderLayout.NORTH);
        tablesubject.add(groupbotton_box, BorderLayout.CENTER);
        tablesubject.add(showdetail_Subject, BorderLayout.SOUTH);
        tablesubject.setBackground(null);

        frame.add(tablesubject);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new SubjectHomepage(Config.createAndShowGUI());
    }
}