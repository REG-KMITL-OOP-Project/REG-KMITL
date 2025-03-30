package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.ui.Class_Management.component.callData;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.CustomCombobox;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TeacherAddGrade implements FocusListener, ActionListener {
    private JFrame frame;
//    private Account user;
    private JLabel add_score_student, student;
    private JPanel west_panel, student_panel, cancel_panel, save_panel,save_cancel_panel, score_no_panel, pls_enter_score_panel, score_no_enter_score_panel;
    private callData data_id_subject, data_id_student;
    private RoundedButton cancel,save;
    private JComboBox score_no;
    private JTextField pls_enter_score;
    private Font innerFont, regularFont;

    public TeacherAddGrade(JFrame frame) {
        this.frame = frame;
//        user = new User().getUserAccount();
        regularFont = Config.NORMAL_REGULAR;
        innerFont = regularFont.deriveFont(15f);


        add_score_student = new JLabel("เพิ่มคะแนนนักศึกษา");
        add_score_student.setForeground(Config.primaryColor_base);
        add_score_student.setFont(Config.HEADER_SEMIBOLD[1]);

        west_panel = new JPanel();
        west_panel.setLayout(new FlowLayout());
        west_panel.add(add_score_student);
        west_panel.setBackground(null);

        student = new JLabel("นักศึกษา");
        student.setForeground(Config.primaryColor_base);
        student.setFont(Config.HEADER_SEMIBOLD[1]);

        student_panel = new JPanel();
        student_panel.setLayout(new FlowLayout());
        student_panel.add(student);
        student_panel.setBackground(null);

        data_id_subject = new callData("กรอกรหัสวิชา", "แสดงชื่อวิชา");

        data_id_student = new callData("กรอกรหัสนักศึกษา","แสดงข้อมูล");

        score_no = new JComboBox();


        cancel_panel = new JPanel();
        cancel = new RoundedButton("CANCEL" ,22);

        cancel_panel.add(cancel);
        cancel_panel.setLayout( new FlowLayout(FlowLayout.RIGHT,93,0));
//        cancel.setForeground(Color.BLACK);
//        cancel.setBackground(new Color(255,247,237));
        cancel.setForeground(new Color(255, 247, 237));
        cancel.setBackground(Config.primaryColor_base);
        cancel.setFont(Config.HEADER_SEMIBOLD[2]);
        cancel.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));

        save_panel = new JPanel();
        save = new RoundedButton("SAVE" ,22);

        save_panel.add(save);
        save_panel.setLayout( new FlowLayout(FlowLayout.LEFT,93,0));
        save.setForeground(new Color(255, 247, 237));
        save.setBackground(Config.primaryColor_base);
        save.setFont(Config.HEADER_SEMIBOLD[2]);
        save.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));


        save_cancel_panel = new JPanel();
        save_cancel_panel.add(save);
        save_cancel_panel.add(cancel);
        save_cancel_panel.setBackground(null);
        save_cancel_panel.setLayout( new FlowLayout(FlowLayout.RIGHT,93,0));
        save_cancel_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        score_no_panel = new JPanel();
        score_no = new JComboBox();
        score_no.addItem("คะแนนช่องที่");
        score_no.addItem("1");
        score_no.addItem("2");
        score_no.addItem("3");
        score_no.addItem("4");
        score_no.setRenderer(new CustomCombobox());
        score_no.setMaximumRowCount(4);
        score_no.setFont(Config.NORMAL_REGULAR);
        score_no.setPreferredSize(new Dimension((int)(frame.getWidth() / 5),(frame.getHeight() / 4) - 120));
        score_no_panel.add(score_no);

        pls_enter_score_panel = new JPanel();
        pls_enter_score = new JTextField("กรอกคะแนน");
        pls_enter_score.setText("กรอกคะแนน");
        pls_enter_score.setFont(innerFont);
        pls_enter_score.setPreferredSize(new Dimension(100 , 50));
        pls_enter_score.addFocusListener(this);
        score_no_panel.add(pls_enter_score);

        score_no_enter_score_panel = new JPanel();
        score_no_enter_score_panel.add(score_no_panel);
        score_no_enter_score_panel.add(pls_enter_score_panel);
        score_no_enter_score_panel.setLayout(new FlowLayout(FlowLayout.LEFT,93,0));
        score_no_enter_score_panel.setBackground(null);
        score_no_enter_score_panel.setFont(Config.HEADER_SEMIBOLD[2]);


        frame.add(score_no_enter_score_panel, BorderLayout.CENTER);
        frame.add(west_panel, BorderLayout.WEST);
        frame.add(student_panel, BorderLayout.NORTH);
        frame.add(save_cancel_panel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TeacherAddGrade(Config.createAndShowGUI());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
