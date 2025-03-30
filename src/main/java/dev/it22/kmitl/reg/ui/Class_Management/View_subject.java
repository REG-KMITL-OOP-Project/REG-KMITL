package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View_subject implements ActionListener {
    private JFrame frame;
    private JButton home;
    private JPanel ICON,setposition,textname_id,combo_teach,obj_page,tableSub,titel,setstu,alltitle;
    private JLabel namesubject,idsubject,teacher;
    private JComboBox group;
    private RoundedButton addstudent;
    private JTable tablesubject;
    private JScrollPane showdetail_table;
    private String columnNames[] = {"รหัสนักศึกษา","ชื่อนักศึกษา"};

    public View_subject(JFrame frame){
        this.frame = frame;
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
        teacher = new JLabel("ชื่ออาจารย์");

//        teacher = new JLabel(((Prof) user).getFullName()); ชื่ออาจารย์

        addstudent = new RoundedButton("เพิ่มนักศึกษา",22);
        addstudent.addActionListener(this);

        //เปลี่ยนฟอนและสีข้อความ
        addstudent.setFont(Config.HEADER_SEMIBOLD[2]);
        addstudent.setForeground(Color.BLACK);
        addstudent.setBackground(Config.primaryColor_base);
        namesubject.setFont(Config.HEADER_SEMIBOLD[2]);
        namesubject.setForeground(Color.WHITE);
        idsubject.setFont(Config.HEADER_SEMIBOLD[2]);
        idsubject.setForeground(Color.WHITE);
        teacher.setFont(Config.HEADER_SEMIBOLD[2]);
        teacher.setForeground(Color.WHITE);

        setstu = new JPanel(); //น้องบรรทัดข้างล่างนี้ตรงเลข 180 คือขยับตำแหน่งปุ่ม ลองไปปรับให้ตรงกับตารางต่อเอง
        setstu.setLayout(new FlowLayout(FlowLayout.RIGHT,180,0));
        setstu.add(addstudent);
        setstu.setBackground(null);
        setstu.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

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
        combo_teach.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
        combo_teach.add(group);
        combo_teach.add(teacher);
        combo_teach.setBackground(null);

        //รวมtextnameกับcombo
        titel = new JPanel();
        titel.setLayout(new GridLayout(2,1));
        titel.add(textname_id);
        titel.add(combo_teach);
        titel.setBackground(null);

        //tablesubject
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        tablesubject = new JTable(model);
        tablesubject.setRowHeight(30);

        JTableHeader header = tablesubject.getTableHeader();
        header.setFont(Config.HEADER_SEMIBOLD[2]);
        header.setBackground(Config.primaryColor_harder);
        header.setForeground(Color.WHITE);
        header.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Config.primaryColor_harder));

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
        obj_page.add(titel,BorderLayout.NORTH);
        obj_page.add(setstu,BorderLayout.CENTER);
        obj_page.add(tableSub,BorderLayout.SOUTH);
        obj_page.setBackground(null);
        obj_page.setBorder(BorderFactory.createEmptyBorder(-10, 0, 5, 0));

        //รวมแถบข้างบนทั้งหมด
        alltitle = new JPanel();
        alltitle.setBackground(null);
        alltitle.setLayout(new BorderLayout());
        alltitle.add(setposition,BorderLayout.NORTH);
        alltitle.add(obj_page,BorderLayout.CENTER);

        this.frame = frame;
        frame.setLayout(new BorderLayout());
        frame.add(alltitle,BorderLayout.NORTH); //north ใส่แถบข้างบนทั้งหมด
        frame.add(tableSub,BorderLayout.CENTER); //center ใส่ตาราง
        frame.add(setstu,BorderLayout.SOUTH); //south ปุ่มเพิ่มนักศึกษา
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new View_subject(Config.createAndShowGUI());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(addstudent)){
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            //new AdminAddSubject(frame);
        }
    }
}
