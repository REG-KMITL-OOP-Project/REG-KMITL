package dev.it22.kmitl.reg.ui.event.calendar;

import com.formdev.flatlaf.FlatLightLaf;
import dev.it22.kmitl.reg.ui.event.component.newHeader;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CalendarPage implements ItemListener {
    private JFrame frame;
    private JPanel r_panel, pn1;
    private JScrollPane scrollPane;
    private newHeader header;
    private calendarTable jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec;
    private SemesterCategory category;

    private JPanel sem1, sem2, sem2_1, spe;

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

        sem1 = new JPanel();
        sem1.setBackground(null);
        sem1.setBorder(null);
        sem1.setLayout(new BoxLayout(sem1, BoxLayout.Y_AXIS));

        sem2 = new JPanel();
        sem2.setBackground(null);
        sem2.setBorder(null);
        sem2.setLayout(new BoxLayout(sem2, BoxLayout.Y_AXIS));

        sem2_1 = new JPanel();
        sem2_1.setBackground(null);
        sem2_1.setBorder(null);
        sem2_1.setLayout(new BoxLayout(sem2_1, BoxLayout.Y_AXIS));

        spe = new JPanel();
        spe.setBackground(null);
        spe.setBorder(null);
        spe.setLayout(new BoxLayout(spe, BoxLayout.Y_AXIS));

        sem2_1.add(jan);
        sem2_1.add(feb);
        sem2_1.add(mar);
        spe.add(apr);
        spe.add(may);
        sem1.add(jun);
        sem1.add(jul);
        sem1.add(aug);
        sem1.add(sep);
        sem1.add(oct);
        sem2.add(nov);
        sem2.add(dec);

        r_panel = new JPanel();
        r_panel.setBackground(null);
        r_panel.setBorder(null);
        r_panel.setLayout(new BoxLayout(r_panel, BoxLayout.Y_AXIS));
        r_panel.add(sem2_1);
        r_panel.add(spe);
        r_panel.add(sem1);
        r_panel.add(sem2);


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
            sem1.setVisible(false);
        }
        if (!category.getSem1().isSelected()) {
            sem1.setVisible(true);
        }
        if (category.getSem2().isSelected()) {
            sem2.setVisible(false);
            sem2_1.setVisible(false);
        }
        if (!category.getSem2().isSelected()) {
            sem2.setVisible(true);
            sem2_1.setVisible(true);
        }
        if (!category.getSpecialSem().isSelected()) {
            spe.setVisible(true);
        }
        if (category.getSpecialSem().isSelected()) {
            spe.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CalendarPage(Config.createAndShowGUI());
    }
}
