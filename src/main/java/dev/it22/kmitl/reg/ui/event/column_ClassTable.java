package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class column_ClassTable extends JPanel {
    private JTable table;

    //sample data
    private String day_rows[] = {"", "วันจันทร์", "วันจันทร์", "วันจันทร์", "วันจันทร์", "วันจันทร์", "วันจันทร์", "วันจันทร์"};
    private String time_column[] = {"", "09.00", "09.00", "09.00", "09.00", "09.00", "09.00", "09.00"};

    String[][] schedule = {
            {"09.00", "09.00", "09.00", "09.00", "09.00", "09.00", "09.00"},
            {"Math", "", "Science", "Science", "Art"},
            {"English", "Math", "", "History", "Art"},
            {"PE", "PE", "Math", "", "Music"},
            {"Math", "Science", "Science", "History", "PE"},
            {"History", "English", "", "Math", "Art"},
            {"History", "English", "", "Math", "Art"},
            {"History", "English", "", "Math", "Art"}
    };

    public column_ClassTable() {
        //table = new JTable(8,11);
        DefaultTableModel model = new DefaultTableModel(schedule, time_column);
        table = new JTable(model);
        table.setEnabled(false);
        table.setPreferredSize(new Dimension(800,384));
        table.setRowHeight(48);
        table.setBorder(BorderFactory.createLineBorder(Config.bgColor_hard));
        table.setGridColor(Config.bgColor_hard);
  

        //ปิดเส้นแกน x ระหว่างตาราง
        //table.setShowHorizontalLines(false);


        table.setForeground(Color.BLACK);




        table.setBackground(null);
        this.setLayout(new BorderLayout());
        this.add(table);
        this.setBorder(BorderFactory.createEmptyBorder(0,-1,0,0));
        this.setBackground(null);

    }
}
