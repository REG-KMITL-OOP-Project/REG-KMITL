package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RealTimeClock {
    private JTextArea clock;
    private Timer timer;

    public RealTimeClock() {
        clock = new JTextArea();
        clock.setFont(Config.HEADER_SEMIBOLD[0]); // Ensure the font is set properly
        clock.setForeground(Color.WHITE);
//        clock.setLineWrap(true);
        clock.setEditable(false);
        clock.setOpaque(false);
        clock.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 50));

        // Proper right alignment
        clock.setAlignmentX(Component.RIGHT_ALIGNMENT);
        clock.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        clock.setWrapStyleWord(true);
        clock.setLineWrap(true);

        timer = new Timer(1000, e -> updateClock());
        timer.start();
        updateClock(); // Initial update
    }

    private void updateClock() {
        Date now = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE d MMM", Locale.ENGLISH);
        String time = timeFormat.format(now);
        String date = dateFormat.format(now);
        clock.setText(date + "\n" + time);
    }

    public JTextArea getClock() {
        return clock;
    }

}
