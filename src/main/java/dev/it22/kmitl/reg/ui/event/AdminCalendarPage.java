package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AdminCalendarPage implements ActionListener {
    private JFrame frame;
    private JPanel test , test1 , test2;
    private JButton edit , add ;

    public AdminCalendarPage(JFrame frame){
        this.frame = frame;
        test = new JPanel();
        test1 = new JPanel();
        test2 = new JPanel();
        edit = new JButton("EDIT");
        add = new JButton("ADD");

        test.setBackground(null);
        test1.setLayout( new FlowLayout(FlowLayout.RIGHT,93,0));
        test1.setBackground(null);
        test1.add(edit);
        edit.setForeground(Config.primaryColor_base);
        edit.setBackground(null);
        edit.setFont(Config.HEADER_SEMIBOLD[2]);
        edit.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));

        edit.addActionListener(this);

        test2.setLayout( new FlowLayout(FlowLayout.LEFT,93,0));
        test2.setBackground(null);
        test.add(add);
        add.setForeground(Config.primaryColor_base);
        add.setBackground(null);
        add.setFont(Config.HEADER_SEMIBOLD[2]);
        add.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));

        add.addActionListener(this);

        test.add(test1);
        test.add(test2);
        frame.add(test);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new AdminCalendarPage(Config.createAndShowGUI());
    }
    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == edit) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new EditEventPage(frame);
        } else if (ev.getSource() == add) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminAddEvent(frame);
        }
    }
}
