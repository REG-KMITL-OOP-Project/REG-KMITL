package dev.it22.kmitl.reg.ui.event;

import javax.swing.*;

public class sampleHeaderMenu {
    private JFrame frame;
    private JPanel pn1;
    private headerMenu header;
    private CalenderHeaderMenu headerCalender;
    public sampleHeaderMenu() {
        frame = new JFrame();
        frame.setBackground(null);
        //frame.setJMenuBar(new headerMenu("Schedule"));
        frame.setJMenuBar(new CalenderHeaderMenu());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new sampleHeaderMenu();
    }
}
