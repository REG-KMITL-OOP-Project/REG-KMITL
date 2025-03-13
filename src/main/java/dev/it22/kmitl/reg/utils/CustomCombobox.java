package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import java.awt.*;

public class CustomCombobox extends DefaultListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        c.setPreferredSize(new Dimension(200, 35));  // Optional: change item height
        return c;
    }
}
