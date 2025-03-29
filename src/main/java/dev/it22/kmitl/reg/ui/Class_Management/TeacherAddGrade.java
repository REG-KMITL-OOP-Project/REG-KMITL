package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;

public class TeacherAddGrade {
    private JFrame frame;
    public TeacherAddGrade(JFrame frame) {
        this.frame = frame;

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TeacherAddGrade(Config.createAndShowGUI());
    }
}
