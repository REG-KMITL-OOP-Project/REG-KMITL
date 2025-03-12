package dev.it22.kmitl.reg.ui.event;
import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.auth.Student;
import dev.it22.kmitl.reg.utils.Config;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class ExamSchedulePage {
    private JFrame frame;
           //Attribute ที่สร้างในคลาส
    private JPanel pn1 , pn2;

    //user-data
    //private Account user;

    //head-menubar
    private JMenuBar bar;
    private JMenu ETC;
    private JMenuItem savePDF, expand,saveJPG, share;
    private JLabel examSche;
    private JLabel tarangsob;
    private JButton home;
    private JPanel exSchPanel ;

    //body-information
    private JPanel allInfo, testFormat, allchosen, choseYear,choseSem,choseExam, stdInfo;
    private JLabel ID, name, faculty, branch;
    private JComboBox year, semester, exam ;

    //body-schedule
    private JTable examSchedule;
    private JScrollPane scrollPane;

    private String years[] = {"2568", "2567", "2566"};
    private String semesters[] = {"เทอม 1", "เทอม 2"};
    private String exams[] = {"กลางภาค","ปลายภาค"};
    private String columnNames[] = {"วัน/เดือน/ปี","เวลา", "รหัสวิชา","วิชา","ประเภท","ห้องสอบ"};
    private Object testData[][] = {{"DD/MM/YY","09.30-18.00","060111222","OOP","ทฤษฎี","L123"},
            {"DD/MM/YY","09.30-18.00","060111222","OOP","ปฏิบัติ","L123"},
            {"DD/MM/YY","09.30-18.00","060111222","OOP","practical","L123"},
            {"DD/MM/YY","09.30-18.00","060111222","OOP","practical","L123"}};


    public ExamSchedulePage(JFrame frame){
        this.frame = frame;
        pn1 = new JPanel();
        pn2 = new JPanel();

        pn1.setBackground(null);
        pn2.setBackground(null);

        //data
        //user = new User().getUserAccount();

        //head-menubar
        exSchPanel = new JPanel();
        bar = new JMenuBar();
        tarangsob = new JLabel("ตารางสอบ");
        tarangsob.setForeground(Config.primaryColor_base);
        tarangsob.setFont(Config.HEADER_SEMIBOLD[1]);

        examSche = new JLabel("  Exam Schedule");
        examSche.setPreferredSize(new Dimension(110, 30));
        examSche.setSize(110, 30);
        examSche.setForeground(Config.primaryColor_base);
        exSchPanel.add(examSche);
        exSchPanel.setBackground(Config.bgColor_base);

        ImageIcon homeIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_home.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
        home = new JButton(homeIcon);

        ETC = new JMenu();
        ImageIcon originalIcon = new ImageIcon("source/icon_schedule/icon_etc.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        ETC.setIcon(scaledIcon);
        ETC.setBackground(Config.bgColor_base);

        ImageIcon expandIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_etc.png").getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH));
        expand = new JMenuItem("Expand", expandIcon);
        expand.setPreferredSize(new Dimension(30,40));
        expand.setBackground(Config.bgColor_base);
        expand.setForeground(Config.primaryColor_base);

        ImageIcon savePDFIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_etc.png").getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH));
        savePDF = new JMenuItem("Save PDF",savePDFIcon);
        savePDF.setPreferredSize(new Dimension(30,40));
        savePDF.setBackground(Config.bgColor_base);
        savePDF.setForeground(Config.primaryColor_base);

        ImageIcon saveJPGIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_etc.png").getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH));
        saveJPG = new JMenuItem("Save JPG",saveJPGIcon);
        saveJPG.setPreferredSize(new Dimension(30,40));
        saveJPG.setBackground(Config.bgColor_base);
        saveJPG.setForeground(Config.primaryColor_base);

        ImageIcon shareIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_etc.png").getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH));
        share = new JMenuItem("Share",shareIcon);
        share.setPreferredSize(new Dimension(30,40));
        share.setBackground(Config.bgColor_base);
        share.setForeground(Config.primaryColor_base);

        //body-information
        allInfo = new JPanel();
        testFormat = new JPanel();
        allchosen = new JPanel();

        choseYear = new JPanel();
        choseSem= new JPanel();
        choseExam = new JPanel();
        stdInfo = new JPanel();

        allInfo.setBackground(null);
        testFormat.setBackground(null);
        allchosen.setBackground(null);
        choseYear.setBackground(null);
        choseSem.setBackground(null);
        choseExam.setBackground(null);
        stdInfo.setBackground(null);

        ID = new JLabel("รหัสนักศึกษา : ");
        name = new JLabel("ชื่อ : ");
        faculty = new JLabel("คณะ : ");
        branch = new JLabel("สาขา : ");

        // ID = new JLabel("รหัสนักศึกษา : "+ ((Student) user).getStudentId());
        //name = new JLabel("ชื่อ : "+ ((Student) user).getFullName());
        //faculty = new JLabel("คณะ : "+ ((Student) user).getFaculty());
        //branch = new JLabel("สาขา : "+ ((Student) user).getMajor());

        ID.setForeground(Color.WHITE);
        name.setForeground(Color.WHITE);
        faculty.setForeground(Color.WHITE);
        branch.setForeground(Color.WHITE);

        year = new JComboBox(years);
        semester = new JComboBox(semesters);
        exam = new JComboBox(exams);

        //change font in combobox
        JComboBox<String> semester = new JComboBox<>(semesters);
        semester.setFont(Config.NORMAL_REGULAR);

        JComboBox<String> exam = new JComboBox<>(exams);
        exam.setFont(Config.NORMAL_REGULAR);


        //place components
        //head
        //head-menubar
        home.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 5));
        ETC.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        tarangsob.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        bar.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));

        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setFocusPainted(false);

        bar.setBackground(Config.bgColor_base);
        bar.setBorderPainted(false);
        bar.add(home);

        ETC.setForeground(Config.primaryColor_base);
        bar.add(ETC);
        bar.add(tarangsob);
        ETC.add(exSchPanel);
        ETC.add(expand);
        ETC.add(savePDF);
        ETC.add(saveJPG);
        ETC.add(share);

        //body-schedule
        //All about JTable
        DefaultTableModel model = new DefaultTableModel(testData, columnNames);
        examSchedule = new JTable(model);
        JTableHeader header = examSchedule.getTableHeader();
        header.setPreferredSize(new Dimension(30,30));
        header.setBackground(Config.primaryColor_hard);
        header.setForeground(Color.WHITE);
        header.setFont(Config.HEADER_SEMIBOLD[3]);
        examSchedule.setRowHeight(30);

        //ปิดไม่ให้แก้ขนาด & เลื่อนตารางไปมา
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);

        //จัดข้อความให้อยู่ตรงกลาง
        DefaultTableCellRenderer Renderer = new DefaultTableCellRenderer();
        Renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < examSchedule.getColumnCount(); i++) {
            examSchedule.getColumnModel().getColumn(i).setCellRenderer(Renderer);
        }

        //เปลี่ยนขนาดช่อง
        TableColumn day = examSchedule.getColumnModel().getColumn(0);
        day.setPreferredWidth(100);

        TableColumn time = examSchedule.getColumnModel().getColumn(1);
        time.setPreferredWidth(100);

        TableColumn id = examSchedule.getColumnModel().getColumn(2);
        id.setPreferredWidth(100);

        TableColumn subject = examSchedule.getColumnModel().getColumn(3);
        subject.setPreferredWidth(200);

        TableColumn examType = examSchedule.getColumnModel().getColumn(4);
        examType.setPreferredWidth(50);

        TableColumn room = examSchedule.getColumnModel().getColumn(5);
        room.setPreferredWidth(50);

        scrollPane = new JScrollPane(examSchedule);
        scrollPane.setBackground(null);
        scrollPane.getViewport().setBackground(null);

        //panel-year button
        choseYear.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        choseYear.setLayout(new GridLayout(1, 1));
        choseYear.add(year);

        //panel-semester
        choseSem.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        choseSem.setLayout(new GridLayout(1, 2));
        choseSem.add(semester);


        //panel-exam button
        choseExam.setLayout(new GridLayout(1, 1));
        choseExam.add(exam);

        //panel-studentInfo
        stdInfo.setLayout(new GridLayout(2, 2));

        ID.setFont(Config.HEADER_SEMIBOLD[3]);
        name.setFont(Config.HEADER_SEMIBOLD[3]);
        faculty.setFont(Config.HEADER_SEMIBOLD[3]);
        branch.setFont(Config.HEADER_SEMIBOLD[3]);

        stdInfo.add(ID);
        stdInfo.add(name);
        stdInfo.add(faculty);
        stdInfo.add(branch);

        allInfo.setLayout(new BorderLayout());
        testFormat.setLayout(new GridLayout(1, 2));
        allchosen.setLayout(new GridLayout(2, 1));

        //layout-all semester year exam button
        testFormat.add(choseSem);
        testFormat.add(choseExam);
        allchosen.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        allchosen.add(choseYear);
        allchosen.add(testFormat);

        stdInfo.setBackground(Config.bgColor_base.darker());
        stdInfo.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        allInfo.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        allInfo.add(allchosen, BorderLayout.WEST);
        allInfo.add(stdInfo, BorderLayout.CENTER);


        pn1.setLayout(new BorderLayout());
        pn1.add(allInfo, BorderLayout.SOUTH);

        pn2.setLayout(new BorderLayout());
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        pn2.add(scrollPane, BorderLayout.CENTER);

        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(bar);
        frame.add(pn1, BorderLayout.NORTH);
        frame.add(pn2,BorderLayout.CENTER);


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
            new ExamSchedulePage(Config.createAndShowGUI());
    }
}
