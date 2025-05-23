package dev.it22.kmitl.reg.ui.event.classSch;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.SQLException;

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
    private String time_column[] = {"08.00-09.00", "09.00-10.00", "10.00-11.00", "11.00-12.00", "12.00-13.00", "13.00-14.00", "14.00-15.00", "15.00-16.00", "16.00-17.00", "17.00-18.00", "18.00-19.00", "19.00-20.00"};
    String[][] schedule;

    //combine
    private JPanel com;

    public ClassScheduleTable(JFrame frame) {
        try{
            classData subject = new classData();
            schedule = new String[7][1];
            //schedule[0] = subject.getSubject();
            schedule[0] = subject.getSubject("MON");
            schedule[1] = subject.getSubject("TUE");
            schedule[2] = subject.getSubject("WED");
            schedule[3] = subject.getSubject("THU");
            schedule[4] = subject.getSubject("FRI");
            schedule[5] = subject.getSubject("SAT");
            schedule[6] = subject.getSubject("SU");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //rowOFDay_ClassTable
        DefaultTableModel model_day = new DefaultTableModel(day, day_time_column);
        table_day = new JTable(model_day);
        //table_day.setRowHeight(48);
        table_day.setRowHeight(frame.getHeight() / 15);
        table_day.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        table_day.setGridColor(Color.WHITE);
        table_day.setFont(Config.NORMAL_REGULAR);
        table_day.setEnabled(false);
        table_day.setBorder(BorderFactory.createEmptyBorder(0,-5,-10,-3));
        table_day.setBackground(Color.WHITE);
        table_day.setShowHorizontalLines(false);
        //table_day.setPreferredSize(new java.awt.Dimension(100, 414));
        table_day.setPreferredSize(new java.awt.Dimension(frame.getWidth() / (frame.getWidth()/110), frame.getHeight()/ (frame.getHeight()/432)));

        DefaultTableCellRenderer Renderer = new DefaultTableCellRenderer();
        Renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table_day.getColumnCount(); i++) {
            table_day.getColumnModel().getColumn(i).setCellRenderer(Renderer);
        }

        JTableHeader header = table_day.getTableHeader();
        header.setPreferredSize(new Dimension(table_day.getPreferredSize().width,frame.getHeight()/28));
        header.setBackground(Config.primaryColor_hard);
        header.setForeground(Color.WHITE);
        header.setBorder(null);
        header.setFont(Config.HEADER_SEMIBOLD[3]);
        header.setResizingAllowed(false);
        header.setReorderingAllowed(false);

        scroll = new JScrollPane(table_day);
        scroll.setBackground(null);
        scroll.setBorder(null);

        pn1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pn1.setBorder(null);
        pn1.add(scroll);
        //pn1.setPreferredSize(new Dimension(100, 389));
        pn1.setPreferredSize(new Dimension(frame.getWidth() / (frame.getWidth()/100), frame.getHeight()/ (frame.getHeight()/389)));
        pn1.setBackground(null);

        row = new JPanel(new BorderLayout());
        //row.setBorder(null);
        row.add(pn1);
        row.setBackground(Color.cyan);
        row.setBorder(new EmptyBorder(-6,0,0,0));
        //row.setPreferredSize(new Dimension(100, 389));
        row.setPreferredSize(new Dimension(frame.getWidth() / (frame.getWidth()/100), frame.getHeight()/ (frame.getHeight()/389)));

        //column_ClassTable
        DefaultTableModel model = new DefaultTableModel(schedule, time_column);
        table_column = new JTable(model);
        table_column.setEnabled(false);
        table_column.setRowHeight(frame.getHeight() / 15);
        table_column.setBorder(BorderFactory.createLineBorder(Config.bgColor_base.darker()));
        table_column.setGridColor(Config.bgColor_base);
        table_column.setFont(Config.NORMAL_REGULAR);
        table_column.setForeground(Color.white);
        table_column.setShowGrid(true);
        table_column.setBorder(BorderFactory.createEmptyBorder(0,-5,10,-3));
        table_column.setBackground(Config.bgColor_base.darker());
        //table_column.setPreferredSize(new Dimension(1300,334));
        table_column.setPreferredSize(new Dimension((int)(frame.getWidth() / (double)(frame.getWidth()/1300)),table_column.getRowHeight() * 7));
        //table_column.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_column.getTableHeader().setResizingAllowed(true);

        JTableHeader header_c = table_column.getTableHeader();
        //header_c.setPreferredSize(new Dimension(30,30));
        header_c.setPreferredSize(new Dimension(header.getPreferredSize().width,header.getPreferredSize().height));
        header_c.setBackground(Config.primaryColor_hard);
        header_c.setForeground(Color.WHITE);
        header_c.setFont(Config.HEADER_SEMIBOLD[3]);
        header_c.setBorder(null);
        header_c.setReorderingAllowed(false);

        DefaultTableCellRenderer Renderer2 = new DefaultTableCellRenderer();
        Renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table_column.getColumnCount(); i++) {
            table_column.getColumnModel().getColumn(i).setCellRenderer(Renderer);
            //table_column.getColumnModel().getColumn(i).setPreferredWidth(frame.getWidth() / 4);
        }

        JPanel t_c = new JPanel(new BorderLayout());
        t_c.setBackground(null);
        t_c.setBorder(null);
        //t_c.setPreferredSize(new Dimension(1300,335));
        t_c.setPreferredSize(new Dimension(frame.getWidth(), table_column.getRowHeight() * 7));
        t_c.add(header_c, BorderLayout.NORTH);
        t_c.add(table_column, BorderLayout.CENTER);

        scroll_1 = new JScrollPane(t_c);

        scroll_1.setBackground(Config.bgColor_base.darker());
        scroll_1.setBorder(null);
        scroll_1.setPreferredSize(new Dimension((int)(frame.getHeight() / (double)(frame.getHeight()/1000)), table_column.getRowHeight() * 8));
        //scroll_1.setPreferredSize(new Dimension(1000,414));


        //combine
        com = new JPanel();
        com.setLayout(new BorderLayout());
        com.setBackground(null);
        //com.setPreferredSize(new Dimension(1100, 414));
        com.setPreferredSize(new Dimension(frame.getWidth() - (frame.getWidth()/15), (table_column.getRowHeight() * 8) + header_c.getPreferredSize().height));
        com.setBorder(BorderFactory.createEmptyBorder(0, 0, 35, 0));
        com.add(row, BorderLayout.WEST);
        com.add(scroll_1);

        this.setLayout(new FlowLayout());
        this.setBackground(null);
        //this.setPreferredSize(new Dimension(1100, 414));
        this.setPreferredSize(new Dimension(frame.getWidth() - (frame.getWidth()/11), table_column.getRowHeight() * 8));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 35, 0));
        this.add(com);

    }

}
