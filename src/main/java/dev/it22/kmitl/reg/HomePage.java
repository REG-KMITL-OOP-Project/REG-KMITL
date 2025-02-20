package dev.it22.kmitl.reg;

import javax.swing.*;
import java.awt.*;

public class HomePage {
    private JFrame frame;
    private JPanel upperPanel , lowerPanel , innerUpperPanel;
    private RealTimeClock clock;
    private JTextArea clockLabel;
    public HomePage() {

        frame = Config.createAndShowGUI();
        frame.setLayout(new GridLayout(2,1));

        upperPanel = new JPanel();
        lowerPanel = new JPanel();
        innerUpperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        lowerPanel.setLayout(new FlowLayout());

        innerUpperPanel.setLayout(new BorderLayout());
//        innerUpperPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        innerUpperPanel.add(Config.createLogoAndTitle(), BorderLayout.NORTH);
        innerUpperPanel.add(createWelcomePanel(), BorderLayout.CENTER);
        innerUpperPanel.setPreferredSize(new Dimension(frame.getWidth() * 2/3 , upperPanel.getHeight()));
        innerUpperPanel.setBackground(null);

        clock = new RealTimeClock();
        clockLabel = clock.getClock();
        clockLabel.setPreferredSize(new Dimension(frame.getWidth()/3, frame.getHeight()/2));
        upperPanel.setBackground(Config.bgColor_base);
        lowerPanel.setBackground(Config.bgColor_hard);

        upperPanel.add(innerUpperPanel, BorderLayout.WEST);
        upperPanel.add(clockLabel, BorderLayout.EAST);
        frame.add(upperPanel);
        frame.add(lowerPanel);
    }

    public static void main(String[] args) {
        new HomePage();
    }

    public JPanel createWelcomePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//        panel.setAlignmentY(Component.CENTER_ALIGNMENT);
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 0));
        panel.setBackground(null);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(null);
        topPanel.setMaximumSize(new Dimension(1000,40));
        topPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel welcome = new JLabel("ยินดีต้อนรับ ");
        welcome.setForeground(Color.WHITE);
        welcome.setFont(Config.HEADER_2);

        JLabel idLabel = new JLabel("XX07XXXX");
        idLabel.setForeground(Config.primaryColor_base);
        idLabel.setFont(Config.HEADER_2);

        topPanel.add(welcome);
        topPanel.add(idLabel);

        JLabel nameLabel = new JLabel(" คุณXXXXXXXXXX XXXXXXXXX");
        nameLabel.setBackground(null);
        nameLabel.setForeground(Config.primaryColor_base);
        nameLabel.setFont(Config.HEADER_2);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(topPanel);
        panel.add(nameLabel);
        return panel;
    }
}
