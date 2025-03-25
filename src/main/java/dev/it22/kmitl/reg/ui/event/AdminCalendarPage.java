package dev.it22.kmitl.reg.ui.event;

import com.formdev.flatlaf.FlatLightLaf;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AdminCalendarPage implements ActionListener {
    private JFrame frame;
    private JPanel r_panel, pn1;
    private JScrollPane scrollPane;
    private newHeader header;
    private calendarTable jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec;
    private eventCategory category;

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
        create.setPreferredSize(new Dimension(800, 50));
        create.setBorder(null);
        create_panel = new JPanel();
        create_panel.setLayout(new FlowLayout());
        create_panel.add(create, BorderLayout.NORTH);
        create_panel.setPreferredSize(new Dimension(800, 50));
        create_panel.setBackground(null);
        create_panel.setBorder(null);

        jan = new calendarTable("มกราคม");
        feb = new calendarTable("กุมภาพันธ์");
        mar = new calendarTable("มีนาคม");
        apr = new calendarTable("เมษายน");
        may = new calendarTable("พฤษภาคม");
        jun = new calendarTable("มิถุนายน");
        jul = new calendarTable("กรกฎาคม");
        aug = new calendarTable("สิงหาคม");
        sep = new calendarTable("กันยายน");
        oct = new calendarTable("ตุลาคม");
        nov = new calendarTable("พฤศจิกายน");
        dec = new calendarTable("ธันวาคม");

        r_panel = new JPanel();
        r_panel.setBackground(null);
        r_panel.setBorder(null);
        r_panel.setLayout(new BoxLayout(r_panel, BoxLayout.Y_AXIS));
        r_panel.add(jan);
        r_panel.add(feb);
        r_panel.add(mar);
        r_panel.add(apr);
        r_panel.add(may);
        r_panel.add(jun);
        r_panel.add(jul);
        r_panel.add(aug);
        r_panel.add(sep);
        r_panel.add(oct);
        r_panel.add(nov);
        r_panel.add(dec);


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

        header = new newHeader("ปฏิทินการศึกษา", frame);
        category = new eventCategory();
        category.setBorder(new EmptyBorder(10,0,0,0));
        frame.add(header, BorderLayout.NORTH);
        frame.add(category, BorderLayout.CENTER);
        frame.add(back_panel, BorderLayout.EAST);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        create.addActionListener(this);
    }
    public static void main(String[] args) {
        new AdminCalendarPage(Config.createAndShowGUI());
    }
    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == create) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminAddEvent(frame);
        }
//        } else if (ev.getSource() == create) {
//            frame.getContentPane().removeAll();
//            frame.revalidate();
//            frame.repaint();
//            new EditEventPage(frame);
//        }
    }
}
