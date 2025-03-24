package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class ClassScheduleTable extends JTable {
    //rowOFDay_ClassTable
    private JPanel row;
    private JTable table_day;
    private JPanel panel, pn1;
    private String day_time_column[] = {""};
    private String day[][] = {{""},{"Monday"},{"Monday"},{"Monday"},{"Monday"},{"Monday"},{"Monday"},{"Monday"}};

    //column_ClassTable
    private JPanel column;
    private JTable table_column;
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

    //combine
    private JPanel com;

    public ClassScheduleTable() {

        //rowOFDay_ClassTable
        DefaultTableModel model_day = new DefaultTableModel(day, day_time_column);
        table_day = new JTable(model_day);
        table_day.setRowHeight(48);
        table_day.setBorder(BorderFactory.createLineBorder(Config.bgColor_hard));
        table_day.setGridColor(Config.bgColor_hard);
        table_day.setEnabled(false);
        table_day.setBorder(BorderFactory.createEmptyBorder(5,-5,-10,-3));

        pn1 = new JPanel(new BorderLayout());
        pn1.add(table_day);
        pn1.setPreferredSize(new Dimension(100, 384));

        //table_day.getTableHeader().setBackground(Config.bgColor_hard);
        DefaultTableCellRenderer Renderer = new DefaultTableCellRenderer();
        Renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table_day.getColumnCount(); i++) {
            table_day.getColumnModel().getColumn(i).setCellRenderer(Renderer);
        }

        //ปิดเส้นแกน x ระหว่างตาราง
        table_day.setShowHorizontalLines(false);

        //table_day.setForeground(Config.primaryColor_harder);
        //table_day.setBackground(null);
        pn1.setBackground(null);

        row = new JPanel(new BorderLayout());
        row.add(pn1, BorderLayout.WEST);
        row.setBackground(null);
        row.setPreferredSize(new Dimension(100, 304));

        //column_ClassTable
        DefaultTableModel model = new DefaultTableModel(schedule, time_column);
        table_column = new JTable(model);
        table_column.setEnabled(false);
        table_column.setPreferredSize(new Dimension(800,384));
        table_column.setRowHeight(48);
        table_column.setBorder(BorderFactory.createLineBorder(Config.bgColor_hard));
        table_column.setGridColor(Config.bgColor_hard);

        table_column.setForeground(Color.WHITE);

        table_column.setBackground(null);
        column = new JPanel(new BorderLayout());
        column.add(table_column);
        column.setBorder(BorderFactory.createEmptyBorder(0,-1,0,0));
        column.setBackground(null);

        DefaultTableCellRenderer Renderer2 = new DefaultTableCellRenderer();
        Renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table_column.getColumnCount(); i++) {
            table_column.getColumnModel().getColumn(i).setCellRenderer(Renderer);
        }

        //combine
        com = new JPanel();
        com.setLayout(new BorderLayout());
        com.setBackground(null);
        com.setPreferredSize(new Dimension(1000, 394));
        com.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 50));
        com.add(row, BorderLayout.WEST);
        com.add(column);
        this.setLayout(new FlowLayout());
        this.add(com);
        this.setBackground(null);
    }
}
