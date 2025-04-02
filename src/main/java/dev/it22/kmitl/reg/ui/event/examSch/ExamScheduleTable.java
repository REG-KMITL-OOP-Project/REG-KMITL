package dev.it22.kmitl.reg.ui.event.examSch;

import dev.it22.kmitl.reg.ui.event.component.SeletedItemCombobox;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.SQLException;

public class ExamScheduleTable extends JPanel {

    private JTable examSchedule;
    private JScrollPane scrollPane;
    private String[] columnNames = {"วัน/เดือน/ปี", "เวลา", "รหัสวิชา", "วิชา", "ประเภท", "ห้องสอบ"};
    private ExamTableData data;
    private String year, semester;

    public ExamScheduleTable(JFrame frame, SeletedItemCombobox comboBoxHandler) {
        try {
            data = new ExamTableData();
            year = comboBoxHandler.getYearItem();
            semester = comboBoxHandler.getSemItem();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DefaultTableModel model = new DefaultTableModel(data.getData(year, semester), columnNames);
        examSchedule = createTable(model, frame);
        scrollPane = new JScrollPane(examSchedule);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
    }

    // Helper function to create and style tables
    private JTable createTable(DefaultTableModel model, JFrame frame) {
        JTable table = new JTable(model);
        table.setRowHeight(30); // Adjusted for uniformity
        table.setFont(Config.NORMAL_REGULAR.deriveFont(15f)); // Same font size as ClassScheduleTable
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
