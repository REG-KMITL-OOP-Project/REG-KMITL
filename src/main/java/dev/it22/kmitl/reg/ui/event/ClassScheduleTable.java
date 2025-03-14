package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;

public class ClassScheduleTable extends JPanel {
    private JTable table;
    private String day_rows[] = {"", "วันจันทร์", "วันจันทร์", "วันจันทร์", "วันจันทร์", "วันจันทร์", "วันจันทร์", "วันจันทร์"};
    private String time_column[] = {"", "09.00", "09.00", "09.00", "09.00", "09.00", "09.00", "09.00"};

    public ClassScheduleTable() {
        table = new JTable(8,11);
        table.setEnabled(false);
        table.setPreferredSize(new Dimension(1100,304));
        table.setRowHeight(38);
        table.setBorder(BorderFactory.createLineBorder(Config.bgColor_hard));
        table.setGridColor(Config.bgColor_hard);

        table.setBackground(null);
        this.setLayout(new FlowLayout());
        this.add(table);
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setBackground(null);
    }
}
