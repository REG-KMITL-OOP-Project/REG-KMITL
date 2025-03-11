package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;

public class sampleHeaderMenu{


    private JFrame frame;
    private StudentInfo studentInfo;
    private headerMenu header;
    private CalenderHeaderMenu headerCalender;
    public sampleHeaderMenu(JFrame frame) {

        this.frame = frame;
        frame.setBackground(null);
        studentInfo = new StudentInfo();
        frame.setJMenuBar(new headerMenu("Schedule", frame));

        //header.getHome().addActionListener(new returnHomePageHandler());

        //frame.setJMenuBar(new CalenderHeaderMenu());
        //frame.add(studentInfo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new sampleHeaderMenu(Config.createAndShowGUI());
    }
}
