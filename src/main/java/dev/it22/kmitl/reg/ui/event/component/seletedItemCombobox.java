package dev.it22.kmitl.reg.ui.event.component;

import javax.swing.*;

public interface seletedItemCombobox {
    public abstract String selectedItem(JComboBox comboBox);
    public abstract String getYearItem();
    public abstract String getSemItem();
    public abstract String getExamItem();
}
