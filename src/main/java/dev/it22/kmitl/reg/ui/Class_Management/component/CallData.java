package dev.it22.kmitl.reg.ui.Class_Management.component;

import dev.it22.kmitl.reg.controller.enrollment.EnrollmentController;
import dev.it22.kmitl.reg.controller.score.ScoreDatabase;
import dev.it22.kmitl.reg.ui.Class_Management.AddStudent;
import dev.it22.kmitl.reg.ui.Class_Management.TeacherAddGrade;
import dev.it22.kmitl.reg.ui.Class_Management.TeacherAddScore;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.ErrorModal;
import dev.it22.kmitl.reg.utils.RoundedButton;
import dev.it22.kmitl.reg.utils.RoundedTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;

public class CallData extends JPanel implements FocusListener, ActionListener {
    private RoundedButton showData;
    private RoundedTextField info;
    private boolean showInfo;
    private String text;
    private Color textcolor;
    private EnrollmentController enrollmentController = new EnrollmentController();
    private JFrame frame;

    public CallData(String text, String buttonText , JFrame frame) {
        this(text, Config.bgColor_base, Config.primaryColor_base, buttonText, Color.white, Config.primaryColor_harder , frame);
    }

    public CallData(String text, Color textcolor, Color textBackcolor, String buttonText, Color buttoncolor, Color buttonBackcolor, JFrame frame) {

        info = new RoundedTextField(22);
        showInfo = true;
        info.setText(text);
        info.setForeground(textcolor);
        info.setBackground(textBackcolor);
        info.setFont(Config.HEADER_REGULAR[3]);
        info.setPreferredSize(new Dimension(300, 30));
        info.addFocusListener(this);


        showData = new RoundedButton(buttonText, 20);
        showData.setForeground(buttoncolor);
        showData.setBackground(buttonBackcolor);
        showData.setFont(Config.HEADER_REGULAR[3]);
        showData.addActionListener(this);

        this.text = text;
        this.textcolor = textcolor;

        this.setLayout(new FlowLayout());
        this.setBackground(null);
        this.add(info);
        this.add(showData);
    }

    public void setInfoSize(int width, int height) {
        info.setPreferredSize(new Dimension(width, height));
    }

    public void setButtonSize(int width, int height) {
        showData.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(info) && showInfo) {
            info.setText("");
            info.setForeground(this.textcolor);
            showInfo = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (info.getText().isEmpty()) {
            showInfo = true;
            info.setText(this.text);
            info.setForeground(this.textcolor);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("แสดงชื่อวิชา")){
            try {
                ResultSet subjectrs = new ScoreDatabase().getSubjectData(info.getText());
                TeacherAddScore.setSubject(subjectrs);
                TeacherAddScore.course_id = info.getText();
            } catch (Exception ex) {
                new ErrorModal(frame, ex.getMessage());
            }
        }
        if (e.getActionCommand().equals("แสดงชื่อวิชา ")){
            try {
                ResultSet subjectrs = new ScoreDatabase().getSubjectData(info.getText());
                TeacherAddGrade.setSubject(subjectrs);
                TeacherAddGrade.course_id = info.getText();
            } catch (Exception ex) {
                new ErrorModal(frame, ex.getMessage());
            }
        }
        if (e.getActionCommand().equals("แสดงข้อมูล")){
            try {
                ResultSet stdrs = new ScoreDatabase().getStudentData(info.getText());
                StdInfo.setStudentData(stdrs);
                StdInfo.setInfo();
                System.out.println(info.getText());
                TeacherAddScore.std_id = info.getText();
            } catch (Exception ex) {
                new ErrorModal(frame, ex.getMessage());
            }
        }
        if (e.getActionCommand().equals("แสดงชื่อ")){
            try {
                AddStudent.studentName = info.getText();
                dev.it22.kmitl.reg.ui.Class_Management.AddStudent.call();
            } catch (Exception ex) {
                new ErrorModal(frame, ex.getMessage());
            }
        }
    }

    public String getText() {
        return info.getText();
    }
}
