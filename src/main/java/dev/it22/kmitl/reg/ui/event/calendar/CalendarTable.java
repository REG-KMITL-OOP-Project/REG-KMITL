package dev.it22.kmitl.reg.ui.event.calendar;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class CalendarTable extends JPanel {
    //rowOFDay_ClassTable
    private JPanel row;
    private JTable table_Month;
    private JPanel panel, pn1;
    private String[] day_month_column = {""};

    //column_ClassTable
    private JPanel column;
    private JTable table_column;
    private String event_column[] = {"date", "event name", "type",};
    private String[][] events;


    //combine
    private JPanel com;

    private JFrame frame;

    public CalendarTable(String month) {
        this(month,Config.createAndShowGUI(),null);
    }

    public CalendarTable(String month, String[][] events_data) {
        this(month, Config.createAndShowGUI(), events_data);
    }

    public CalendarTable(String month, JFrame frame, String[][] events_data) {
        this.frame = frame;

        if (events_data.length > 0) {
            events = events_data;
        }
        else{
            events = new String[][]{};
        }


        //column_ClassTable
        DefaultTableModel model = new DefaultTableModel(events, event_column);
        table_column = new JTable(model);
        table_column.setEnabled(false);
        //table_column.setRowHeight(48);
        table_column.setRowHeight(frame.getHeight() / 12);
        table_column.setBorder(BorderFactory.createLineBorder(Config.bgColor_hard));
        table_column.setGridColor(Config.bgColor_harder);

        table_column.setFont(Config.NORMAL_REGULAR);
        table_column.setForeground(Color.WHITE);

        DefaultTableCellRenderer Renderer2 = new DefaultTableCellRenderer();
        Renderer2.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table_column.getColumnCount(); i++) {
            table_column.getColumnModel().getColumn(i).setCellRenderer(Renderer2);
        }

        TableColumn day = table_column.getColumnModel().getColumn(0);
        //day.setPreferredWidth(100);
        day.setPreferredWidth(frame.getWidth() / 14);
        TableColumn type = table_column.getColumnModel().getColumn(1);
        //type.setPreferredWidth(230);
        type.setPreferredWidth((frame.getWidth() / 8)+(frame.getWidth()/40));
        TableColumn event = table_column.getColumnModel().getColumn(2);
        //event.setPreferredWidth(100);
        event.setPreferredWidth(frame.getWidth() / 14);

        table_column.setShowVerticalLines(true);
        table_column.setShowHorizontalLines(true);
        table_column.setBackground(Config.bgColor_hard);
        column = new JPanel(new BorderLayout());
        column.add(table_column);
        column.setBorder(BorderFactory.createEmptyBorder(0,-1,0,0));
        column.setBackground(Config.bgColor_hard);
        column.setBorder(BorderFactory.createLineBorder(Config.bgColor_harder));


        //rowOfMonth_ClassTable
        String[][] month_row = {{month}};
        DefaultTableModel model_day = new DefaultTableModel(month_row, day_month_column);
        table_Month = new JTable(model_day);
        table_Month.setRowHeight(table_column.getPreferredSize().height);
        table_Month.setBorder(BorderFactory.createLineBorder(Config.bgColor_hard));
        table_Month.setGridColor(Config.bgColor_hard);
        table_Month.setEnabled(false);
        table_Month.setBorder(BorderFactory.createEmptyBorder(5,-5,-10,-3));
        table_Month.setFont(Config.HEADER_SEMIBOLD[2]);


        DefaultTableCellRenderer Renderer = new DefaultTableCellRenderer();
        Renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table_Month.getColumnCount(); i++) {
            table_Month.getColumnModel().getColumn(i).setCellRenderer(Renderer);
        }

        pn1 = new JPanel(new BorderLayout());
        pn1.add(table_Month);
        pn1.setPreferredSize(new Dimension(frame.getWidth()/10, table_column.getPreferredSize().height));

        //pn1.setBorder(BorderFactory.createLineBorder(Config.bgColor_hard));
        table_Month.setForeground(Config.primaryColor_base);
        table_Month.setBackground(Config.bgColor_hard);
        pn1.setBackground(Config.bgColor_hard);

        row = new JPanel(new BorderLayout());
        row.add(pn1, BorderLayout.WEST);
        row.setBackground(null);
        row.setPreferredSize(new Dimension(pn1.getPreferredSize().width, table_column.getPreferredSize().height));


        //combine
        com = new JPanel();
        com.setLayout(new BorderLayout());
        com.setBackground(null);
        com.setPreferredSize(new Dimension(frame.getWidth() - (frame.getWidth()/ 4) - (frame.getWidth()/53), table_column.getPreferredSize().height + 10));
        //com.setPreferredSize(new Dimension(900, table_column.getPreferredSize().height + 10));
        com.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 50));
        com.add(row, BorderLayout.WEST);
        com.add(column);
        this.setLayout(new FlowLayout());
        this.add(com);
        this.setBackground(null);
    }

    public JTable getTable() {
        return table_column;
    }

}
