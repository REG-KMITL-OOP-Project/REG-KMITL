package dev.it22.kmitl.reg.ui.event.component;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class newHeader extends JPanel {
    private JLabel text;
    private JButton home;
    private RoundedButton saveJPG;
    private JPanel left,right, allPanel;

    public newHeader(JFrame frame) {
        this("No title", frame, null);
    }

    public newHeader(String title, JFrame frame, JPanel table) {
        this(title, frame, "source/icon_schedule/icon_etc.png", table);
    }

    public newHeader(String title, JFrame frame, String filePath, JPanel table) {

        // Home Button
        ImageIcon homeIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_home_re.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        home = new JButton(homeIcon);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setFocusPainted(false);
        home.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));

        saveJPG = new RoundedButton("Save JPG",15);
        saveJPG.setForeground(new Color(255, 247, 237));
        saveJPG.setBackground(Config.primaryColor_base);
        saveJPG.setFont(Config.HEADER_SEMIBOLD[2]);
        saveJPG.setPreferredSize(new Dimension((int)((frame.getWidth()-600)/3.5),40));

        // Outer Label
        text = new JLabel(title);
        text.setForeground(Config.primaryColor_base);
        text.setFont(Config.HEADER_SEMIBOLD[1]);

        left = new JPanel();
        left.setBackground(null);
        left.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
        left.add(home);
        left.add(text);

        right = new JPanel();
        right.setBackground(null);
        right.setLayout(new FlowLayout(FlowLayout.RIGHT,10,0));
        right.add(saveJPG);

        allPanel = new JPanel();
        allPanel.setBackground(null);
        allPanel.setLayout(new BorderLayout());
        allPanel.add(right,BorderLayout.EAST);
        allPanel.add(left,BorderLayout.WEST);

        this.setLayout(new BorderLayout());
        this.setBackground(Config.bgColor_base);
        this.setBorder(BorderFactory.createEmptyBorder(15, 25, 0, 25));
        this.add(allPanel,BorderLayout.NORTH);


        // Set event handlers
        home.addActionListener(new HomeButtonHandler(frame));
        saveJPG.addActionListener(new saveJPGHandler(table, frame));
    }

    public newHeader(String title, JFrame frame) {

        // Home Button
        ImageIcon homeIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_home_re.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        home = new JButton(homeIcon);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setFocusPainted(false);
        home.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));


        // Outer Label
        text = new JLabel(title);
        text.setForeground(Config.primaryColor_base);
        text.setFont(Config.HEADER_SEMIBOLD[1]);

        left = new JPanel();
        left.setBackground(null);
        left.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
        left.add(home);
        left.add(text);


        allPanel = new JPanel();
        allPanel.setBackground(null);
        allPanel.setLayout(new BorderLayout());
        allPanel.add(left,BorderLayout.WEST);

        this.setLayout(new BorderLayout());
        this.setBackground(Config.bgColor_base);
        this.setBorder(BorderFactory.createEmptyBorder(15, 25, 0, 25));
        this.add(allPanel,BorderLayout.NORTH);


        // Set event handlers
        home.addActionListener(new HomeButtonHandler(frame));
    }

    public JButton getHome() {
        return home;
    }
}