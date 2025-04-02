package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.controller.score.ScoreDatabase;
import dev.it22.kmitl.reg.controller.subject.Subject;
import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.Database;
import dev.it22.kmitl.reg.utils.ErrorModal;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_subject implements ActionListener {
    private JFrame frame;
    private JButton home;
    private JPanel ICON,setposition,textname_id,combo_teach,obj_page,tableSub,titel,setstu,alltitle,buttonpanel;
    private JLabel namesubject,idsubject,teacher;
    private JComboBox group;
    private RoundedButton addstudent,back;
    private JTable tablesubject;
    private JScrollPane showdetail_table;
    private String columnNames[] = {"รหัสนักศึกษา","ชื่อนักศึกษา"};
    private String courseCode,courseName, teacherName;
    private ResultSet subjectRs;
    private DefaultTableModel model = new DefaultTableModel(null, columnNames);

    public View_subject(JFrame frame, String course_code, String course_name, String teacherName) {
        this.frame = frame;
        this.courseCode = course_code;
        this.courseName = course_name;
        this.teacherName = teacherName;

        //first call


        //ปุ่มรูปบ้าน
        ImageIcon homeIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_home.png").getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
        home = new JButton(homeIcon);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setFocusPainted(false);
        home.addActionListener(e ->{
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new HomePage(frame);
        });

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

        namesubject = new JLabel(course_name);
        idsubject = new JLabel(course_code);
        teacher = new JLabel("อาจารย์ : " + teacherName);

//        teacher = new JLabel(((Prof) user).getFullName()); ชื่ออาจารย์

        addstudent = new RoundedButton("เพิ่มนักศึกษา",22);
        addstudent.addActionListener(this);

        back = new RoundedButton("<--",22);
        back.addActionListener(this);

        //เปลี่ยนฟอนและสีข้อความ
        back.setFont(Config.HEADER_SEMIBOLD[2]);
        back.setForeground(Color.BLACK);
        back.setBackground(Config.primaryColor_base);
        addstudent.setFont(Config.HEADER_SEMIBOLD[2]);
        addstudent.setForeground(Color.BLACK);
        addstudent.setBackground(Config.primaryColor_base);
        namesubject.setFont(Config.HEADER_SEMIBOLD[2]);
        namesubject.setForeground(Color.WHITE);
        idsubject.setFont(Config.HEADER_SEMIBOLD[2]);
        idsubject.setForeground(Color.WHITE);
        teacher.setFont(Config.HEADER_SEMIBOLD[2]);
        teacher.setForeground(Color.WHITE);

        buttonpanel = new JPanel();
        buttonpanel.setLayout(new FlowLayout());
        buttonpanel.add(back);
        buttonpanel.add(addstudent);
        buttonpanel.setBackground(null);

        setstu = new JPanel(); //น้องบรรทัดข้างล่างนี้ตรงเลข 180 คือขยับตำแหน่งปุ่ม ลองไปปรับให้ตรงกับตารางต่อเอง
        setstu.setLayout(new FlowLayout(FlowLayout.RIGHT,180,0));
        setstu.add(buttonpanel);
        setstu.setBackground(null);
        setstu.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        group = new JComboBox<>();
        group.addItem("กลุ่มเรียน");
        group.setFont(Config.HEADER_SEMIBOLD[2]);
        group.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int groupNum = 0;
                DefaultTableModel model = new DefaultTableModel(null, columnNames);
                tablesubject = new JTable(model);
                tablesubject.setRowHeight(30);
                tablesubject.setFont(Config.NORMAL_REGULAR);
                try{
                    groupNum = Integer.valueOf(group.getSelectedItem().toString());
                } catch (Exception ev){
                    new ErrorModal(frame, "กรุณาเลือกกลุ่มเรียน");
                    return;
                }
                try{
                    subjectRs = new Subject().getCourseByIdWithSection(courseCode,groupNum);
                    while (subjectRs.next()) {
                        System.out.println("---");
                        System.out.println("std_id: " + subjectRs.getString("std_id"));
                        ResultSet stdrs = new ScoreDatabase().getStudentData(subjectRs.getString("std_id"));
                        String name = stdrs.getString("fname") + " " + stdrs.getString("lname");
                        model.addRow( new Object[]{
                                subjectRs.getString("std_id"),
                                name
                        });
                    }

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

                    tableSub.removeAll();
                    tableSub.revalidate();
                    tableSub.repaint();
                    tableSub.add(showdetail_table);
                    tableSub.setBackground(null);
                }
                catch (Exception er){
                    new ErrorModal(frame, "ไม่สามารถดึงข้อมูลได้");
                }

            }
        });

        //รวมชื่อและรหัสวิชาไว้ด้วยกัน
        textname_id = new JPanel();
        textname_id.setLayout(new FlowLayout());
        textname_id.add(idsubject);
        textname_id.add(namesubject);
        textname_id.setPreferredSize(new Dimension(frame.getWidth(), 40));
        textname_id.setBackground(null);

        //รวมกลุ่มเรียนและผู้สอนไว้บรรทัดเดียวกัน
        combo_teach = new JPanel();
        combo_teach.setLayout(new BoxLayout(combo_teach, BoxLayout.Y_AXIS));
        Panel panel1 = new Panel();
        panel1.add(group);
        Panel panel2 = new Panel();
        panel2.add(teacher);
        teacher.setAlignmentX(SwingConstants.CENTER);
        combo_teach.add(panel2);
        combo_teach.add(panel1);
        combo_teach.setBackground(null);

        //รวมtextnameกับcombo
        titel = new JPanel();
        titel.setLayout(new BoxLayout(titel, BoxLayout.Y_AXIS));
        titel.add(textname_id);
        titel.add(combo_teach);
        titel.setBackground(null);

        //tablesubject
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        tablesubject = new JTable(model);
        tablesubject.setRowHeight(30);
        tablesubject.setFont(Config.NORMAL_REGULAR);

        try{
            subjectRs = new Subject().getCourseByIdWithSection(courseCode,1);
            while (subjectRs.next()) {
                System.out.println("---");
                System.out.println("std_id: " + subjectRs.getString("std_id"));
                ResultSet stdrs = new ScoreDatabase().getStudentData(subjectRs.getString("std_id"));
                String name = stdrs.getString("fname") + " " + stdrs.getString("lname");
                model.addRow( new Object[]{
                        subjectRs.getString("std_id"),
                        name
                });
            }
        }
        catch (Exception e){
            new ErrorModal(frame, "ไม่สามารถดึงข้อมูลได้");
        }

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

        try {
            ResultSet rs = new Database().getQuery("SELECT * FROM section WHERE course_id = '" + course_code + "';");
            while (rs.next()) {
                group.addItem(rs.getString("section"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        this.frame = frame;
        frame.setLayout(new BorderLayout());
        frame.add(alltitle,BorderLayout.NORTH); //north ใส่แถบข้างบนทั้งหมด
        frame.add(tableSub,BorderLayout.CENTER); //center ใส่ตาราง
        frame.add(setstu,BorderLayout.SOUTH); //south ปุ่มเพิ่มนักศึกษา
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame frame = new Config().createAndShowGUI();
        new View_subject(frame,"06016408","dawdwadwa","dawdwadwa");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(addstudent)){
            int groupNum = 0;
            try{
                groupNum = Integer.valueOf(group.getSelectedItem().toString());
            } catch (Exception ev){
                new ErrorModal(frame, "กรุณาเลือกกลุ่มเรียน");
                return;
            }
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new addStudent(frame, courseCode,courseName,teacherName, groupNum);
        } else if (e.getSource().equals(back)) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new create_class(frame);
        }
    }
}
