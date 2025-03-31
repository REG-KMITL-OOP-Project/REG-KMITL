package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.ui.Class_Management.component.callData;
import dev.it22.kmitl.reg.ui.Class_Management.component.stdInfo;
import dev.it22.kmitl.reg.ui.event.calendar.calendarData;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.CustomCombobox;
import dev.it22.kmitl.reg.utils.RoundedButton;
import dev.it22.kmitl.reg.utils.RoundedTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TeacherAddScore {
    private JFrame frame;
    private JLabel add_score_student, student;
    private JPanel main_panel, sub1, sub2, sub3, txt_panel, txt_sub, frame_pan;
    private JPanel west_panel, student_panel, student_pan, cancel_panel, save_panel, save_cancel_panel, subject_panel;
    private callData data_id_subject, data_id_student;
    private RoundedButton cancel, save;
    private JComboBox no_of_score;
    private JTextField score;
    private stdInfo std;
    private JTextArea text;
    private RoundedTextField subject;

    public TeacherAddScore(JFrame frame) {
            this.frame = frame;
            //    private Account user;
//        user = new User().getUserAccount();

            data_id_subject = new callData("กรอกรหัสวิชา", "แสดงชื่อวิชา");
            data_id_student = new callData("กรอกรหัสนักศึกษา", "แสดงข้อมูล");

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

            subject = new RoundedTextField( 25);
            subject.setText("  ชื่อวิชา : ");
            subject.setEditable(false);
            subject.setForeground(Color.WHITE);
            subject.setFont(Config.HEADER_SEMIBOLD[3]);
            subject.setBorder(null);
            subject.setBackground(Config.bgColor_hard);

            subject_panel = new JPanel(new BorderLayout());
            subject_panel.setPreferredSize(new Dimension(440, 50));
            subject_panel.setBackground(null);
            subject_panel.add(subject);
            subject_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 5));

            west_panel.add(student_pan, BorderLayout.SOUTH);
            west_panel.setBackground(null);
            west_panel.setPreferredSize(new Dimension(1000, 80));
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
            no_of_score.setPreferredSize(new Dimension(180, 30));

            sub3 = new JPanel(new BorderLayout(20, 30));
            score = new JTextField(11);
            score.setFont(Config.HEADER_SEMIBOLD[3]);
            sub3.add(score);
            sub3.setPreferredSize(new Dimension(180, 30));
            sub3.setBackground(null);

            sub1 = new JPanel();
            sub1.setLayout(new FlowLayout());
            sub1.setBackground(null);
            sub1.add(no_of_score);
            sub1.add(sub3);
            sub1.setPreferredSize(new Dimension(180, 100));

            std = new stdInfo();
            sub2 = new JPanel(new BorderLayout());
            sub2.setBackground(null);
            sub2.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 5));
            sub2.add(std);

            main_panel = new JPanel(new BorderLayout());
            main_panel.add(sub1, BorderLayout.WEST);
            main_panel.add(sub2, BorderLayout.CENTER);
            main_panel.setPreferredSize(new Dimension(800, 80));
            main_panel.setBorder(new EmptyBorder(5, 45, 5, 5));
            main_panel.setBackground(null);


            text = new JTextArea();
            text.setBackground(Config.bgColor_hard);
            text.setFont(Config.HEADER_SEMIBOLD[3]);
            text.setForeground(Color.WHITE);
            text.setPreferredSize(new Dimension(100, 80));

            txt_sub = new JPanel(new BorderLayout());
            txt_sub.setBackground(null);
            txt_sub.add(text, BorderLayout.CENTER);
            txt_sub.setPreferredSize(new Dimension(1000, 80));

            txt_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            txt_panel.setBackground(null);
            txt_panel.setPreferredSize(new Dimension(1000, 200));
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
            save_cancel_panel.add(save);
            save_cancel_panel.add(cancel);
            save_cancel_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
            save_cancel_panel.setPreferredSize(new Dimension(1000,60));
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

            frame.setLayout(new BorderLayout(20,20));
            frame.add(frame_pan);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }

        public static void main(String[]args){
            try {
                new Login("Student01", "Student1234").loginWithUsernameAndPassword();
                new TeacherAddScore(Config.createAndShowGUI());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }