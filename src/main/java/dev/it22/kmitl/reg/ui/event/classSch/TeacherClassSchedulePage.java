package dev.it22.kmitl.reg.ui.event.classSch;

import com.formdev.flatlaf.FlatLightLaf;
import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.auth.Prof;
import dev.it22.kmitl.reg.ui.event.component.newHeader;
import dev.it22.kmitl.reg.ui.event.component.seletedItemCombobox;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherClassSchedulePage implements ActionListener, seletedItemCombobox {
    private JFrame frame;
    private JPanel pn1 , pn2;

    //user-data
    private Account user;

    //header
    private JPanel headerPanel;

    //body-information
    private JPanel allInfo, testFormat, allchosen, choseYear,choseSem,choseExam, ProfInfo;
    private JLabel ID, name;
    private JComboBox year, semester, exam ;
    private String years[] = {"2568", "2567", "2566"};
    private String semesters[] = {"เทอม 1", "เทอม 2"};
    private Font innerFont, regularFont;
    private String yearItem,semItem,examItem;



    // table
    private ClassScheduleTable table;

    public TeacherClassSchedulePage(JFrame frame) {
        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e){
            e.printStackTrace();
        }
        this.frame = frame;
        pn1 = new JPanel();
        pn2 = new JPanel();

        pn1.setBackground(null);
        pn2.setBackground(null);

        //data
        user = new User().getUserAccount();

        //body-information
        allInfo = new JPanel();
        testFormat = new JPanel();
        allchosen = new JPanel();

        choseYear = new JPanel();
        choseSem = new JPanel();
        choseExam = new JPanel();
        ProfInfo = new JPanel();

        allInfo.setBackground(null);
        testFormat.setBackground(null);
        allchosen.setBackground(null);
        choseYear.setBackground(null);
        choseSem.setBackground(null);
        choseExam.setBackground(null);
        ProfInfo.setBackground(null);

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

        //change font in combobox
        semester.setFont(innerFont);


        //panel-year
        choseYear.setPreferredSize(new Dimension(100, 35));
        choseYear.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        choseYear.setLayout(new GridLayout(1, 1));
        choseYear.add(year);
        year.addActionListener(this);

        //panel-semester
        choseSem.setLayout(new GridLayout(1, 1));
        choseSem.add(semester);
        semester.addActionListener(this);


        //panel-studentInfo
        ProfInfo.setLayout(new GridLayout(1, 2));

        ID.setFont(Config.HEADER_SEMIBOLD[3]);
        name.setFont(Config.HEADER_SEMIBOLD[3]);


        ProfInfo.add(ID);
        ProfInfo.add(name);


        allInfo.setLayout(new BorderLayout());
        testFormat.setLayout(new GridLayout(1, 1));
        allchosen.setLayout(new GridLayout(2, 1));

        //layout-all semester year exam button
        testFormat.add(choseSem);
        allchosen.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        allchosen.add(choseYear);
        allchosen.add(testFormat);

        ProfInfo.setBackground(Config.bgColor_base.darker());
        ProfInfo.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        allInfo.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));
        allInfo.add(allchosen, BorderLayout.WEST);
        allInfo.add(ProfInfo, BorderLayout.CENTER);


        pn1.setLayout(new BorderLayout());
        pn1.add(allInfo, BorderLayout.NORTH);


        //table
        table = new ClassScheduleTable(frame);
        pn1.add(table, BorderLayout.CENTER);

        frame.setLayout(new BorderLayout());
        headerPanel = new newHeader("ตารางสอน", frame, table);
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(pn1, BorderLayout.CENTER);


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        try {
            new Login("Prof01","Prof1234").loginWithUsernameAndPassword();
            new TeacherClassSchedulePage(Config.createAndShowGUI());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == year){
            yearItem = selectedItem(year);
        }
        if (e.getSource() == semester){
            semItem = selectedItem(semester);
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
        return null;
    }
}
