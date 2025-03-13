package dev.it22.kmitl.reg.ui.admin;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserManagement {
    public  UserManagement(){
        JFrame panel = Config.createAndShowGUI();
        panel.setLayout(new BorderLayout());

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

        JPanel headerLogoGroup = new JPanel();
        headerLogoGroup.setLayout(new FlowLayout(FlowLayout.RIGHT));
        headerLogoGroup.setBackground(null);
        headerLogoGroup.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 50));
        headerLogoGroup.add(notifyBtn);
        headerLogoGroup.add(homeBtn);

        headerPanel.add(headerLogoGroup);

        panel.add(headerPanel,BorderLayout.NORTH);

        panel.setVisible(true);
    }

    public static void main(String[] args) {
        new UserManagement();
    }
}
