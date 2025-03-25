package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;

public class sampleHeaderMenu{


    private JFrame frame;
    private StudentInfo studentInfo;
    private headerMenu header;
    private CalenderHeaderMenu headerCalender;

    private calendarTable table;

    public sampleHeaderMenu(JFrame frame) {

        this.frame = frame;
        frame.setBackground(null);
        studentInfo = new StudentInfo();


        //header.getHome().addActionListener(new returnHomePageHandler());

        frame.setJMenuBar(new CalenderHeaderMenu());
        //frame.add(studentInfo);
        table = new calendarTable("January");
        frame.setLayout(new BorderLayout());
        frame.add(table, BorderLayout.CENTER);
        //frame.setJMenuBar(new headerMenu("Schedule", frame, table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }


    public static void main(String[] args) {
        new sampleHeaderMenu(Config.createAndShowGUI());
    }

}
