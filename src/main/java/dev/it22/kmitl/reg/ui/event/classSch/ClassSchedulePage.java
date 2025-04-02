package dev.it22.kmitl.reg.ui.event.classSch;

import com.formdev.flatlaf.FlatLightLaf;
import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.auth.Student;
import dev.it22.kmitl.reg.ui.event.component.NewHeader;
import dev.it22.kmitl.reg.ui.event.component.SeletedItemCombobox;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.ErrorModal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassSchedulePage implements ActionListener, SeletedItemCombobox {
    private JFrame frame;
    private JPanel pn1 , pn2;

    //user-data
    private Account user;

    //header
    private JPanel headerPanel;

    //body-information
    private JPanel allInfo, testFormat, allchosen, choseYear,choseSem, stdInfo;
    private JLabel ID, name, faculty, branch;
    private JComboBox year, semester;
    private String years[] = {"2568", "2567", "2566"};
    private String semesters[] = {"เทอม 1", "เทอม 2"};
    private Font innerFont, regularFont;
    private String yearItem,semItem,examItem;



    // table
    private ClassScheduleTable table;

    public ClassSchedulePage(JFrame frame) {
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
        stdInfo = new JPanel();

        allInfo.setBackground(null);
        testFormat.setBackground(null);
        allchosen.setBackground(null);
        choseYear.setBackground(null);
        choseSem.setBackground(null);
        stdInfo.setBackground(null);

        regularFont = Config.NORMAL_REGULAR;
        innerFont = regularFont.deriveFont(12f);


//        ID = new JLabel("รหัสนักศึกษา : ");
//        name = new JLabel("ชื่อ : ");
//        faculty = new JLabel("คณะ : ");
//        branch = new JLabel("สาขา : ");

        ID = new JLabel("รหัสนักศึกษา : "+ ((Student) user).getStudentId());
        name = new JLabel("ชื่อ : "+ ((Student) user).getFullName());
        faculty = new JLabel("คณะ : "+ ((Student) user).getFaculty());
        branch = new JLabel("สาขา : "+ ((Student) user).getMajor());

        ID.setForeground(Color.WHITE);
        name.setForeground(Color.WHITE);
        faculty.setForeground(Color.WHITE);
        branch.setForeground(Color.WHITE);

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
        allInfo.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));
        allInfo.add(allchosen, BorderLayout.WEST);
        allInfo.add(stdInfo, BorderLayout.CENTER);


        pn1.setLayout(new BorderLayout());
        pn1.add(allInfo, BorderLayout.NORTH);


        //table
          table = new ClassScheduleTable(frame);
          pn1.add(table, BorderLayout.CENTER);

        frame.setLayout(new BorderLayout());
        headerPanel = new NewHeader("ตารางเรียน", frame, table);
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(pn1, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

//    public static void main(String[] args) {
//        try {
//            new Login("Student01","Student1234").loginWithUsernameAndPassword();
//            new ClassSchedulePage(Config.createAndShowGUI());
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
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
