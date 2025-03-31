package dev.it22.kmitl.reg.ui.admin;

import dev.it22.kmitl.reg.controller.user.UserController;
import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class UserManagement {
    JFrame frame;
    DefaultTableModel tableModel;
    JTable table;
    UserController ctl = new UserController();

    public UserManagement(JFrame frame) {
        this.frame = frame;
        frame.setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = createHeaderPanel();
        frame.add(headerPanel, BorderLayout.NORTH);

        // Body
        JPanel bodyPanel = createBodyPanel();
        frame.add(bodyPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Config.bgColor_hard);
        headerPanel.setPreferredSize(new Dimension(frame.getWidth(), 80));

        // Logo
        JPanel logoPanel = Config.createLogoAndTitle(Config.NORMAL_REGULAR, 40);
        headerPanel.add(logoPanel, BorderLayout.WEST);

        // ปุ่มแจ้งเตือน และ Home
        JPanel headerButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        headerButtonPanel.setBackground(Config.bgColor_hard);
        headerButtonPanel.setBorder(new EmptyBorder(40, 0, 10, 50));

        RoundedButton notificationBtn = createButton("source/icon_schedule/bell.png", Color.WHITE);
        RoundedButton homeBtn = createButton("source/icon_schedule/house.png", Config.primaryColor_hard);
        homeBtn.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new HomePage(frame);
        });

        headerButtonPanel.add(notificationBtn);
        headerButtonPanel.add(homeBtn);

        headerPanel.add(headerButtonPanel, BorderLayout.EAST);
        return headerPanel;
    }

    private JPanel createBodyPanel() {
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BorderLayout());
        bodyPanel.setBackground(Config.bgColor_hard);
        bodyPanel.setBorder(new EmptyBorder(20, 50, 50, 50));

        // Title + ปุ่มเพิ่มผู้ใช้
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Config.bgColor_hard);

        JLabel titleLabel = new JLabel("Users");
        titleLabel.setFont(Config.HEADER_SEMIBOLD[0]);
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel, BorderLayout.WEST);

        RoundedButton createBtn = new RoundedButton("+ เพิ่มผู้ใช้", 10);
        createBtn.setFont(Config.HEADER_SEMIBOLD[2]);
        createBtn.setForeground(Color.WHITE);
        createBtn.setPreferredSize(new Dimension(150, 40));
        createBtn.setBackground(Config.primaryColor_hard);
        createBtn.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminCreateUserPortal(frame);
        });

        JPanel createBtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        createBtnPanel.setBackground(Config.bgColor_hard);
        createBtnPanel.add(createBtn);
        titlePanel.add(createBtnPanel, BorderLayout.EAST);

        bodyPanel.add(titlePanel, BorderLayout.NORTH);

        // Table Setup
        String[] columns = {"ID", "Role", "Student ID", "Professor ID", "Section", "Email", "Prefix", "First Name", "Last Name", "Faculty", "Major", "Address", "Phone Number"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setFont(Config.NORMAL_REGULAR);

        JScrollPane scrollPane = new JScrollPane(table);
        bodyPanel.add(scrollPane, BorderLayout.CENTER);

        loadData();
        return bodyPanel;
    }

    private RoundedButton createButton(String iconPath, Color backgroundColor) {
        RoundedButton button = new RoundedButton("", 20);
        button.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
        button.setBackground(backgroundColor);
        return button;
    }

    public void loadData() {
        tableModel.setRowCount(0);
        for (Vector<String> row : ctl.getAllUser()) {
            tableModel.addRow(row);
        }
    }

    public static void main(String[] args) {
        new UserManagement(Config.createAndShowGUI());
    }
}
