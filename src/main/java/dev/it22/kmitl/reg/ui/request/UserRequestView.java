package dev.it22.kmitl.reg.ui.request;

import dev.it22.kmitl.reg.controller.request.UserRequestController;
import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class UserRequestView {
    JFrame frame;
    JPanel upperPanel, lowerPanel, buttonPanel;
    JLabel showLabel;
    RoundedButton returnBtn, approveButton, rejectButton;
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
        upperPanel.setBackground(null);
        upperPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 50));
        upperPanel.add(Config.createLogoAndTitle(Config.HEADER_SEMIBOLD[3], 50), BorderLayout.WEST);

        JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        returnPanel.setBackground(null);
        returnPanel.setBorder(BorderFactory.createEmptyBorder(35, 20, 0, 0));
        returnBtn = new RoundedButton("", 20);
        returnBtn.setBackground(Config.primaryColor_base);
        returnBtn.setIcon(new ImageIcon(new ImageIcon("source/undo.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
        returnBtn.setPreferredSize(new Dimension(40, 40));
        returnBtn.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new HomePage(frame);
        });
        returnPanel.add(returnBtn);
        upperPanel.add(returnPanel, BorderLayout.EAST);
        frame.add(upperPanel, BorderLayout.NORTH);

        // Lower Panel
        lowerPanel = new JPanel(new BorderLayout());
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));
        lowerPanel.setBackground(null);

        showLabel = new JLabel("List of Request");
        showLabel.setFont(Config.HEADER_SEMIBOLD[0]);
        showLabel.setForeground(Color.WHITE);
        lowerPanel.add(showLabel, BorderLayout.NORTH);

        // Table Setup
        String[] columns = {"Request ID", "User Email", "Field Name", "Current Value", "New Value", "Status", "Created At"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setForeground(Color.WHITE);
        table.setFont(Config.NORMAL_REGULAR);

        scrollPane = new JScrollPane(table);
        scrollPane.setBackground(Config.bgColor_hard);
        lowerPanel.add(scrollPane, BorderLayout.CENTER);

        // Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setBackground(null);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        approveButton = new RoundedButton("Approve",20);
        approveButton.setBackground(Config.primaryColor_base);
        approveButton.setEnabled(false);  // ปุ่มจะถูกปิดใช้งานเมื่อไม่มีแถวที่เลือก
        approveButton.addActionListener(e -> approveRequest());
        approveButton.setForeground(Color.WHITE);
        approveButton.setFont(Config.HEADER_SEMIBOLD[2]);
        approveButton.setPreferredSize(new Dimension(120, 40));
        buttonPanel.add(approveButton);

        rejectButton = new RoundedButton("Reject",20);
        rejectButton.setBackground(Config.primaryColor_base);
        rejectButton.setEnabled(false);  // ปุ่มจะถูกปิดใช้งานเมื่อไม่มีแถวที่เลือก
        rejectButton.addActionListener(e -> rejectRequest());
        rejectButton.setForeground(Color.WHITE);
        rejectButton.setFont(Config.HEADER_SEMIBOLD[2]);
        rejectButton.setPreferredSize(new Dimension(120, 40));
        buttonPanel.add(rejectButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(lowerPanel, BorderLayout.CENTER);
        frame.setVisible(true);

        // Set Row Selection Listener
        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                approveButton.setEnabled(true);
                rejectButton.setEnabled(true);
            } else {
                approveButton.setEnabled(false);
                rejectButton.setEnabled(false);
            }
        });

        loadData();
    }

    private void loadData() {
        tableModel.setRowCount(0);
        Vector<Vector<String>> data = ctl.getPendingRequests();
        for (Vector<String> row : data) {
            tableModel.addRow(row);
        }
    }

    private void approveRequest() {
        int row = table.getSelectedRow();
        if (row != -1) {
            int requestId = Integer.parseInt(table.getValueAt(row, 0).toString());  // Get Request ID
            String email = table.getValueAt(row, 1).toString();
            String fieldName = table.getValueAt(row, 2).toString();
            String newValue = table.getValueAt(row, 4).toString();
            ctl.approveRequest(requestId, email, fieldName, newValue);
            loadData();
        }
    }

    private void rejectRequest() {
        int row = table.getSelectedRow();
        if (row != -1) {
            int requestId = Integer.parseInt(table.getValueAt(row, 0).toString());  // Get Request ID
            ctl.rejectRequest(requestId);
            loadData();
        }
    }

    public static void main(String[] args) {
        new UserRequestView(Config.createAndShowGUI());
    }
}
