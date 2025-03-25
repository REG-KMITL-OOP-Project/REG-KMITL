package dev.it22.kmitl.reg.ui.request;

import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.Database;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Vector;

public class UserRequestView {
    JFrame frame;
    JPanel upperPanel, lowerPanel;
    JLabel showLabel;
    RoundedButton returnBtn;
    DefaultTableModel tableModel;
    JTable table;
    JScrollPane scrollPane;

    public UserRequestView(JFrame frame) {
        this.frame = frame;
        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());

        // Upper Panel
        upperPanel = new JPanel(new BorderLayout());
        upperPanel.setBackground(Config.bgColor_hard);
        upperPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        upperPanel.add(Config.createLogoAndTitle(Config.HEADER_SEMIBOLD[3], 50), BorderLayout.WEST);

        returnBtn = new RoundedButton("", 20);
        returnBtn.setIcon(new ImageIcon(new ImageIcon("source/undo.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        returnBtn.setPreferredSize(new Dimension(50, 50));
        returnBtn.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new HomePage(frame);
        });
        upperPanel.add(returnBtn, BorderLayout.EAST);
        frame.add(upperPanel, BorderLayout.NORTH);

        // Lower Panel
        lowerPanel = new JPanel(new BorderLayout());
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        lowerPanel.setBackground(Config.bgColor_hard);

        showLabel = new JLabel("List of Request");
        showLabel.setFont(Config.HEADER_SEMIBOLD[0]);
        showLabel.setForeground(Color.WHITE);
        lowerPanel.add(showLabel, BorderLayout.NORTH);

        // Table Setup
        String[] columns = {"Request ID", "User Email", "Field Name", "Current Value", "New Value", "Status", "Created At"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setBackground(Config.bgColor_hard);
        table.setForeground(Color.WHITE);
        scrollPane = new JScrollPane(table);
        lowerPanel.add(scrollPane, BorderLayout.CENTER);

        loadData();

        frame.add(lowerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void loadData() {
        Database db = new Database();
        try {
            ResultSet rs = db.getQuery("SELECT id, email, field_name, old_value, new_value, status, created_at FROM user_request WHERE status = 'pending'");
            tableModel.setRowCount(0);

            while (rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(String.valueOf(rs.getInt("id")));
                row.add(rs.getString("email"));
                row.add(rs.getString("field_name"));
                row.add(rs.getString("old_value"));
                row.add(rs.getString("new_value"));
                row.add(rs.getString("status"));
                row.add(rs.getTimestamp("created_at").toString());
                tableModel.addRow(row);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UserRequestView(Config.createAndShowGUI());
    }
}