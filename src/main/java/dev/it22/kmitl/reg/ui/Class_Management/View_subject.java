package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class View_subject {
    private JFrame frame;
    private JButton home;
    private JPanel ICON,setposition,textname_id,combo_teach,obj_page,tableSub;
    private JLabel namesubject,idsubject,teacher;
    private JComboBox group;
    private JTable tablesubject;
    private JScrollPane showdetail_table;
    private String columnNames[] = {"รหัสนักศึกษา","ชื่อนักศึกษา"};

    public View_subject(JFrame frame){
        //ปุ่มรูปบ้าน
        ImageIcon homeIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_home.png").getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
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

        //จัดให้ชิดซ้าย
        setposition = new JPanel();
        setposition.setLayout(new BorderLayout());
        setposition.add(ICON, BorderLayout.WEST);
        setposition.setBackground(null);

        namesubject = new JLabel("sing");
        idsubject = new JLabel("0670975");
        teacher = new JLabel("peter");

        //เปลี่ยนฟอนและสีข้อความ
        namesubject.setFont(Config.HEADER_SEMIBOLD[2]);
        namesubject.setForeground(Color.WHITE);
        idsubject.setFont(Config.HEADER_SEMIBOLD[2]);
        idsubject.setForeground(Color.WHITE);
        teacher.setFont(Config.HEADER_SEMIBOLD[2]);
        teacher.setForeground(Color.WHITE);

        group = new JComboBox<>();
        group.addItem("กลุ่มเรียน");
        group.setFont(Config.HEADER_SEMIBOLD[2]);

        //รวมชื่อและรหัสวิชาไว้ด้วยกัน
        textname_id = new JPanel();
        textname_id.setLayout(new FlowLayout());
        textname_id.add(idsubject);
        textname_id.add(namesubject);
        textname_id.setBackground(null);

        //รวมกลุ่มเรียนและผู้สอนไว้บรรทัดเดียวกัน
        combo_teach = new JPanel();
        combo_teach.setLayout(new FlowLayout());
        combo_teach.add(group);
        combo_teach.add(teacher);
        combo_teach.setBackground(null);

        //tablesubject
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        tablesubject = new JTable(model);
        JTableHeader header = tablesubject.getTableHeader();
        tablesubject.setRowHeight(30);
        header.setFont(Config.HEADER_SEMIBOLD[2]);

        tablesubject.getTableHeader().setReorderingAllowed(false);
        tablesubject.getTableHeader().setResizingAllowed(false);

        for (int i = 0; i < tablesubject.getColumnCount(); i++) {
            tablesubject.getColumnModel().getColumn(i);
        }
        showdetail_table = new JScrollPane(tablesubject);
        showdetail_table.setPreferredSize(new Dimension(700, 400));
        showdetail_table.setBackground(null);

        //set layout tableSubject
        tableSub = new JPanel();
        tableSub.setLayout(new FlowLayout());
        tableSub.add(showdetail_table);
        tableSub.setBackground(null);

        //รวมองค์ประกอบไว้ในpanelนี้
        obj_page = new JPanel();
        obj_page.setLayout(new BorderLayout());
        obj_page.add(textname_id,BorderLayout.NORTH);
        obj_page.add(combo_teach,BorderLayout.CENTER);
        obj_page.add(tableSub,BorderLayout.SOUTH);
        obj_page.setBackground(null);

        frame.setLayout(new BorderLayout());
        frame.add(setposition,BorderLayout.NORTH);
        frame.add(obj_page,BorderLayout.CENTER);
        frame.setSize(1000,700);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new View_subject(Config.createAndShowGUI());
    }
}
