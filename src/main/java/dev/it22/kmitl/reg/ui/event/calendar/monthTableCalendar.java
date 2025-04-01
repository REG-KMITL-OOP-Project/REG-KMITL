package dev.it22.kmitl.reg.ui.event.calendar;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.ui.event.admin.EditEventPage;
import dev.it22.kmitl.reg.ui.event.examSch.ExamSchedulePage;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class monthTableCalendar implements MouseListener{
    private calendarTable jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, nov_2, dec, jun_spe;
    private JPanel sem1, sem2, sem2_1, spe;
    private calendarData data = new calendarData();

    public monthTableCalendar() {
        jan = new calendarTable("มกราคม", data.eventsData(1));
        feb = new calendarTable("กุมภาพันธ์", data.eventsData(2));
        mar = new calendarTable("มีนาคม", data.eventsData(3));
        apr = new calendarTable("เมษายน", data.eventsData(4));
        may = new calendarTable("พฤษภาคม", data.eventsData(5));
        jun = new calendarTable("มิถุนายน", data.eventsData(6));
        jul = new calendarTable("กรกฎาคม", data.eventsData(7));
        aug = new calendarTable("สิงหาคม", data.eventsData(8));
        sep = new calendarTable("กันยายน", data.eventsData(9));
        oct = new calendarTable("ตุลาคม", data.eventsData(10));
        nov = new calendarTable("พฤศจิกายน", data.eventsData(11));
        nov_2 = new calendarTable("พฤศจิกายน", data.eventsData(11));
        dec = new calendarTable("ธันวาคม", data.eventsData(12));
        jun_spe = new calendarTable("มิถุนายน", data.eventsData(61));

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
        spe.add(jun_spe);
        sem1.add(jun);
        sem1.add(jul);
        sem1.add(aug);
        sem1.add(sep);
        sem1.add(oct);
        sem1.add(nov_2);
        sem2.add(nov);
        sem2.add(dec);

        jan.getTable().addMouseListener(this);
        feb.getTable().addMouseListener(this);
        mar.getTable().addMouseListener(this);
        apr.getTable().addMouseListener(this);
        may.getTable().addMouseListener(this);
        jun.getTable().addMouseListener(this);
        jul.getTable().addMouseListener(this);
        aug.getTable().addMouseListener(this);
        sep.getTable().addMouseListener(this);
        oct.getTable().addMouseListener(this);
        nov.getTable().addMouseListener(this);
        nov_2.getTable().addMouseListener(this);
        dec.getTable().addMouseListener(this);

        nov_2.setVisible(false);

    }
    public JPanel getSem1() {
        return sem1;
    }
    public JPanel getSem2() {
        return sem2;
    }
    public JPanel getSem2_1() {
        return sem2_1;
    }
    public JPanel getSpe() {
        return spe;
    }


    public void testSizeData(calendarData data) {
        for (int i = 1 ; i <= 12 ; i++ ){
            System.out.println(data.getDataEvents(i).size());
        }
    }

//    public static void main(String[] args) {
//        try {
//            new Login("Student01","Student1234").loginWithUsernameAndPassword();
//            monthTableCalendar sample = new monthTableCalendar();
//            sample.testSizeData(new calendarData());
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//    }


    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public calendarTable getJan() {
        return jan;
    }
    public calendarTable getFeb() {
        return feb;
    }
    public calendarTable getMar() {
        return mar;
    }
    public calendarTable getApr() {
        return apr;
    }
    public calendarTable getMay() {
        return may;
    }
    public calendarTable getJun() {
        return jun;
    }
    public calendarTable getJul() {
        return jul;
    }
    public calendarTable getAug() {
        return aug;
    }
    public calendarTable getSep() {
        return sep;
    }
    public calendarTable getOct() {
        return oct;
    }
    public calendarTable getNov() {
        return nov;
    }
    public calendarTable getDec() {
        return dec;
    }
    public calendarTable getNov_2() {return nov_2;}

}




