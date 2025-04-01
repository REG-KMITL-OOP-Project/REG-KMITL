package dev.it22.kmitl.reg.utils;

import javax.swing.*;

public class DayComboBox extends JComboBox {
    public DayComboBox() {
        super();
        String[] day = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        for (int i = 0; i < day.length; i++) {
            addItem(day[i]);
        }
        setRenderer(new CustomCombobox());
    }

    public DayComboBox(String first) {
        super();
        addItem(first);
        String[] day = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        for (int i = 0; i < day.length; i++) {
            addItem(day[i]);
        }
        setRenderer(new CustomCombobox());
    }
}
