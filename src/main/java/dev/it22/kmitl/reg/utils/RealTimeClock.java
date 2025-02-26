package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RealTimeClock {
    private JTextArea clock;
    private Timer timer;

    public RealTimeClock() {
        clock = new JTextArea();
//        Font font = Config.HEADER_1;
        clock.setFont(Config.HEADER_SEMIBOLD[0]);
        clock.setForeground(Color.WHITE);
//        clock.setLineWrap(true);
        clock.setEditable(false);
        clock.setOpaque(false);
        clock.setAlignmentX(Component.RIGHT_ALIGNMENT);
        clock.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        clock.setBorder(BorderFactory.createEmptyBorder(35,0,0,50));
        timer = new Timer(1000, e -> {
            String time = new SimpleDateFormat("HH:mm").format(new Date());
            String date = new SimpleDateFormat("EEE d MMM").format(new Date());
            clock.setText(date+ "\n"+ time);
        });
        timer.start();
    }

    public JTextArea getClock() {
        return clock;
    }

//    public static void main(String[] args) {
////        SwingUtilities.invokeLater(() -> {
////
////        });
//        JFrame frame = new JFrame("Real-Time Clock");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300, 150);
//
//        RealTimeClock clock = new RealTimeClock();
//        frame.add(clock.getTextArea());
//
//        frame.setVisible(true);
//    }
}
