package dev.it22.kmitl.reg.ui.event;
import dev.it22.kmitl.reg.utils.Config;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ExamSchedulePage {
    private JFrame frame;
           //Attribute ที่สร้างในคลาส
    private JPanel pn1 , pn2;

    //head-menubar
    private JMenuBar bar;
    private JMenu ETC;
    private JMenuItem savePDF, expand,saveJPG, share;
    private JLabel examSche;
    private JLabel tarangsob;
    private JButton home;

    //body-information
    private JPanel allInfo, testFormat, allchosen, choseYear,choseSem,choseExam, stdInfo;
    private JLabel ID, name, faculty, branch;
    private JComboBox year, semester, exam ;

    //body-schedule
    private JTable examSchedule;
    private JScrollPane scrollPane;

    private String years[] = {"2568", "2567", "2566"};
    private String semesters[] = {"Semester 1", "Semester 2"};
    private String exams[] = {"Midterm","Final"};
    private String columnNames[] = {"DD/MM/YY","time", "subject-ID","subject","type","seat","room"};
    private Object testData[][] = {{"DD/MM/YY","09.30-18.00","060111222","OOP","practical","A4","L123"},
            {"DD/MM/YY","09.30-18.00","060111222","OOP","practical","A4","L123"},
            {"DD/MM/YY","09.30-18.00","060111222","OOP","practical","A4","L123"},
            {"DD/MM/YY","09.30-18.00","060111222","OOP","practical","A4","L123"}};


    public ExamSchedulePage(JFrame frame){
        this.frame = frame;
        pn1 = new JPanel();
        pn2 = new JPanel();

        pn1.setBackground(null);
        pn2.setBackground(null);


        //head-menubar
        bar = new JMenuBar();
        ETC = new JMenu("ETC");
        expand = new JMenuItem("Expand");
        savePDF = new JMenuItem("Save PDF");
        saveJPG = new JMenuItem("Save JPG");
        share = new JMenuItem("Share");
        examSche = new JLabel("Exam Schedule");
        tarangsob = new JLabel("Exam Schedule");
        home = new JButton("Home");

        tarangsob.setForeground(Config.primaryColor_base);
        tarangsob.setFont(Config.HEADER_SEMIBOLD[1]);;

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


        ID = new JLabel("Student ID : ");
        name = new JLabel("Name : ");
        faculty = new JLabel("Faculty : ");
        branch = new JLabel("Branch : ");

        ID.setForeground(Color.WHITE);
        name.setForeground(Color.WHITE);
        faculty.setForeground(Color.WHITE);
        branch.setForeground(Color.WHITE);


        year = new JComboBox(years);
        semester = new JComboBox(semesters);
        exam = new JComboBox(exams);

        //place components
        //head
        //head-menubar
        bar.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        bar.add(home);
        bar.add(ETC);
        bar.add(tarangsob);
        ETC.add(examSche);
        ETC.add(expand);
        ETC.add(savePDF);
        ETC.add(saveJPG);
        ETC.add(share);

        //body-schedule
        DefaultTableModel model = new DefaultTableModel(testData, columnNames);
        examSchedule = new JTable(model);
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
