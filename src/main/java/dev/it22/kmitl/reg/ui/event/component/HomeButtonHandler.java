package dev.it22.kmitl.reg.ui.event.component;

import dev.it22.kmitl.reg.ui.HomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeButtonHandler implements ActionListener {
    private JFrame frame;
    private HeaderMenu menubar;
    public HomeButtonHandler(JFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setJMenuBar(null);
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        new HomePage(frame);
    }
}

