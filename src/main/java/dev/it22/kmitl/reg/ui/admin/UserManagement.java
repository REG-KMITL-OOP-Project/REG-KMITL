package dev.it22.kmitl.reg.ui.admin;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserManagement {
    private JFrame frame;

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
        JPanel headerPanel = new JPanel(new GridLayout(1, 2));
        headerPanel.setBackground(null);

        JPanel logoPanel = Config.createLogoAndTitle(Config.NORMAL_REGULAR, 50);
        headerPanel.add(logoPanel);

        JPanel headerLogoGroup = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        headerLogoGroup.setBackground(null);
        headerLogoGroup.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 50));
        headerLogoGroup.add(createButton("source/icon_schedule/bell.png", Color.WHITE));
        headerLogoGroup.add(createButton("source/icon_schedule/house.png", Config.primaryColor_hard));

        headerPanel.add(headerLogoGroup);
        return headerPanel;
    }

    private JPanel createBodyPanel() {
        JPanel bodyPanel = new JPanel(new FlowLayout());
        bodyPanel.setBackground(null);

        JPanel titlePanel = new JPanel(new GridLayout(1, 2));
        titlePanel.setPreferredSize(new Dimension(bodyPanel.getWidth(), 100));
        titlePanel.setBackground(null);
        titlePanel.setBorder(new EmptyBorder(35, 50, 0, 0));

        JLabel titleLabel = new JLabel("Users");
        titleLabel.setFont(Config.HEADER_SEMIBOLD[0]);
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        JPanel createBtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        createBtnPanel.setBackground(null);
        createBtnPanel.setBorder(new EmptyBorder(15, 0, 0, 50));
        RoundedButton createBtn = new RoundedButton("+ เพิ่มผู้ใช้", 10);
        createBtn.setFont(Config.HEADER_SEMIBOLD[2]);
        createBtn.setForeground(Color.WHITE);
        createBtn.setPreferredSize(new Dimension(150, 40));
        createBtn.setBackground(Config.primaryColor_hard);
        createBtnPanel.add(createBtn);

        titlePanel.add(createBtnPanel);
        bodyPanel.add(titlePanel);

        return bodyPanel;
    }

    private RoundedButton createButton(String iconPath, Color backgroundColor) {
        RoundedButton button = new RoundedButton("", 20);
        button.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
        button.setBackground(backgroundColor);
        return button;
    }

    public static void main(String[] args) {
        new UserManagement(Config.createAndShowGUI());
    }
}