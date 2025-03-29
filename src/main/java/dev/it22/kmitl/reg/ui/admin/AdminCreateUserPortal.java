package dev.it22.kmitl.reg.ui.admin;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminCreateUserPortal {
    public AdminCreateUserPortal(JFrame frame) {
        JLabel title = new JLabel("สร้างบัญชีผู้ใช้");
        title.setFont(Config.HEADER_SEMIBOLD[1]);
        title.setForeground(Color.white);

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER));
        header.add(title);
        header.setBackground(null);
        header.setBorder(new EmptyBorder(10,10,10,10));

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(null);
        RoundedButton studentButton = new RoundedButton("นักศึกษา", 20);
        RoundedButton profButton = new RoundedButton("อาจารย์", 20);
        RoundedButton adminButton = new RoundedButton("ผู้ดูแล", 20);
        RoundedButton cancelButton = new RoundedButton("กลับไปหน้าหลัก", 20);

        studentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        profButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        studentButton.setBackground(Config.primaryColor_hard);
        profButton.setBackground(Config.primaryColor_hard);
        adminButton.setBackground(Config.primaryColor_hard);

        studentButton.setFont(Config.HEADER_SEMIBOLD[2]);
        profButton.setFont(Config.HEADER_SEMIBOLD[2]);
        adminButton.setFont(Config.HEADER_SEMIBOLD[2]);
        cancelButton.setFont(Config.HEADER_SEMIBOLD[2]);

        content.add(studentButton);
        content.add(Box.createVerticalStrut(5));
        content.add(profButton);
        content.add(Box.createVerticalStrut(5));
        content.add(adminButton);
        content.add(Box.createVerticalStrut(20));
        content.add(cancelButton);

        frame.add(header, BorderLayout.NORTH);
        frame.add(content, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        JFrame frame = Config.createAndShowGUI();
        new AdminCreateUserPortal(frame);
    }
}
