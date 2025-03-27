package dev.it22.kmitl.reg.ui.event.calendar;

import com.formdev.flatlaf.FlatLightLaf;
import dev.it22.kmitl.reg.ui.event.component.newHeader;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CalendarPage {
    private JFrame frame;
    private JPanel r_panel, pn1;
    private JScrollPane scrollPane;
    private newHeader header;
    private calendarTable jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec;
    private SemesterCategory category;
    public CalendarPage(JFrame frame) {
        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e){
            e.printStackTrace();
        }

        this.frame = frame;

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

        header = new newHeader("ปฏิทินการศึกษา", frame);
        category = new SemesterCategory();
        category.setBorder(new EmptyBorder(10,0,0,0));
        frame.add(header, BorderLayout.NORTH);
        frame.add(category, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.EAST);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CalendarPage(Config.createAndShowGUI());
    }
}
