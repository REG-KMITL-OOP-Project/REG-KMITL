package dev.it22.kmitl.reg.ui.request;

import dev.it22.kmitl.reg.controller.request.UserRequestController;
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
    UserRequestController ctl = new UserRequestController();

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
        tableModel.setRowCount(0);
        Vector<Vector<String>> data = ctl.getPendingRequests();
        for (Vector<String> row : data) {
            tableModel.addRow(row);
        }
    }

    public static void main(String[] args) {
        new UserRequestView(Config.createAndShowGUI());
    }
}