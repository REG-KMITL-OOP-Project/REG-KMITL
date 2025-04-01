package dev.it22.kmitl.reg.ui.admin;

import dev.it22.kmitl.reg.controller.user.AdminCreateUser;
import dev.it22.kmitl.reg.controller.user.UserController;
import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.ui.request.UserRequestView;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class UserManagement {
    JFrame frame;
    JPanel upperPanel , lowerPanel , btnPanel , uplowPanel , innerPanel;
    RoundedButton reqBtn , homeBtn , addBtn;
    JLabel title;
    DefaultTableModel tableModel;
    JTable table;
    UserController ctl = new UserController();

    public UserManagement(JFrame frame) {
        this.frame = frame;
        frame.setLayout(new BorderLayout());

        upperPanel = new JPanel(new BorderLayout());
        upperPanel.setBorder(new EmptyBorder(10, 0, 10, 50));
        upperPanel.setBackground(null);
        upperPanel.add(Config.createLogoAndTitle(Config.HEADER_SEMIBOLD[3],50), BorderLayout.WEST);

        btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.setBackground(null);
        btnPanel.setBorder(new EmptyBorder(35, 20, 0, 0));

        reqBtn = new RoundedButton("",20);
        reqBtn.setIcon(new ImageIcon(new ImageIcon("source/icon_schedule/bell.png").getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH)));
        reqBtn.setBackground(Color.WHITE);
        reqBtn.setPreferredSize(new Dimension(40, 40));
        reqBtn.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new UserRequestView(frame);
        });
        btnPanel.add(reqBtn);

        homeBtn = new RoundedButton("",20);
        homeBtn.setIcon(new ImageIcon(new ImageIcon("source/icon_schedule/house.png").getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH)));
        homeBtn.setBackground(Config.primaryColor_base);
        homeBtn.setPreferredSize(new Dimension(40, 40));
        homeBtn.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new HomePage(frame);
        });
        btnPanel.add(homeBtn);
        upperPanel.add(btnPanel, BorderLayout.EAST);

        lowerPanel = new JPanel(new BorderLayout());
        lowerPanel.setBackground(null);
        lowerPanel.setBorder(new EmptyBorder(10, 50, 10, 50));

        uplowPanel = new JPanel(new BorderLayout());
        uplowPanel.setBackground(null);

        title = new JLabel("Users");
        title.setFont(Config.HEADER_SEMIBOLD[0]);
        title.setForeground(Color.WHITE);
        uplowPanel.add(title, BorderLayout.WEST);

        addBtn = new RoundedButton("+ เพิ่มผู้ใช้",20);
        addBtn.setFont(Config.HEADER_SEMIBOLD[2]);
        addBtn.setForeground(Color.WHITE);
        addBtn.setPreferredSize(new Dimension(120, 30));
        addBtn.setBackground(Config.primaryColor_base);
        addBtn.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminCreateUserPortal(frame);
        });
        uplowPanel.add(addBtn, BorderLayout.EAST);

        lowerPanel.add(uplowPanel, BorderLayout.NORTH);

        innerPanel = new JPanel(new BorderLayout());
        innerPanel.setBackground(null);
        innerPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        String[] columns = {"ID", "Role", "Student ID", "Professor ID", "Section", "Email", "Prefix", "First Name", "Last Name", "Faculty", "Major", "Address", "Phone Number"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setGridColor(Color.GRAY);
        table.setBackground(null);
        table.setShowGrid(true);
        table.setFont(Config.NORMAL_REGULAR);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        scrollPane.setBackground(null);
        loadData();

        innerPanel.add(scrollPane, BorderLayout.CENTER);
        lowerPanel.add(innerPanel, BorderLayout.CENTER);


        frame.add(upperPanel, BorderLayout.NORTH);
        frame.add(lowerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
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