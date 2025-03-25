package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;

public class CalendarPage {
    private JFrame frame;
    private JPanel panel, pn1;
    private JScrollPane scrollPane;
    private calendarTable jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec;
    public CalendarPage(JFrame frame) {
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

        panel = new JPanel();
        panel.setBackground(null);
        panel.setBorder(null);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(jan);
        panel.add(feb);
        panel.add(mar);
        panel.add(apr);
        panel.add(may);
        panel.add(jun);
        panel.add(jul);
        panel.add(aug);
        panel.add(sep);
        panel.add(oct);
        panel.add(nov);
        panel.add(dec);

        scrollPane = new JScrollPane(panel);
        scrollPane.setBackground(null);
        scrollPane.getVerticalScrollBar().setBackground(null);
        scrollPane.getViewport().setBackground(null);
        scrollPane.getViewport().setBorder(null);
        scrollPane.getViewport().getView().setBackground(null);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(scrollPane, BorderLayout.EAST);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CalendarPage(Config.createAndShowGUI());
    }
}
