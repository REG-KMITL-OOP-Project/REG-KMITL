package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ClassScheduleTable extends JPanel {
    private JTable table;

    //sample data
    private String day_rows[] = {"", "วันจันทร์", "วันจันทร์", "วันจันทร์", "วันจันทร์", "วันจันทร์", "วันจันทร์", "วันจันทร์"};
    private String time_column[] = {"", "09.00", "09.00", "09.00", "09.00", "09.00", "09.00", "09.00"};

    String[][] schedule = {
            {"", "09.00", "09.00", "09.00", "09.00", "09.00", "09.00", "09.00"},
            {"Monday", "Math", "", "Science", "Science", "Art"},
            {"Tuesday", "English", "Math", "", "History", "Art"},
            {"Wednesday", "PE", "PE", "Math", "", "Music"},
            {"Thursday", "Math", "Science", "Science", "History", "PE"},
            {"Friday", "History", "English", "", "Math", "Art"},
            {"Saturday", "History", "English", "", "Math", "Art"},
            {"Sunday", "History", "English", "", "Math", "Art"}
    };

    public ClassScheduleTable() {
        //table = new JTable(8,11);
        DefaultTableModel model = new DefaultTableModel(schedule, time_column);
        table = new JTable(model);
        //table.setModel(model);
        table.setEnabled(false);
        table.setPreferredSize(new Dimension(1100,304));
        table.setRowHeight(38);
        table.setBorder(BorderFactory.createLineBorder(Config.bgColor_hard));
        table.setGridColor(Config.bgColor_hard);
  

        //ปิดเส้นแกน x ระหว่างตาราง
        //table.setShowHorizontalLines(false);


        table.setForeground(Color.WHITE);







        table.setBackground(null);
        this.setLayout(new FlowLayout());
        this.add(table);
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setBackground(null);
    }
}
