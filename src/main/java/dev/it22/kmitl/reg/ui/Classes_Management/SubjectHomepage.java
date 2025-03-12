package dev.it22.kmitl.reg.ui.Classes_Management;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public  class SubjectHomepage {
    private JFrame frame;
    private RoundedButton addclass,addtime,addsubjec;
    private JPanel top,low,box,group1,group2;
    private JComboBox Faculty,Semester;
    private JTable table;
    private JScrollPane showdetail_Subject;
    private String columnNames[] = {"รหัสวิชา","ชื่อวิชา", "กลุ่มเรียน","ห้องเรียน","อาจารย์ผู้สอน","เงื่อนไข","หมายเหตุ","วันสอบ","รับ"};

    public SubjectHomepage(JFrame frame){
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

        top = new JPanel();
        top.add(addsubjec);
        top.add(addtime);
        top.add(addclass);
        top.setLayout(new FlowLayout());
        top.setBackground(null);

        Faculty = new JComboBox();
        Faculty.addItem("คณะ");
        Faculty.setFont(Config.HEADER_SEMIBOLD[2]);

        Semester = new JComboBox();
        Semester.addItem("ภาคการศึกษา");
        Semester.setFont(Config.HEADER_SEMIBOLD[2]);

        low = new JPanel();
        low.add(Faculty);
        low.add(Semester);
        low.setLayout(new FlowLayout());
        low.setBackground(null);

        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        table = new JTable(model);
        JTableHeader header = table.getTableHeader();
        table.setRowHeight(30);
        header.setFont(Config.HEADER_SEMIBOLD[2]);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i);
        }


        showdetail_Subject = new JScrollPane(table);
        showdetail_Subject.setPreferredSize(new Dimension(1000, 400));
        showdetail_Subject.setBackground(null);


        box = new JPanel();
        box.add(showdetail_Subject);
        box.setBackground(null);

        frame.setLayout(new BorderLayout());
        group1 = new JPanel();
        group1.setLayout(new GridLayout(2,1));
        group1.add(top);
        group1.add(low);
        group1.setBackground(null);

        frame.add(group1, BorderLayout.NORTH);
        frame.add(box, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new SubjectHomepage(Config.createAndShowGUI());
    }
}
