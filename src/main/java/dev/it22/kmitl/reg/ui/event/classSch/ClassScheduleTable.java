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
    private JScrollPane scroll;
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

        // Day Table
        DefaultTableModel model_day = new DefaultTableModel(day, day_time_column);
        table_day = createTable(model_day, frame);
        scroll = new JScrollPane(table_day);
        scroll.setBorder(null);

        JPanel row = new JPanel(new BorderLayout());
        row.add(scroll);
        row.setBackground(Config.bgColor_base);
        row.setPreferredSize(new Dimension(frame.getWidth() / 11, frame.getHeight() / 2));

        // Schedule Table
        DefaultTableModel model_schedule = new DefaultTableModel(schedule, time_column);
        table_column = createTable(model_schedule, frame);

        JScrollPane scroll_1 = new JScrollPane(table_column);
        scroll_1.setBackground(Config.bgColor_base.darker());
        scroll_1.setBorder(null);

        JPanel com = new JPanel(new BorderLayout());
        com.setBackground(null);
        com.setPreferredSize(new Dimension(frame.getWidth() - frame.getWidth() / 15, frame.getHeight() / 2));
        com.add(row, BorderLayout.WEST);
        com.add(scroll_1, BorderLayout.CENTER);

        this.setLayout(new FlowLayout());
        this.setBackground(null);
        this.add(com);
    }

    // Helper function to create and style tables

    private JTable createTable(DefaultTableModel model, JFrame frame) {
        JTable table = new JTable(model);
        table.setRowHeight(30); // Adjusted for uniformity
        table.setFont(Config.NORMAL_REGULAR.deriveFont(15f)); // Same font size as ExamScheduleTable
        table.setGridColor(Config.bgColor_base.darker());
        table.setShowGrid(true);
        table.setForeground(Color.white);
        table.setBackground(Config.bgColor_base.darker()); // Adjusted for consistency

        JTableHeader header = table.getTableHeader();
        header.setBackground(Config.primaryColor_hard);
        header.setForeground(Color.WHITE);
        header.setFont(Config.HEADER_SEMIBOLD[3]);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        return table;
    }
}
