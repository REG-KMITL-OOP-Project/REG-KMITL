package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.controller.enrollment.EnrollmentController;
import dev.it22.kmitl.reg.ui.Class_Management.component.CallData;
import dev.it22.kmitl.reg.ui.Class_Management.component.StdInfo;
import dev.it22.kmitl.reg.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;

public class AddStudent implements FocusListener, ActionListener {
    private JFrame frame;
    private JLabel title, subjectName, subjectID, teacherName, section;
    private RoundedButtonWithColor cancel, save;
    private static RoundedTextField showName;
    private CallData insertID;
    private Font innerFont, regularFont;
    private JPanel button, subjectInfo, teacherInfo, stdInfo, titlePanel, allInfo,
            panelSave, panelCan, sectionPanel, subjectNamePanel, subjectIDPanel, pane;
    private boolean show;
    private EnrollmentController enrollmentController = new EnrollmentController();
    public static String courseCode, courseName, teacher, studentName;
    private int groupNum;


    private StdInfo s;


    public AddStudent(JFrame frame, String courseCode, String courseName, String teacher, int groupNum) {
        this.frame = frame;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.teacher = teacher;
        this.groupNum = groupNum;
        frame.setLayout(new BorderLayout());
        frame.setBackground(null);

        button = new JPanel();
        subjectInfo = new JPanel();
        teacherInfo = new JPanel();
        stdInfo = new JPanel();
        titlePanel = new JPanel();
        allInfo = new JPanel();
        panelSave = new JPanel();
        panelCan = new JPanel();
        sectionPanel = new JPanel();
        subjectNamePanel = new JPanel();
        subjectIDPanel = new JPanel();
        pane = new JPanel();

        button.setBackground(null);
        subjectInfo.setBackground(null);
        teacherInfo.setBackground(null);
        stdInfo.setBackground(null);
        titlePanel.setBackground(null);
        allInfo.setBackground(null);
        panelSave.setBackground(null);
        panelCan.setBackground(null);
        sectionPanel.setBackground(null);
        subjectNamePanel.setBackground(null);
        subjectIDPanel.setBackground(null);
        pane.setBackground(null);

        title = new JLabel("เพิ่มนักศึกษา");
        subjectName = new JLabel("ชื่อวิชา : "+courseName);
        subjectID = new JLabel("รหัสวิชา : "+courseCode);
        teacherName = new JLabel("อาจารย์ประจำกลุ่มเรียน : " + teacher);
        cancel = new RoundedButtonWithColor("CANCEL", 22, new Color(255, 247, 237), Config.primaryColor_base);
        save = new RoundedButtonWithColor("SAVE", 22, new Color(255, 247, 237), Config.primaryColor_harder);
        insertID = new CallData("กรอกรหัสนักศึกษา", Config.bgColor_hard, Color.WHITE, "แสดงชื่อ", Color.WHITE, Config.primaryColor_base , frame);
        section = new JLabel("กลุ่มเรียนที่ : " + groupNum);
        regularFont = Config.NORMAL_REGULAR;
        innerFont = regularFont.deriveFont(15f);


        //title เพิ่มนักศึกษา
        title.setForeground(Config.primaryColor_hard);
        title.setFont(Config.HEADER_SEMIBOLD[1]);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        titlePanel.add(title);


        //ชื่อวิชา รหัสวิชา กลุ่มเรียน
        subjectInfo.setLayout(new GridLayout(1, 3));
        subjectInfo.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

        subjectName.setFont(Config.HEADER_SEMIBOLD[2]);
        subjectName.setForeground(Color.WHITE);
        subjectNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 110, 0));
        subjectNamePanel.add(subjectName);

        subjectID.setFont(Config.HEADER_SEMIBOLD[2]);
        subjectID.setForeground(Color.WHITE);
        subjectNamePanel.add(subjectID);

        section.setFont(Config.HEADER_SEMIBOLD[2]);
        section.setForeground(Color.WHITE);
        sectionPanel.setLayout(new FlowLayout());
        sectionPanel.add(section);

        subjectInfo.add(subjectNamePanel);
        subjectInfo.add(sectionPanel);

        teacherName.setFont(Config.HEADER_SEMIBOLD[2]);
        teacherName.setForeground(Color.WHITE);
        teacherInfo.setLayout(new FlowLayout(FlowLayout.LEFT, 110, 20));
        teacherInfo.add(teacherName);


        show = true;
        showName = new RoundedTextField(22);
        showName.setEditable(false);
        showName.setBackground(Config.bgColor_hard);
        showName.setFont(Config.HEADER_REGULAR[3]);
        showName.setPreferredSize(new Dimension(470, 40));
        showName.setText("แสดงชื่อนักศึกษา");
        showName.setForeground(Color.GRAY);
        showName.addFocusListener(this);

        insertID.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
        insertID.setInfoSize(250, 40);
        insertID.setButtonSize(100, 40);

        stdInfo.add(insertID);
        stdInfo.add(showName);


        //save and cancel button
        panelCan.setLayout(new FlowLayout(FlowLayout.CENTER, 110, 0));
        cancel.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 2.7), (frame.getHeight() / 4) - 120));
        panelCan.add(cancel);

        panelSave.setLayout(new FlowLayout(FlowLayout.LEFT, 110, 0));
        save.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 2.7), (frame.getHeight() / 4) - 120));
        panelSave.add(save);

        button.add(panelCan);
        button.add(panelSave);
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        allInfo.setLayout(new GridLayout(4, 1));
        allInfo.add(subjectInfo);
        allInfo.add(teacherInfo);
        allInfo.add(stdInfo);
        allInfo.add(button);


        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(allInfo, BorderLayout.CENTER);


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        cancel.addActionListener(this);
        save.addActionListener(this);
    }

//    public static void main(String[] args) {
//        //new addStudent(Config.createAndShowGUI());
//    }

    public static void call(){
        studentName = studentName;
        try{
            ResultSet db = new Database().getQuery("SELECT * FROM user WHERE std_id = '" +studentName + "';");
            db.next();
            showName.setText(db.getString("fname") + " " + db.getString("lname"));
        }catch (Exception ev){
            ev.printStackTrace();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (showName.getText().isEmpty()) {
            show = true;
            showName.setText("แสดงชื่อนักศึกษา");
            showName.setForeground(Color.GRAY);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new View_subject(frame, courseCode, courseName, teacher);
        }
        if (e.getSource() == save) {
            try {
                String stdID = insertID.getText();
                String subjectID = courseCode;
                String subjectName = courseName;
                String teacherName = teacher;
                String studentName = enrollmentController.getStudentById(stdID);
                showName.setText(studentName);
                String sectionID = subjectID;
                switch (groupNum) {
                    case 1:
                        sectionID += 'A';
                        break;
                    case 2:
                        sectionID += 'B';
                        break;
                    case 3:
                        sectionID += 'C';
                        break;
                }
                int num = 1;
                String enrollmentId;
                while (true){
                    ResultSet db = new Database().getQuery("SELECT * FROM enrollment WHERE enrollment_id = '" + stdID + num + "';");
                    if (db.next()){}
                    else{
                        enrollmentId = stdID + num;
                        break;
                    }
                    num++;
                }
                if (stdID.isEmpty() || stdID.equals("กรอกรหัสนักศึกษา")) {
                    new ErrorModal(frame, "กรุณากรอกรหัสนักศึกษา");
                    return;
                }
                enrollmentController.addEnrollment(enrollmentId, stdID, sectionID);
                new SuccessModal(frame, "Enroll successfully");
            }
            catch (Exception ev){
                new ErrorModal(frame, ev.getMessage());
            }

        }

    }
}
