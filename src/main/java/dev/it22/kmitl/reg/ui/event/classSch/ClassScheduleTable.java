package dev.it22.kmitl.reg.ui.event.classSch;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.SQLException;

public class ClassScheduleTable extends JPanel {
    private JPanel row, column, com;
    private JScrollPane scroll, scroll_1;
    private JTable table_day, table_column;
    private String day_time_column[] = {"     "};
    private String day[][] = {{"วันจันทร์"}, {"วันอังคาร"}, {"วันพุธ"}, {"วันพฤหัสบดี"}, {"วันศุกร์"}, {"วันเสาร์"}, {"วันอาทิตย์"}};
    private String time_column[] = {"08.00-09.00", "09.00-10.00", "10.00-11.00", "11.00-12.00", "12.00-13.00", "13.00-14.00", "14.00-15.00", "15.00-16.00", "16.00-17.00", "17.00-18.00", "18.00-19.00", "19.00-20.00"};
    private String[][] schedule;

    public ClassScheduleTable(JFrame frame) {
        try {
            ClassData subject = new ClassData();
            schedule = new String[7][12];
            schedule[0] = subject.getSubject("MON");
            schedule[1] = subject.getSubject("TUE");
            schedule[2] = subject.getSubject("WED");
            schedule[3] = subject.getSubject("THU");
            schedule[4] = subject.getSubject("FRI");
            schedule[5] = subject.getSubject("SAT");
            schedule[6] = subject.getSubject("SUN");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DefaultTableModel model_day = new DefaultTableModel(day, day_time_column);
        table_day = new JTable(model_day);
        table_day.setRowHeight(frame.getHeight() / 15);
        table_day.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        table_day.setGridColor(Color.WHITE);
        table_day.setFont(Config.NORMAL_REGULAR);
        table_day.setEnabled(false);
        table_day.setBackground(Color.WHITE);
        table_day.setShowHorizontalLines(false);
        table_day.setPreferredSize(new Dimension(frame.getWidth() / 11, frame.getHeight() / 2));

        JTableHeader header = table_day.getTableHeader();
        header.setPreferredSize(new Dimension(table_day.getPreferredSize().width, frame.getHeight() / 28));
        header.setBackground(Config.primaryColor_hard);
        header.setForeground(Color.WHITE);
        header.setFont(Config.HEADER_SEMIBOLD[3]);
        header.setResizingAllowed(false);
        header.setReorderingAllowed(false);

        scroll = new JScrollPane(table_day);
        scroll.setBorder(null);
        row = new JPanel(new BorderLayout());
        row.add(scroll);
        row.setBackground(Color.cyan);
        row.setBorder(new EmptyBorder(-6, 0, 0, 0));
        row.setPreferredSize(new Dimension(frame.getWidth() / 11, frame.getHeight() / 2));

        DefaultTableModel model = new DefaultTableModel(schedule, time_column);
        table_column = new JTable(model);
        table_column.setEnabled(false);
        table_column.setRowHeight(frame.getHeight() / 15);
        table_column.setBorder(BorderFactory.createLineBorder(Config.bgColor_base.darker()));
        table_column.setGridColor(Config.bgColor_base);
        table_column.setFont(Config.NORMAL_REGULAR);
        table_column.setForeground(Color.white);
        table_column.setBackground(Config.bgColor_base.darker());
        table_column.setPreferredSize(new Dimension(frame.getWidth(), table_column.getRowHeight() * 7));

        JTableHeader header_c = table_column.getTableHeader();
        header_c.setPreferredSize(new Dimension(header.getPreferredSize().width, header.getPreferredSize().height));
        header_c.setBackground(Config.primaryColor_hard);
        header_c.setForeground(Color.WHITE);
        header_c.setFont(Config.HEADER_SEMIBOLD[3]);
        header_c.setBorder(null);
        header_c.setReorderingAllowed(false);

        scroll_1 = new JScrollPane(table_column);
        scroll_1.setBackground(Config.bgColor_base.darker());
        scroll_1.setBorder(null);
        scroll_1.setPreferredSize(new Dimension(frame.getWidth(), table_column.getRowHeight() * 8));

        com = new JPanel(new BorderLayout());
        com.setBackground(null);
        com.setPreferredSize(new Dimension(frame.getWidth() - frame.getWidth() / 15, table_column.getRowHeight() * 8 + header_c.getPreferredSize().height));
        com.setBorder(BorderFactory.createEmptyBorder(0, 0, 35, 0));
        com.add(row, BorderLayout.WEST);
        com.add(scroll_1);

        this.setLayout(new FlowLayout());
        this.setBackground(null);
        this.setPreferredSize(new Dimension(frame.getWidth() - frame.getWidth() / 11, table_column.getRowHeight() * 8));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 35, 0));
        this.add(com);
    }
}
