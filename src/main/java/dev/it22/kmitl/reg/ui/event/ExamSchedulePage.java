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
    private JPanel allInfo, testFormat, allchosen, blank, choseYear,chosen, stdInfo;
    private JLabel ID, name, faculty, branch;
    private JComboBox year, semester, exam ;

    //body-schedule
    private  JTable examSchedule;
    private JScrollPane scrollPane;
    private JPanel blank2,blank3;

    private String years[] = {"2568", "2567", "2566"};
    private String semesters[] = {"1", "2"};
    private String exams[] = {"Midterm","Final"};
    private String columnNames[] = {"DD/MM/YY","time", "subject-ID","subject","type","seat","room"};
    private Object testData[][] = {{"DD/MM/YY","09.30-18.00","060111222","OOP","practical","A4","L123"}};


    public ExamSchedulePage(JFrame frame){
        this.frame = frame;
        pn1 = new JPanel();
        pn2 = new JPanel();

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

        //body-information
        allInfo = new JPanel();
        testFormat = new JPanel();
        allchosen = new JPanel();
        blank = new JPanel();
        choseYear = new JPanel();
        chosen = new JPanel();
        stdInfo = new JPanel();

        ID = new JLabel("Student ID : ");
        name = new JLabel("Name : ");
        faculty = new JLabel("Faculty : ");
        branch = new JLabel("Branch : ");

        year = new JComboBox(years);
        semester = new JComboBox(semesters);
        exam = new JComboBox(exams);

        //place components
        //head
        //head-menubar
        bar.add(home);
        bar.add(ETC);
        bar.add(tarangsob);
        ETC.add(examSche);
        ETC.add(expand);
        ETC.add(savePDF);
        ETC.add(saveJPG);
        ETC.add(share);

        //body-schedule
        blank2 = new JPanel();
        blank3 = new JPanel();
        DefaultTableModel model = new DefaultTableModel(testData, columnNames);
        examSchedule = new JTable(model);
        scrollPane = new JScrollPane(examSchedule);

        //panel-year button
        choseYear.setBackground(null);
        choseYear.setLayout(new GridLayout(1, 1));
        choseYear.add(year);

        //panel-semester and exam button
        chosen.setBackground(null);
        chosen.setLayout(new GridLayout(1, 2));
        chosen.add(semester);
        chosen.add(exam);

        //panel-studentInfo
        stdInfo.setLayout(new GridLayout(2, 2));
        stdInfo.add(ID);
        stdInfo.add(name);
        stdInfo.add(faculty);
        stdInfo.add(branch);

        allInfo.setLayout(new BorderLayout());
        testFormat.setLayout(new GridLayout(2, 1));
        allchosen.setLayout(new BorderLayout());

        //layout-all semester year exam button
        testFormat.add(choseYear);
        testFormat.add(chosen);
        allchosen.add(blank, BorderLayout.WEST);
        allchosen.add(testFormat, BorderLayout.CENTER);

        allInfo.add(allchosen, BorderLayout.WEST);
        allInfo.add(stdInfo, BorderLayout.CENTER);

        pn1.setLayout(new BorderLayout());
        //pn1.add(head, BorderLayout.NORTH);
        pn1.add(allInfo, BorderLayout.SOUTH);

        pn2.setLayout(new BorderLayout());
        pn2.add(blank2, BorderLayout.WEST);
        pn2.add(blank3, BorderLayout.EAST);
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
