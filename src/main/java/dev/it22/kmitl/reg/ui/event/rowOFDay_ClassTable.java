package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class rowOFDay_ClassTable extends JPanel {

    private JTable table;
    private JPanel panel, pn1;
    private String time_column[] = {""};
    private String day[][] = {{""},{"Monday"},{"Monday"},{"Monday"},{"Monday"},{"Monday"},{"Monday"},{"Monday"}};
    public rowOFDay_ClassTable() {
        DefaultTableModel model = new DefaultTableModel(day, time_column);
        table = new JTable(model);
        table.setRowHeight(48);
        table.setBorder(BorderFactory.createLineBorder(Config.bgColor_hard));
        table.setGridColor(Config.bgColor_hard);
        table.setEnabled(false);
        table.setBorder(BorderFactory.createEmptyBorder(5,-5,-10,-3));

        pn1 = new JPanel(new BorderLayout());
        pn1.add(table);
        pn1.setPreferredSize(new Dimension(100, 384));

        table.setBackground(null);
        pn1.setBackground(null);

        this.setLayout(new BorderLayout());
        this.add(pn1, BorderLayout.WEST);
        this.setBackground(null);
        this.setPreferredSize(new Dimension(100, 304));
    }

}
