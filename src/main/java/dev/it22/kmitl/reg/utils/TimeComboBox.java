package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeComboBox extends JComboBox{
    public TimeComboBox() {
        super();
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("HH:mm:ss");
        for(LocalTime time = LocalTime.of(6,0); time.isBefore(LocalTime.of(22, 00)); time = time.plusMinutes(30)) {
            this.addItem(time.format(dft));
            this.setRenderer(new CustomCombobox());
        }
    }

}
