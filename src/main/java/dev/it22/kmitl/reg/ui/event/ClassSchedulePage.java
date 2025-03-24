package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;

public class ClassSchedulePage{
    private JFrame frame;
    private JPanel pn1 , pn2;

    //user-data
    //private Account user;

    //head-menubar
    private headerMenu header;

    //body-information
    private JPanel allInfo, testFormat, allchosen, choseYear,choseSem,choseExam, stdInfo;
    private JLabel ID, name, faculty, branch;
    private JComboBox year, semester, exam ;
    private String years[] = {"2568", "2567", "2566"};
    private String semesters[] = {"เทอม 1", "เทอม 2"};

    // table
    private ClassScheduleTable table;

    public ClassSchedulePage(JFrame frame) {
        this.frame = frame;
        pn1 = new JPanel();
        pn2 = new JPanel();

        pn1.setBackground(null);
        pn2.setBackground(null);

        //data
        //user = new User().getUserAccount();

        //body-information
        allInfo = new JPanel();
        testFormat = new JPanel();
        allchosen = new JPanel();

        choseYear = new JPanel();
        choseSem = new JPanel();
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

        //ID = new JLabel("รหัสนักศึกษา : "+ ((Student) user).getStudentId());
        //name = new JLabel("ชื่อ : "+ ((Student) user).getFullName());
        //faculty = new JLabel("คณะ : "+ ((Student) user).getFaculty());
        //branch = new JLabel("สาขา : "+ ((Student) user).getMajor());

        ID.setForeground(Color.WHITE);
        name.setForeground(Color.WHITE);
        faculty.setForeground(Color.WHITE);
        branch.setForeground(Color.WHITE);

        year = new JComboBox(years);
        semester = new JComboBox(semesters);

        //change font in combobox
        JComboBox<String> semester = new JComboBox<>(semesters);
        semester.setFont(Config.NORMAL_REGULAR);


        //panel-year
        choseYear.setPreferredSize(new Dimension(100, 35));
        choseYear.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        choseYear.setLayout(new GridLayout(1, 1));
        choseYear.add(year);

        //panel-semester
        choseSem.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        choseSem.setLayout(new GridLayout(1, 1));
        choseSem.add(semester);


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
        testFormat.setLayout(new GridLayout(1, 1));
        allchosen.setLayout(new GridLayout(2, 1));

        //layout-all semester year exam button
        testFormat.add(choseSem);
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
        pn1.setBorder(BorderFactory.createEmptyBorder(5, 5, 40, 5));

        //table
          table = new ClassScheduleTable();


        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(new headerMenu("ตารางเรียน", frame, table));
        frame.add(pn1, BorderLayout.NORTH);

        frame.add(table, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
            new ClassSchedulePage(Config.createAndShowGUI());
    }


}
