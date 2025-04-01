package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.controller.score.ScoreDatabase;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.score.ScoreModel;
import dev.it22.kmitl.reg.ui.Class_Management.component.callData;
import dev.it22.kmitl.reg.ui.Class_Management.component.stdInfo;
import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.ui.event.calendar.calendarData;
import dev.it22.kmitl.reg.utils.*;
import dev.it22.kmitl.reg.controller.score.ScoreController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;

public class TeacherAddScore implements FocusListener, ActionListener {
    private static JFrame frame;
    private JLabel add_score_student, student;
    private JPanel main_panel, sub1, sub2, sub3, txt_panel, txt_sub, frame_pan;
    private JPanel west_panel, student_panel, student_pan, cancel_panel, save_panel, save_cancel_panel, subject_panel;
    private callData data_id_subject, data_id_student;
    private RoundedButton cancel, save;
    private JComboBox no_of_score;
    private JTextField score;
    private stdInfo std;
    private JTextArea text;
    private static RoundedTextField subject =  new RoundedTextField(25);;
    private boolean scoreShow, textShow;
    private ScoreController scoreController = new ScoreController();
    private static ResultSet subject_data;
    public static String std_id = "";
    public static String course_id = "";

    public static void setSubject(ResultSet subject) {
        TeacherAddScore.subject_data = subject;
        try {
            if (subject_data.next()) {

                course_id = subject_data.getString("course_code");
                TeacherAddScore.subject.setText("ชื่อวิชา "+subject_data.getString("course_name"));
            }
        }
        catch (Exception ex) {
            new ErrorModal(TeacherAddScore.frame,"Error");
        }
    }

