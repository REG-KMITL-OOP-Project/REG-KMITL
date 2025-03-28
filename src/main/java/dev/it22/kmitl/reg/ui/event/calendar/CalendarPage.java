package dev.it22.kmitl.reg.ui.event.calendar;

import com.formdev.flatlaf.FlatLightLaf;
import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.ui.event.classSch.classData;
import dev.it22.kmitl.reg.ui.event.component.newHeader;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CalendarPage extends monthTableCalendar implements ItemListener {
    private JFrame frame;
    private JPanel r_panel, pn1;
    private JScrollPane scrollPane;
    private newHeader header;
    private SemesterCategory category;

    public CalendarPage(JFrame frame) {
        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e){
            e.printStackTrace();
        }

        this.frame = frame;

        r_panel = new JPanel();
        r_panel.setBackground(null);
        r_panel.setBorder(null);
        r_panel.setLayout(new BoxLayout(r_panel, BoxLayout.Y_AXIS));
        r_panel.add(super.getSem1());
        r_panel.add(super.getSem2());
        r_panel.add(super.getSem2_1());
        r_panel.add(super.getSpe());

        scrollPane = new JScrollPane(r_panel);
        scrollPane.setBackground(null);
        scrollPane.getVerticalScrollBar().setBackground(null);
        scrollPane.getViewport().setBackground(null);
        scrollPane.getViewport().setBorder(null);
        scrollPane.getViewport().getView().setBackground(null);
        scrollPane.setBorder(new EmptyBorder(10,0,0,0));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);

        header = new newHeader("ปฏิทินการศึกษา", frame);
        category = new SemesterCategory(frame);
        category.setBorder(new EmptyBorder(10,0,0,0));
        frame.add(header, BorderLayout.NORTH);
        frame.add(category, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.EAST);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        category.getSem1().addItemListener(this);
        category.getSem2().addItemListener(this);
        category.getSpecialSem().addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (category.getSem1().isSelected()) {
            super.getSem1().setVisible(false);
        }
        if (!category.getSem1().isSelected()) {
            super.getSem1().setVisible(true);
        }
        if (category.getSem2().isSelected()) {
            super.getSem2().setVisible(false);
            super.getSem2_1().setVisible(false);
        }
        if (!category.getSem2().isSelected()) {
            super.getSem2().setVisible(true);
            super.getSem2_1().setVisible(true);
        }
        if (!category.getSpecialSem().isSelected()) {
            super.getSpe().setVisible(true);
        }
        if (category.getSpecialSem().isSelected()) {
            super.getSpe().setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CalendarPage(Config.createAndShowGUI());
//        try {
//            new Login("Student01","Student1234").loginWithUsernameAndPassword();
//
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

    }
}
