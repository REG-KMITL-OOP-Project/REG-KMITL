package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

public class ClassScheduleTable extends JPanel{
    //rowOFDay_ClassTable
    private JPanel row;
    private JScrollPane scroll;
    private JTable table_day;
    private JPanel panel, pn1;
    private String day_time_column[] = {"     "};
    private String day[][] = {{"วันจันทร์"},{"วันอังคาร"},{"วันพุธ"},{"วันพฤหัสบดี"},{"วันศุกร์"},{"วันเสาร์"},{"วันอาทิตย์"}};

    //column_ClassTable
    private JPanel column;
    private JScrollPane scroll_1;
    private JTable table_column;
    private String time_column[] = {"08.00", "09.00", "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00", "20.00"};
    String[][] schedule = {
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
        table_day.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        table_day.setGridColor(Color.WHITE);
        table_day.setFont(Config.NORMAL_REGULAR);
        table_day.setEnabled(false);
        table_day.setBorder(BorderFactory.createEmptyBorder(5,-5,-10,-3));
        table_day.setBackground(Color.WHITE);
        table_day.setShowHorizontalLines(false);

        DefaultTableCellRenderer Renderer = new DefaultTableCellRenderer();
        Renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table_day.getColumnCount(); i++) {
            table_day.getColumnModel().getColumn(i).setCellRenderer(Renderer);
        }

        JTableHeader header = table_day.getTableHeader();
        header.setPreferredSize(new Dimension(30,30));
        header.setBackground(Config.primaryColor_hard);
        header.setForeground(Color.WHITE);
        header.setBorder(null);
        header.setFont(Config.HEADER_SEMIBOLD[3]);
        header.setPreferredSize(new Dimension(100, 30));

        scroll = new JScrollPane(table_day);
        scroll.setBackground(Color.WHITE);
        scroll.setBorder(null);

        pn1 = new JPanel(new BorderLayout());
        pn1.add(scroll);
        pn1.setPreferredSize(new Dimension(100, 379));
        pn1.setBackground(Color.WHITE);

        row = new JPanel(new BorderLayout());
        row.add(pn1, BorderLayout.WEST);
        row.setBackground(Color.WHITE);
        row.setPreferredSize(new Dimension(100, 379));

        //column_ClassTable
        DefaultTableModel model = new DefaultTableModel(schedule, time_column);
        table_column = new JTable(model);
        table_column.setEnabled(false);
        table_column.setRowHeight(48);
        table_column.setBorder(BorderFactory.createLineBorder(Config.bgColor_base.darker()));
        table_column.setGridColor(Config.bgColor_base);
        table_column.setFont(Config.NORMAL_REGULAR);
        table_column.setForeground(Color.white);
        table_column.setShowGrid(true);
        table_column.setBackground(Config.bgColor_base.darker());
        table_column.setPreferredSize(new Dimension(1000,335));

        JTableHeader header_c = table_column.getTableHeader();
        header_c.setPreferredSize(new Dimension(30,30));
        header_c.setBackground(Config.primaryColor_hard);
        header_c.setForeground(Color.WHITE);
        header_c.setFont(Config.HEADER_SEMIBOLD[3]);
        header_c.setPreferredSize(new Dimension(100, 30));
        header_c.setBorder(null);
        header_c.setReorderingAllowed(false);
        header_c.setResizingAllowed(false);

        DefaultTableCellRenderer Renderer2 = new DefaultTableCellRenderer();
        Renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table_column.getColumnCount(); i++) {
            table_column.getColumnModel().getColumn(i).setCellRenderer(Renderer);
        }

        scroll_1 = new JScrollPane(table_column);
        scroll_1.setBackground(Config.bgColor_base.darker());
        scroll_1.setBorder(null);

        column = new JPanel(new BorderLayout());
        column.add(scroll_1);
        column.setBorder(null);
        column.setBorder(BorderFactory.createEmptyBorder(0,-1,0,0));
        column.setBackground(Config.bgColor_base.darker());

        //combine
        com = new JPanel();
        com.setLayout(new BorderLayout());
        com.setBackground(null);
        com.setPreferredSize(new Dimension(1200, 379)); //384
        com.setBorder(BorderFactory.createEmptyBorder(0, 0, 35, 0));
        com.add(row, BorderLayout.WEST);
        com.add(column);


        this.setLayout(new BorderLayout());
        this.add(com);
        JPanel pL = new JPanel();
        JPanel pR = new JPanel();
        pL.setBackground(null);
        pR.setBackground(null);
        this.add(pL, BorderLayout.WEST);
        this.add(pR, BorderLayout.EAST);
        //this.setPreferredSize(new Dimension(1200, 379));
        this.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        this.setBackground(null);
    }

}
