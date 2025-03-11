package dev.it22.kmitl.reg.ui.event;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;

public class CalenderHeaderMenu extends JMenuBar {
    //head-menubar
    private JMenu event;
    private JLabel sampleEvent;
    private JLabel outer_Label;
    private JButton home;
    private JPanel SchPanel;


    public CalenderHeaderMenu() {
        event = new JMenu();

        sampleEvent = new JLabel("sample event");
        outer_Label = new JLabel("Calender");
        home = new JButton("Home");
        outer_Label.setForeground(Config.primaryColor_base);
        outer_Label.setFont(Config.HEADER_SEMIBOLD[1]);;

        //head-menubar
        SchPanel = new JPanel();

        sampleEvent.setPreferredSize(new Dimension(110, 30));
        sampleEvent.setSize(110, 30);
        sampleEvent.setForeground(Config.primaryColor_base);
        SchPanel.add(sampleEvent);
        SchPanel.setBackground(Config.bgColor_base);

        ImageIcon homeIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_home_re.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
        home = new JButton(homeIcon);


        event = new JMenu();
        ImageIcon originalIcon = new ImageIcon("source/icon_schedule/icon_box.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        event.setIcon(scaledIcon);
        event.setBackground(Config.bgColor_base);
        event.getPopupMenu().setBorder(null);
        event.setMenuLocation(-45, 42);



        outer_Label.setForeground(Config.primaryColor_base);
        outer_Label.setFont(Config.HEADER_SEMIBOLD[1]);

        home.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 5));
        event.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        //innerLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));

        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setFocusPainted(false);

        this.setBackground(Config.bgColor_base);
        this.setBorderPainted(false);
        this.add(home);

        event.setForeground(Config.primaryColor_base);
        this.add(event);
        this.add(outer_Label);
        event.add(SchPanel);

    }
}
