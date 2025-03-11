package dev.it22.kmitl.reg.ui.event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeButtonHandler implements ActionListener {
    private JFrame frame;
    public HomeButtonHandler(JFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        //HomePage 404 not found yet
        new AdminCalendarPage(frame);
    }
}

