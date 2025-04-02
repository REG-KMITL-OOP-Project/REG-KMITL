package dev.it22.kmitl.reg.ui.event.admin;

import com.formdev.flatlaf.FlatLightLaf;
import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.ui.event.calendar.MonthTableCalendar;
import dev.it22.kmitl.reg.ui.event.component.NewHeader;
import dev.it22.kmitl.reg.ui.event.calendar.SemesterCategory;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class AdminCalendarPage extends MonthTableCalendar implements ActionListener , ItemListener{
    private JFrame frame;
    private JPanel r_panel, pn1;
    private JScrollPane scrollPane;
    private NewHeader header;
    private SemesterCategory category;

    private JButton create;
    private JPanel create_panel, back_panel;

    public AdminCalendarPage(JFrame frame){
        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e){
            e.printStackTrace();
        }

        this.frame = frame;

        create = new JButton("Create New Event...");
        create.setFont(Config.HEADER_SEMIBOLD[2]);
        create.setForeground(Config.primaryColor_hard);
        create.setBackground(Config.bgColor_base.darker());
        create.setPreferredSize(new Dimension(frame.getWidth() - (frame.getWidth()/ 3) - (frame.getWidth()/53), frame.getHeight()/14));
        create.setBorder(null);
        create_panel = new JPanel();
        create_panel.setLayout(new FlowLayout());
        create_panel.add(create, BorderLayout.NORTH);
        create_panel.setPreferredSize(new Dimension(create.getPreferredSize().width, create.getPreferredSize().height));
        create_panel.setBackground(null);
        create_panel.setBorder(null);

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

        back_panel = new JPanel();
        back_panel.setBackground(null);
        back_panel.setLayout(new BorderLayout());
        back_panel.add(create_panel, BorderLayout.NORTH);
        back_panel.add(scrollPane);

        header = new NewHeader("ปฏิทินการศึกษา", frame);
        category = new SemesterCategory(frame);
        category.setBorder(new EmptyBorder(10,0,0,0));
        frame.add(header, BorderLayout.NORTH);
        frame.add(category, BorderLayout.CENTER);
        frame.add(back_panel, BorderLayout.EAST);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        create.addActionListener(this);
        category.getSem1().addItemListener(this);
        category.getSem2().addItemListener(this);
        category.getSpecialSem().addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (category.getSem1().isSelected()) {
            super.getSem1().setVisible(true);
        }
        if (category.getSem1().isSelected() && !category.getSem2().isSelected()) {
            super.getSem1().setVisible(true);
            super.getNov_2().setVisible(true);
        }
        if (category.getSem1().isSelected() && category.getSem2().isSelected()) {
            super.getSem1().setVisible(true);
            super.getNov_2().setVisible(false);
        }
        if (!category.getSem1().isSelected()) {
            super.getSem1().setVisible(false);
        }
        if (category.getSem2().isSelected()) {
            super.getSem2().setVisible(true);
            super.getSem2_1().setVisible(true);
        }
        if (!category.getSem2().isSelected()) {
            super.getSem2().setVisible(false);
            super.getSem2_1().setVisible(false);
        }
        if (!category.getSpecialSem().isSelected()) {
            super.getSpe().setVisible(false);
        }
        if (category.getSpecialSem().isSelected()) {
            super.getSpe().setVisible(true);
        }
    }
    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == create) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminAddEvent(frame);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");
        try {
            if(!((String) ((JTable)e.getSource()).getValueAt(((JTable)e.getSource()).rowAtPoint(e.getPoint()),1)).equals("")) {
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                new EditEventPage(frame, (String) ((JTable)e.getSource()).getValueAt(((JTable)e.getSource()).rowAtPoint(e.getPoint()),1), (String) ((JTable)e.getSource()).getValueAt(((JTable)e.getSource()).rowAtPoint(e.getPoint()),2));
            }
        }catch (NullPointerException ex){}

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
        try {
            if(!((String) ((JTable)e.getSource()).getValueAt(((JTable)e.getSource()).rowAtPoint(e.getPoint()),1)).equals("")) {
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                new EditEventPage(frame, (String) ((JTable)e.getSource()).getValueAt(((JTable)e.getSource()).rowAtPoint(e.getPoint()),1), (String) ((JTable)e.getSource()).getValueAt(((JTable)e.getSource()).rowAtPoint(e.getPoint()),2));
            }
        }catch (NullPointerException ex){}
    }

//    public static void main(String[] args) {
//        try {
//            new Login("Admin01","Admin1234").loginWithUsernameAndPassword();
//            new AdminCalendarPage(Config.createAndShowGUI());
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
}





