package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.ui.Class_Management.component.callData;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class TeacherAddGrade {
    private JFrame frame;
//    private Account user;
    private JLabel add_score_student,name_subject, student;
    private JPanel west, student_panel, cancel_panel, save_panel;
    private callData data_id_subject, data_id_student;
    private JButton button1;
    private RoundedButton cancel,save;

    public TeacherAddGrade(JFrame frame) {
        this.frame = frame;
//        user = new User().getUserAccount();


        add_score_student = new JLabel("เพิ่มคะแนนนักศึกษา");
        add_score_student.setForeground(Config.primaryColor_base);
        add_score_student.setFont(Config.HEADER_SEMIBOLD[1]);

        west = new JPanel();
        west.setLayout(new FlowLayout());
        west.add(add_score_student);
        west.setBackground(null);

        student = new JLabel("นักศึกษา");
        student.setForeground(Config.primaryColor_base);
        student.setFont(Config.HEADER_SEMIBOLD[1]);

        student_panel = new JPanel();
        student_panel.setLayout(new FlowLayout());
        student_panel.add(student);
        student_panel.setBackground(null);

        cancel_panel = new JPanel();
        cancel = new RoundedButton("CANCEL" ,22);

        cancel_panel.add(cancel);
        cancel_panel.setLayout( new FlowLayout(FlowLayout.LEFT,93,0));
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(new Color(255,247,237));
        cancel.setFont(Config.HEADER_SEMIBOLD[2]);
        cancel.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));

        save_panel = new JPanel();
        save = new RoundedButton("SAVE" ,22);

        save_panel.add(save);
        save_panel.setLayout( new FlowLayout(FlowLayout.CENTER,93,0));
        save.setForeground(new Color(255, 247, 237));
        save.setBackground(Config.primaryColor_base);
        save.setFont(Config.HEADER_SEMIBOLD[2]);
        save.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));


        frame.add(west, BorderLayout.WEST);
        frame.add(student, BorderLayout.CENTER);
        frame.add(cancel, BorderLayout.EAST);
        frame.add(save, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TeacherAddGrade(Config.createAndShowGUI());
    }
}
