package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import java.awt.*;

public class CustomCombobox extends DefaultListCellRenderer{
    Dimension d;
    public CustomCombobox(){
        this(200, 35);
    }

    public CustomCombobox(int w, int h){
        super();
        d = new Dimension(w, h);
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        c.setPreferredSize(d);  // change cell item weight & height
        return c;
    }
}
