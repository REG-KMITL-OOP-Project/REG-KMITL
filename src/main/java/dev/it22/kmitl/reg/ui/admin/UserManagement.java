package dev.it22.kmitl.reg.ui.admin;

import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserManagement {
    private JFrame frame;
    public  UserManagement(JFrame frame){
        this.frame = frame;
        frame.setLayout(new BorderLayout());

        //Header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(1,2));
        headerPanel.setBackground(null);

        JPanel LogoPanel = Config.createLogoAndTitle(Config.NORMAL_REGULAR,50);
        headerPanel.add(LogoPanel);

        RoundedButton notifyBtn = new RoundedButton("",20);
        notifyBtn.setIcon(new ImageIcon(new ImageIcon("source/icon_schedule/bell.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
        notifyBtn.setBackground(Color.WHITE);

        RoundedButton homeBtn = new RoundedButton("",20);
        homeBtn.setIcon(new ImageIcon(new ImageIcon("source/icon_schedule/house.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
        homeBtn.setBackground(Config.primaryColor_hard);
        homeBtn.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new HomePage(frame);
        });

        JPanel headerLogoGroup = new JPanel();
        headerLogoGroup.setLayout(new FlowLayout(FlowLayout.RIGHT));
        headerLogoGroup.setBackground(null);
        headerLogoGroup.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 50));
        headerLogoGroup.add(notifyBtn);
        headerLogoGroup.add(homeBtn);

        headerPanel.add(headerLogoGroup);

        frame.add(headerPanel,BorderLayout.NORTH);

        //Body panel

        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new FlowLayout());
        bodyPanel.setSize(frame.getWidth(), frame.getHeight() - headerPanel.getHeight());
        bodyPanel.setBackground(null);

        JPanel titlePanel = new JPanel(new GridLayout(1,2));
        System.out.println(bodyPanel.getWidth());
        titlePanel.setPreferredSize(new Dimension(bodyPanel.getWidth(),100));
        JLabel titleLabel = new JLabel("Users");
        titleLabel.setFont(Config.HEADER_SEMIBOLD[0]);
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        titlePanel.setBackground(null);
        titlePanel.setBorder(new EmptyBorder(35, 50, 0, 0));

        JPanel createBtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        createBtnPanel.setBackground(null);
        createBtnPanel.setBorder(new EmptyBorder(15, 0, 0, 50));
        RoundedButton createBtn = new RoundedButton("+ เพิ่มผู้ใช้",10);
        createBtn.setFont(Config.HEADER_SEMIBOLD[2]);
//        createBtn.setIcon(new ImageIcon(new ImageIcon("source/plus.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
        createBtn.setForeground(Color.WHITE);
        createBtn.setPreferredSize(new Dimension(150, 40));
        createBtn.setBackground(Config.primaryColor_hard);
        createBtn.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminCreateUserPortal(frame);
        });
        createBtnPanel.add(createBtn);
        titlePanel.add(createBtnPanel);
        bodyPanel.add(titlePanel);

        frame.add(bodyPanel,BorderLayout.CENTER);


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new UserManagement(Config.createAndShowGUI());
    }
}
