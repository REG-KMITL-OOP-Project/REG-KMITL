package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class calendarTable extends JTable {
    //rowOFDay_ClassTable
    private JPanel row;
    private JTable table_Month;
    private JPanel panel, pn1;
    private String[] day_month_column = {""};

    //column_ClassTable
    private JPanel column;
    private JTable table_column;
    private String event_column[] = {"date", "type", "event name"};
    String[][] events = {
            {"09/08/68", "Holiday", "Monk day"},
            {"09/08/68", "Holiday", "Monk day"},
            {"09/08/68", "Holiday", "Monk day"},
    };

    //combine
    private JPanel com;

    public calendarTable(String month){

        //column_ClassTable
        DefaultTableModel model = new DefaultTableModel(events, event_column);
        table_column = new JTable(model);
        table_column.setEnabled(false);
        table_column.setRowHeight(48);
        table_column.setPreferredSize(new Dimension(event_column.length * 200,48 * events.length));
        table_column.setBorder(BorderFactory.createLineBorder(Config.bgColor_hard));
        table_column.setGridColor(Config.bgColor_hard);

        table_column.setForeground(Color.WHITE);

        table_column.setBackground(null);
        column = new JPanel(new BorderLayout());
        column.add(table_column);
        column.setBorder(BorderFactory.createEmptyBorder(0,-1,0,0));
        column.setBackground(null);


        //rowOfMonth_ClassTable
        String[][] month_row = {{"               " + month}};
        DefaultTableModel model_day = new DefaultTableModel(month_row, day_month_column);
        table_Month = new JTable(model_day);
        table_Month.setRowHeight(table_column.getPreferredSize().height);
        table_Month.setBorder(BorderFactory.createLineBorder(Config.bgColor_hard));
        table_Month.setGridColor(Config.bgColor_hard);
        table_Month.setEnabled(false);
        table_Month.setBorder(BorderFactory.createEmptyBorder(5,-5,-10,-3));

        pn1 = new JPanel(new BorderLayout());
        pn1.add(table_Month);
        pn1.setPreferredSize(new Dimension(150, table_column.getPreferredSize().height));
        //pn1.setPreferredSize(new Dimension(100, 384));

        //ปิดเส้นแกน x ระหว่างตาราง
        table_Month.setShowHorizontalLines(false);

        //table_day.setForeground(Config.primaryColor_harder);
        //table_day.setBackground(null);
        pn1.setBackground(null);

        row = new JPanel(new BorderLayout());
        row.add(pn1, BorderLayout.WEST);
        row.setBackground(null);
        row.setPreferredSize(new Dimension(150, table_column.getPreferredSize().height));



        //combine
        com = new JPanel();
        com.setLayout(new BorderLayout());
        com.setBackground(null);
        com.setPreferredSize(new Dimension(1050, table_column.getPreferredSize().height + 10));
        com.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 50));
        com.add(row, BorderLayout.WEST);
        com.add(column);
        this.setLayout(new FlowLayout());
        this.add(com);
        this.setBackground(null);
    }
}
