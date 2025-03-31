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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TeacherAddScore {
    private JFrame frame;
    private JLabel enter_score, add_score_student, student;
    private JPanel main_panel, sub1, sub2, sub3;
    private JPanel west_panel, student_panel, student_pan, cancel_panel, save_panel, save_cancel_panel, score_no_panel ,score_no_panel2, pls_enter_score_panel, score_no_enter_score_panel;
    private callData data_id_subject, data_id_student;
    private RoundedButton cancel, save;
    private JComboBox no_of_score;
    private JTextField score;
    private JTextField subject;
    private Font innerFont, regularFont;
    private stdInfo std;

    public TeacherAddScore(JFrame frame) {
            this.frame = frame;
            //    private Account user;
//        user = new User().getUserAccount();
            regularFont = Config.NORMAL_REGULAR;
            innerFont = regularFont.deriveFont(15f);

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

            subject = new JTextField("ชื่อวิชา", 10);
            subject.setEditable(false);
            subject.setForeground(Color.WHITE);
            subject.setFont(Config.HEADER_SEMIBOLD[3]);
            subject.setBorder(null);
            subject.setBackground(Config.bgColor_hard);

            west_panel.add(student_pan, BorderLayout.SOUTH);
            west_panel.setBackground(null);
            west_panel.setPreferredSize(new Dimension(1000, 80));
            west_panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 5, 5));


            student = new JLabel("นักศึกษา", JLabel.LEFT);
            student.setForeground(Config.primaryColor_base);
            student.setFont(Config.HEADER_SEMIBOLD[1]);
            student.setBackground(null);

            student_panel = new JPanel();
            student_panel.setLayout(new BorderLayout());
            student_panel.add(student, BorderLayout.NORTH);
            student_panel.add(data_id_student, BorderLayout.SOUTH);
            data_id_student.setBackground(null);
            student_panel.setBorder(BorderFactory.createEmptyBorder(30, 35, 5, 5));
            student_panel.setBackground(null);

            enter_score = new JLabel("กรอกคะแนน");
            enter_score.setForeground(Config.bgColor_harder);
            enter_score.setFont(Config.HEADER_SEMIBOLD[2]);
            enter_score.setBackground(Color.WHITE);

            score = new JTextField();

            sub1 = new JPanel();
            sub1.setLayout(new BorderLayout());
            sub1.add(score, BorderLayout.SOUTH);
            sub1.add(enter_score, BorderLayout.NORTH);
            //sub1.setBackground(null);

            std = new stdInfo();
            sub2 = new JPanel(new BorderLayout());
            sub2.setBackground(null);
            sub2.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 5));

            sub2.add(std);

            main_panel = new JPanel(new BorderLayout());
            main_panel.add(sub1, BorderLayout.WEST);
            main_panel.add(sub2, BorderLayout.CENTER);
            main_panel.setPreferredSize(new Dimension(1000, 80));
            main_panel.setBackground(null);

            score_no_panel = new JPanel();
            score_no_panel2 = new JPanel();
            main_panel.add(score_no_panel, BorderLayout.SOUTH);
            no_of_score = new JComboBox();
            score_no_panel.add(score_no_panel2);
            score_no_panel2.setPreferredSize(new Dimension((int)(frame.getWidth() / 8),(frame.getHeight() / 4) - 120));
            score_no_panel2.add(no_of_score);
            no_of_score.addItem("คะแนนนช่องที่");
            no_of_score.addItem("1");
            no_of_score.addItem("2");
            no_of_score.addItem("3");
            no_of_score.addItem("4");
            no_of_score.setRenderer(new CustomCombobox());
            no_of_score.setMaximumRowCount(4);
            no_of_score.setFont(Config.NORMAL_REGULAR);
            no_of_score.setFont(innerFont);
            no_of_score.setPreferredSize(new Dimension((int)(frame.getWidth() / 5),(frame.getHeight() / 4) - 120));



            cancel_panel = new JPanel();
            cancel = new RoundedButton("CANCEL", 22);

            cancel_panel.add(cancel);
            cancel_panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 93, 0));
//        cancel.setForeground(Color.BLACK);
            cancel.setBackground(new Color(255, 247, 237));
            cancel.setForeground(new Color(255, 247, 237));
            cancel.setBackground(Config.primaryColor_base);
            cancel.setFont(Config.HEADER_SEMIBOLD[2]);
            cancel.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 2.7), (frame.getHeight() / 4) - 120));

            save_panel = new JPanel();
            save = new RoundedButton("SAVE", 22);

            save_panel.add(save);
            save_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 93, 0));
            save.setForeground(new Color(255, 247, 237));
            save.setBackground(Config.primaryColor_base);
            save.setFont(Config.HEADER_SEMIBOLD[2]);
            save.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 2.7), (frame.getHeight() / 4) - 120));


            save_cancel_panel = new JPanel();
            save_cancel_panel.add(save);
            save_cancel_panel.add(cancel);
            save_cancel_panel.setBackground(null);
            save_cancel_panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 93, 0));
            save_cancel_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));


            //frame.add(score_no_enter_score_panel, BorderLayout.CENTER);
            frame.setLayout(new FlowLayout(FlowLayout.LEFT, 93, 0));

            frame.add(west_panel);
            frame.add(student_pan);
            frame.add(subject);
            frame.add(student_panel);
            frame.add(main_panel);
            frame.add(save_cancel_panel);
            frame.add(score_no_panel);
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