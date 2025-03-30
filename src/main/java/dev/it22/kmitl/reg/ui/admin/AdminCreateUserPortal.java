package dev.it22.kmitl.reg.ui.admin;

import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminCreateUserPortal {
    JFrame frame;
    JPanel upperPanel, lowerPanel, innerPanel;
    JLabel thLabel, enLabel;
    RoundedButton backBtn, stdBtn, profBtn, adminBtn;
    public AdminCreateUserPortal(JFrame frame) {
        this.frame = frame;
        frame.setLayout(new BorderLayout());

        upperPanel = new JPanel(new BorderLayout());
        upperPanel.setBackground(null);
        upperPanel.setBorder(new EmptyBorder(10, 0, 20, 50));
        upperPanel.add(Config.createLogoAndTitle(Config.HEADER_SEMIBOLD[3],50), BorderLayout.WEST);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.setBackground(null);
        btnPanel.setBorder(new EmptyBorder(35, 20, 0, 0));
        RoundedButton backBtn = new RoundedButton("",20);
        backBtn.setBackground(Config.primaryColor_base);
        backBtn.setIcon(new ImageIcon(new ImageIcon("source/house.png").getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH)));
        backBtn.setPreferredSize(new Dimension(50,50));
        backBtn.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new HomePage(frame);
        });
        btnPanel.add(backBtn);
        upperPanel.add(btnPanel, BorderLayout.EAST);

        lowerPanel = new JPanel();
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.Y_AXIS));
        lowerPanel.setBackground(null);

        thLabel = new JLabel("สร้างบัญชีผู้ใช้");
        thLabel.setFont(Config.HEADER_SEMIBOLD[0]);
        thLabel.setForeground(Color.WHITE);
        thLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lowerPanel.add(thLabel);

        enLabel = new JLabel("CREATE ACCOUNT");
        enLabel.setFont(Config.HEADER_SEMIBOLD[0]);
        enLabel.setForeground(Config.primaryColor_base);
        enLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lowerPanel.add(enLabel);
        lowerPanel.add(Box.createVerticalStrut(20));

        JPanel panel = new JPanel();
        panel.setBackground(null);
        innerPanel = new JPanel();
        innerPanel.setLayout(new GridLayout(3,1,20,20));
        innerPanel.setBackground(Config.bgColor_hard);
        innerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        innerPanel.setBorder(new EmptyBorder(30, 50, 30, 50));
        innerPanel.setPreferredSize(new Dimension(frame.getSize().width/3, frame.getSize().height/3));

        stdBtn = new RoundedButton("สำหรับนักศึกษา",20);
        System.out.println(new Dimension(innerPanel.getPreferredSize().width - 20, innerPanel.getPreferredSize().height/3));
        stdBtn.setBackground(Config.primaryColor_base);
        stdBtn.setFont(Config.HEADER_REGULAR[1]);
        stdBtn.setForeground(Color.WHITE);
        stdBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        innerPanel.add(stdBtn);

        profBtn = new RoundedButton("สำหรับอาจารย์",20);
        profBtn.setBackground(Config.primaryColor_base);
        profBtn.setFont(Config.HEADER_REGULAR[1]);
        profBtn.setForeground(Color.WHITE);
        profBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        innerPanel.add(profBtn);

        adminBtn = new RoundedButton("สำหรับเจ้าหน้าที่",20);
        adminBtn.setBackground(Config.primaryColor_base);
        adminBtn.setFont(Config.HEADER_REGULAR[1]);
        adminBtn.setForeground(Color.WHITE);
        adminBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        innerPanel.add(adminBtn);

        panel.add(innerPanel);
        lowerPanel.add(panel);

        frame.getContentPane().add(upperPanel, BorderLayout.NORTH);
        frame.getContentPane().add(lowerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = Config.createAndShowGUI();
        new AdminCreateUserPortal(frame);
    }
}
