package dev.it22.kmitl.reg.ui.event.examSch;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.*;
import dev.it22.kmitl.reg.ui.event.component.newHeader;
import dev.it22.kmitl.reg.ui.event.component.seletedItemCombobox;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.ErrorModal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TeacherExamSchedulePage implements ActionListener, seletedItemCombobox {
    private JFrame frame;
    private JPanel pn1 ;

    //user-data
    private Account user;

    //header
    private JPanel headerPanel;

    //body-information
    private JPanel allInfo, testFormat, allchosen, choseYear,choseSem,choseExam, profInfo;
    private JLabel ID, name;
    private JComboBox year, semester, exam ;

    // table
    private ExamScheduleTable table;

    private String years[] = {"2568", "2567", "2566"};
    private String semesters[] = {"เทอม 1", "เทอม 2"};
    private String exams[] = {"กลางภาค","ปลายภาค"};
    private Font innerFont, regularFont;
    private String yearItem,semItem,examItem;



    public TeacherExamSchedulePage(JFrame frame){
        this.frame = frame;
        pn1 = new JPanel();
        pn1.setBackground(null);


        //data
        user = new User().getUserAccount();

        //body-information
        allInfo = new JPanel();
        testFormat = new JPanel();
        allchosen = new JPanel();

        choseYear = new JPanel();
        choseSem= new JPanel();
        choseExam = new JPanel();
        profInfo = new JPanel();

        allInfo.setBackground(null);
        testFormat.setBackground(null);
        allchosen.setBackground(null);
        choseYear.setBackground(null);
        choseSem.setBackground(null);
        choseExam.setBackground(null);
        profInfo.setBackground(null);

        regularFont = Config.NORMAL_REGULAR;
        innerFont = regularFont.deriveFont(12f);

//        ID = new JLabel("รหัส : ");
//        name = new JLabel("ชื่อ : ");


        ID = new JLabel("รหัส : "+ ((Prof) user).getProf_id());
        name = new JLabel("ชื่อ : "+ ((Prof) user).getFullName());


        ID.setForeground(Color.WHITE);
        name.setForeground(Color.WHITE);


        year = new JComboBox(years);
        semester = new JComboBox(semesters);
        exam = new JComboBox(exams);

        //change font in combobox
        semester.setFont(innerFont);
        exam.setFont(innerFont);


        //body-schedule
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

        year.addActionListener(this);
        semester.addActionListener(this);
        exam.addActionListener(this);

        //panel-studentInfo
        profInfo.setLayout(new GridLayout(1, 2));

        ID.setFont(Config.HEADER_SEMIBOLD[3]);
        name.setFont(Config.HEADER_SEMIBOLD[3]);


        profInfo.add(ID);
        profInfo.add(name);


        allInfo.setLayout(new BorderLayout());
        testFormat.setLayout(new GridLayout(1, 2));
        allchosen.setLayout(new GridLayout(2, 1));

        //layout-all semester year exam button
        testFormat.add(choseSem);
        testFormat.add(choseExam);
        allchosen.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        allchosen.add(choseYear);
        allchosen.add(testFormat);

        profInfo.setBackground(Config.bgColor_base.darker());
        profInfo.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        allInfo.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));
        allInfo.add(allchosen, BorderLayout.WEST);
        allInfo.add(profInfo, BorderLayout.CENTER);

        pn1.setLayout(new BorderLayout());
        pn1.add(allInfo, BorderLayout.NORTH);

        //table
        table = new ExamScheduleTable(frame);
        pn1.add(table, BorderLayout.CENTER);

        frame.setLayout(new BorderLayout());
        headerPanel = new newHeader("ตารางคุมสอบ", frame, table);
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(pn1, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            new Login("Prof01","Prof1234").loginWithUsernameAndPassword();
            new TeacherExamSchedulePage(Config.createAndShowGUI());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == year){
            yearItem = selectedItem(year);
            if (year.getSelectedIndex() != 0){
                new ErrorModal(frame, "ขออภัย ยังไม่มีข้อมูลในขณะนี้");
                year.setSelectedIndex(0);
            }
        }
        if (e.getSource() == semester){
            semItem = selectedItem(semester);
            if (semester.getSelectedIndex() != 0){
                new ErrorModal(frame, "ขออภัย ยังไม่มีข้อมูลในขณะนี้");
                semester.setSelectedIndex(0);
            }
        }
        if (e.getSource() == exam){
            examItem = selectedItem(exam);
            if (exam.getSelectedIndex() != 0){
                new ErrorModal(frame, "ขออภัย ยังไม่มีข้อมูลในขณะนี้");
                exam.setSelectedIndex(0);
            }
        }
    }

    @Override
    public String selectedItem(JComboBox comboBox){
        String selectedItem = (String) comboBox.getSelectedItem();
        return selectedItem;
    }

    @Override
    public String getYearItem() {
        return yearItem;
    }

    @Override
    public String getSemItem(){
        return semItem;
    }

    @Override
    public String getExamItem() {
        return examItem;
    }
}
