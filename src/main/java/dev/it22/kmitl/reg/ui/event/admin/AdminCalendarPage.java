package dev.it22.kmitl.reg.ui.event.admin;

import com.formdev.flatlaf.FlatLightLaf;
import dev.it22.kmitl.reg.ui.event.calendar.calendarTable;
import dev.it22.kmitl.reg.ui.event.component.newHeader;
import dev.it22.kmitl.reg.ui.event.calendar.SemesterCategory;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class AdminCalendarPage implements ActionListener , ItemListener {
    private JFrame frame;
    private JPanel r_panel, pn1;
    private JScrollPane scrollPane;
    private newHeader header;
    private calendarTable jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec;
    private SemesterCategory category;

    private JButton create;
    private JPanel create_panel, back_panel;

    private JPanel sem1, sem2, sem2_1, spe;

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

        jan = new calendarTable("มกราคม", frame);
        feb = new calendarTable("กุมภาพันธ์", frame);
        mar = new calendarTable("มีนาคม", frame);
        apr = new calendarTable("เมษายน", frame);
        may = new calendarTable("พฤษภาคม", frame);
        jun = new calendarTable("มิถุนายน", frame);
        jul = new calendarTable("กรกฎาคม", frame);
        aug = new calendarTable("สิงหาคม", frame);
        sep = new calendarTable("กันยายน", frame);
        oct = new calendarTable("ตุลาคม", frame);
        nov = new calendarTable("พฤศจิกายน", frame);
        dec = new calendarTable("ธันวาคม", frame);


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

        back_panel = new JPanel();
        back_panel.setBackground(null);
        back_panel.setLayout(new BorderLayout());
        back_panel.add(create_panel, BorderLayout.NORTH);
        back_panel.add(scrollPane);

        header = new newHeader("ปฏิทินการศึกษา", frame);
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
            System.out.println("sem1");
            sem1.setVisible(false);
        }
        if (!category.getSem1().isSelected()) {
            System.out.println("sem1");
            sem1.setVisible(true);
        }
        if (category.getSem2().isSelected()) {
            System.out.println("sem2");
            sem2.setVisible(false);
            sem2_1.setVisible(false);
        }
        if (!category.getSem2().isSelected()) {
            System.out.println("sem2");
            sem2.setVisible(true);
            sem2_1.setVisible(true);
        }
        if (!category.getSpecialSem().isSelected()) {
            spe.setVisible(true);
        }
        if (category.getSpecialSem().isSelected()) {
            System.out.println("special");
            spe.setVisible(false);
        }
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
    }

}