    public TeacherAddScore(JFrame frame) {
        this.frame = frame;

        data_id_subject = new callData("กรอกรหัสวิชา", "แสดงชื่อวิชา", frame);
        data_id_student = new callData("กรอกรหัสนักศึกษา", "แสดงข้อมูล", frame);
        data_id_student.setInfoSize(frame.getWidth() / (frame.getWidth() / 400), frame.getWidth() / (frame.getWidth() / 40));
        data_id_subject.setInfoSize(frame.getWidth() / (frame.getWidth() / 400), frame.getWidth() / (frame.getWidth() / 40));

        add_score_student = new JLabel("เพิ่มคะแนนนักศึกษา");
        add_score_student.setForeground(Config.primaryColor_base);
        add_score_student.setFont(Config.HEADER_SEMIBOLD[1]);
        add_score_student.setHorizontalAlignment(SwingConstants.LEFT);
        add_score_student.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 5));

        west_panel = new JPanel();
        west_panel.setLayout(new BorderLayout());
        west_panel.add(add_score_student, BorderLayout.NORTH);

        student_pan = new JPanel();
        student_pan.add(data_id_subject);
        student_pan.setBackground(null);
        student_pan.setLayout(new FlowLayout());
        student_pan.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 5));

        subject.setText("  ชื่อวิชา : ");
        subject.setEditable(false);
        subject.setForeground(Color.WHITE);
        subject.setFont(Config.HEADER_SEMIBOLD[3]);
        subject.setBorder(null);
        subject.setBackground(Config.bgColor_hard);

        subject_panel = new JPanel(new BorderLayout());
        subject_panel.setPreferredSize(new Dimension(frame.getWidth() / (frame.getWidth() / 400), frame.getWidth() / (frame.getWidth() / 45)));
        subject_panel.setBackground(null);
        subject_panel.add(subject);
        subject_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));

        west_panel.add(student_pan, BorderLayout.SOUTH);
        west_panel.setBackground(null);
        west_panel.setPreferredSize(new Dimension(frame.getWidth() / (frame.getWidth() / 1000), frame.getWidth() / (frame.getWidth() / 80)));
        west_panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 5, 5));


        student = new JLabel("นักศึกษา", JLabel.LEFT);
        student.setForeground(Config.primaryColor_base);
        student.setFont(Config.HEADER_SEMIBOLD[1]);
        student.setBackground(null);
        student.setBorder(new EmptyBorder(5, 5, 10, 5));

        student_panel = new JPanel();
        student_panel.setLayout(new BorderLayout());
        student_panel.add(student, BorderLayout.NORTH);
        student_panel.add(data_id_student, BorderLayout.SOUTH);
        data_id_student.setBackground(null);
        student_panel.setBorder(BorderFactory.createEmptyBorder(30, 35, 5, 5));
        student_panel.setBackground(null);

        no_of_score = new JComboBox();
        no_of_score.addItem("คะแนนนช่องที่ 1");
        no_of_score.addItem("คะแนนนช่องที่ 2");
        no_of_score.addItem("คะแนนนช่องที่ 3");
        no_of_score.addItem("คะแนนนช่องที่ 4");
        no_of_score.setMaximumRowCount(4);
        no_of_score.setFont(Config.NORMAL_REGULAR);
        no_of_score.setFont(Config.HEADER_SEMIBOLD[3]);
        no_of_score.setPreferredSize(new Dimension(frame.getWidth() / (frame.getWidth() / 180), frame.getWidth() / (frame.getWidth() / 30)));

        scoreShow = true;
        sub3 = new JPanel(new BorderLayout(20, 30));
        score = new JTextField(11);
        score.setText("  กรอกคะแนน");
        score.setForeground(Color.GRAY);
        score.setFont(Config.HEADER_SEMIBOLD[3]);
        sub3.add(score);
        sub3.setPreferredSize(new Dimension(frame.getWidth() / (frame.getWidth() / 180), frame.getWidth() / (frame.getWidth() / 30)));
        sub3.setBackground(null);
        score.addFocusListener(this);

        sub1 = new JPanel();
        sub1.setLayout(new FlowLayout());
        sub1.setBackground(null);
        sub1.add(no_of_score);
        sub1.add(sub3);
        sub1.setPreferredSize(new Dimension(frame.getWidth() / (frame.getWidth() / 180), frame.getWidth() / (frame.getWidth() / 100)));

        std = new stdInfo();
        sub2 = new JPanel(new BorderLayout());
        sub2.setBackground(null);
        sub2.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 5));
        sub2.add(std);

        main_panel = new JPanel(new BorderLayout());
        main_panel.add(sub1, BorderLayout.WEST);
        main_panel.add(sub2, BorderLayout.CENTER);
        main_panel.setPreferredSize(new Dimension(frame.getWidth() / (frame.getWidth() / 800), frame.getWidth() / (frame.getWidth() / 80)));
        main_panel.setBorder(new EmptyBorder(5, 45, 5, 5));
        main_panel.setBackground(null);

        txt_sub = new JPanel(new BorderLayout());
        txt_sub.setBackground(null);
        txt_sub.setPreferredSize(new Dimension((int) (frame.getWidth() / 1.3), frame.getWidth() / (frame.getWidth() / 80)));

        txt_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txt_panel.setBackground(null);
        txt_panel.setPreferredSize(new Dimension(frame.getWidth() / (frame.getWidth() / 1000), frame.getWidth() / (frame.getWidth() / 200)));
        txt_panel.setBorder(new EmptyBorder(5, 40, 5, 5));
        txt_panel.add(txt_sub, BorderLayout.CENTER);


        cancel_panel = new JPanel();
        cancel = new RoundedButton("CANCEL", 22);

        cancel_panel.add(cancel);
        cancel_panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 93, 0));
        cancel.setBackground(Config.primaryColor_harder);
        cancel.setForeground(new Color(255, 247, 237));
        cancel.setFont(Config.HEADER_SEMIBOLD[2]);
        cancel.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 3), (frame.getHeight() / 4) - 130));

        save_panel = new JPanel();
        save = new RoundedButton("SAVE", 22);

        save_panel.add(save);
        save_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
        save.setForeground(new Color(255, 247, 237));
        save.setBackground(Config.primaryColor_base);
        save.setFont(Config.HEADER_SEMIBOLD[2]);
        save.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 3), (frame.getHeight() / 4) - 130));


        save_cancel_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 0));
        save_cancel_panel.add(cancel);
        save_cancel_panel.add(save);
        save_cancel_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        save_cancel_panel.setPreferredSize(new Dimension((int) (frame.getWidth() / 1.2), frame.getWidth() / (frame.getWidth() / 600)));
        save_cancel_panel.setBackground(null);

        frame_pan = new JPanel(new FlowLayout(FlowLayout.LEFT, 93, 0));
        frame_pan.setBackground(null);
        frame_pan.add(west_panel);
        frame_pan.add(student_pan);
        frame_pan.add(subject_panel);
        frame_pan.add(student_panel);
        frame_pan.add(main_panel);
        frame_pan.add(txt_panel);
        frame_pan.add(save_cancel_panel);

        frame.setLayout(new BorderLayout(20, 20));
        frame.add(frame_pan);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        cancel.addActionListener(this);
        save.addActionListener(e -> {
            if (course_id == null || course_id.isEmpty()) {
                new ErrorModal(frame,"กรุณากรอกรหัสวิชา หากกรอกแล้วให้กดปุ่มแสดงชื่อวิชา");
                return;
            }

            if (std_id == null || std_id.isEmpty()) {
                new ErrorModal(frame,"กรุณากรอกรหัสนักศึกษา หากกรอกแล้วให้กดปุ่มแสดงข้อมูล");
                return;
            }
            if (score.getText().isEmpty() || score.getText().equals("  กรอกคะแนน")) {
                new ErrorModal(frame,"กรุณากรอกคะแนน");
                return;
            }

            try{
                String enrollmenId = new ScoreDatabase().getEnrollmentId(TeacherAddScore.std_id,course_id);
                if (enrollmenId == null){
                    new ErrorModal(frame,"ไม่การลงทะเบียนวิชานี้");
                }
                new ScoreDatabase().addScore(enrollmenId,no_of_score.getSelectedIndex()+1,Double.valueOf(score.getText()));
                new SuccessModal(frame,"บันทึกคะแนนเรียบร้อย");
            }
            catch (Exception ex){
                new ErrorModal(frame,ex.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        try {
            new Login("Student01", "Student1234").loginWithUsernameAndPassword();
            new TeacherAddScore(Config.createAndShowGUI());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new HomePage(frame);
        } else if (e.getSource() == save) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new HomePage(frame);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(score) && scoreShow) {
            score.setText("");
            score.setForeground(Config.bgColor_base);
            scoreShow = false;
        }
        if (e.getSource().equals(text) && textShow) {
            text.setText("");
            text.setForeground(Color.WHITE);
            textShow = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (score.getText().isEmpty()) {
            scoreShow = true;
            score.setText("  กรอกคะแนน");
            score.setForeground(Color.GRAY);
        }
        if (text.getText().isEmpty()) {
            textShow = true;
            text.setText("  หมายเหตุ");
            text.setForeground(Color.GRAY);
        }
    }
}
