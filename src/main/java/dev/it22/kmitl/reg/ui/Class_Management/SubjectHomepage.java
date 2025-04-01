package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.model.classroom.CourseData;
import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.utils.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public  class SubjectHomepage implements ActionListener {
    private CourseData course;
    private DefaultTableModel model;
    private JFrame frame;
    private JButton home;
    private JLabel regLabel;
    private RoundedButton addclass,addtime,addsubjec;
    private JPanel botton,combobox,tablesubject,ICON,groupbotton_box,setposition,setlayout;
    private JComboBox Semester;
    private FacultyComboBox Faculty;
    private JTable table;
    private JScrollPane showdetail_Subject;
    private String columnNames[] = {"รหัสวิชา","ชื่อวิชา", "กลุ่มเรียน","ห้องเรียน","อาจารย์ผู้สอน","เงื่อนไข","หมายเหตุ","วันสอบ","รับ"};

    public SubjectHomepage(JFrame frame){
        this.frame = frame;
        ImageIcon homeIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_home.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
        home = new JButton(homeIcon);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setFocusPainted(false);
        home.addActionListener(this);
        ImageIcon logo = new ImageIcon(new ImageIcon("source/Logo.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
        JLabel regLabel = new JLabel(logo);
        ICON = new JPanel();
        ICON.setLayout(new FlowLayout());
        ICON.add(home);
        ICON.add(regLabel);
        ICON.setBackground(null);

        this.frame = frame;
        addsubjec = new RoundedButton("เพิ่มวิชา",22);
        addtime = new RoundedButton("เพิ่มกลุ่มเรียน",22);
        addclass = new RoundedButton("ชั้นเรียน",22);

        addsubjec.addActionListener(this);
        addtime.addActionListener(this);
        addclass.addActionListener(this);

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

        Faculty = new FacultyComboBox("คณะ");
        Faculty.setRenderer(new CustomCombobox(50,35));
        Faculty.setFont(Config.HEADER_SEMIBOLD[2]);
        Faculty.addActionListener(this);

        Semester = new JComboBox();
        Semester.addItem("ภาคการศึกษา");
        try{
            ArrayList<String> semesters = new ArrayList<>();
            ResultSet rs = new Database().getQuery("SELECT * FROM course");
            rs.next();
            Semester.addItem(rs.getString("years"));
            semesters.add(rs.getString("years"));
            while(rs.next()){
                for (int i = 0; i < semesters.size(); i++){
                    if (!semesters.get(i).equals(rs.getString("years"))){
                        semesters.add(rs.getString("years"));
                        Semester.addItem(rs.getString("years"));
                        break;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Semester.setRenderer(new CustomCombobox(115,35));
        Semester.setFont(Config.HEADER_SEMIBOLD[2]);
        Semester.addActionListener(this);

        combobox = new JPanel();
        combobox.add(Faculty);
        combobox.add(Semester);
        combobox.setLayout(new FlowLayout());
        combobox.setBackground(null);

        //table//
        model = new DefaultTableModel(null, columnNames);
        table = new JTable(model);
        JTableHeader header = table.getTableHeader();
        table.setRowHeight(30);
        header.setFont(Config.HEADER_SEMIBOLD[2]);


        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setFont(Config.NORMAL_REGULAR);
        JTextField textFieldEditor = new JTextField();
        textFieldEditor.setFont(Config.NORMAL_REGULAR);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(textFieldEditor));
        }

        showdetail_Subject = new JScrollPane(table);
        showdetail_Subject.setPreferredSize(new Dimension(1000, 400));
        showdetail_Subject.setBackground(null);
        table.setPreferredScrollableViewportSize(new Dimension(300, 300));
        table.setFillsViewportHeight(true);


        setlayout = new JPanel();
        setlayout.setLayout(new FlowLayout());
        setlayout.add(showdetail_Subject);
        setlayout.setBackground(null);

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
        tablesubject.add(groupbotton_box, BorderLayout.CENTER);
        tablesubject.add(setlayout, BorderLayout.SOUTH);
        tablesubject.setBackground(null);

        frame.setLayout(new BorderLayout());
        frame.add(setposition, BorderLayout.NORTH);
        frame.add(tablesubject,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new SubjectHomepage(Config.createAndShowGUI());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(addsubjec)){
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminAddSubject(frame);
        } else if (e.getSource().equals(addtime)) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminAddGroupClass(frame);
        } else if (e.getSource().equals(addclass)) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new create_class(frame);
        } else if (e.getSource().equals(home)) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new HomePage(frame);
        } else if (e.getSource().equals(Faculty) || e.getSource().equals(Semester)) {
            course = new CourseData("SELECT * FROM course WHERE years = '" + Semester.getSelectedItem().toString() + "'AND faculty_id = '" + Faculty.getFacultyCode() + "';");
            try {
                refresh();
            }catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }

    public void refresh(){
        model.setRowCount(0);
        for (int i=0; i < course.getCourseCode().size(); i++) {
            try {
                int count = 0;
                ResultSet rs = new Database().getQuery("SELECT * FROM section WHERE course_id = '" + course.getCourseCode().get(i) + "';");
                while (rs.next()) {
                    ResultSet rs1 = new Database().getQuery("SELECT * FROM exam WHERE section = '" + rs.getString("section") + "' AND course_id = '" + course.getCourseCode().get(i) + "';");
                    rs1.next();
                    if (count == 0) {
                        String newModel[] = {course.getCourseCode().get(i), course.getCourseName().get(i), rs.getString("section"), rs.getString("room"), rs.getString("prof_name"), course.getPrerequisite().get(i), course.getNote().get(i), rs1.getString("midterm_date") + " " + rs1.getString("midterm_start_time") + " - " + rs1.getString("midterm_end_time"), rs.getString("max_std") };
                        System.out.println(newModel);
                        model.addRow(newModel);
                    }else{
                        String newModel[] = {"", "", rs.getString("section"), rs.getString("room"), rs.getString("prof_name"), course.getPrerequisite().get(i), course.getNote().get(i),  rs1.getString("midterm_date") + " " + rs1.getString("midterm_start_time") + " - " + rs1.getString("midterm_end_time"), rs.getString("max_std") };
                        model.addRow(newModel);
                    }
                    count++;
                }
            }catch ( Exception e){
                e.printStackTrace();
            }
        }
    }
}