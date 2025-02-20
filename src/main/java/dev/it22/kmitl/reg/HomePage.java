package dev.it22.kmitl.reg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage implements ActionListener {

    private JFrame frame;
    private JPanel upperPanel , innerUpperPanel;
    private RealTimeClock clock;
    private JTextArea clockLabel;

    String[] name = {"ตารางเรียน","ตารางสอบ","ดูคะแนน","ปฏิทินการศึกษา","ผลการเรียน","ตั้งค่า"};
    String source[] = {"source/calendar.png","source/book-open-check.png","source/star.png","source/scroll-text.png","source/scroll-text-1.png","source/settings.png"};
    JPanel inPanel[];
    RoundedButton button[];
    JLabel label[];
    JPanel bottomPanel;

    public HomePage() {

        frame = Config.createAndShowGUI();
        frame.setLayout(new GridLayout(2,1));

        upperPanel = new JPanel();
        innerUpperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());

        innerUpperPanel.setLayout(new BorderLayout());
        innerUpperPanel.add(Config.createLogoAndTitle(), BorderLayout.NORTH);
        innerUpperPanel.add(createWelcomePanel(), BorderLayout.CENTER);
        innerUpperPanel.setPreferredSize(new Dimension(frame.getWidth() * 2/3 , upperPanel.getHeight()));
        innerUpperPanel.setBackground(null);

        clock = new RealTimeClock();
        clockLabel = clock.getClock();
        clockLabel.setPreferredSize(new Dimension(frame.getWidth()/3, frame.getHeight()/2));
        upperPanel.setBackground(Config.bgColor_base);
//        lowerPanel.setBackground(Config.bgColor_hard);

        upperPanel.add(innerUpperPanel, BorderLayout.WEST);
        upperPanel.add(clockLabel, BorderLayout.EAST);
        frame.add(upperPanel);

        inPanel = new JPanel[name.length];
        button = new RoundedButton[name.length];
        label = new JLabel[name.length];
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.setBackground(Config.bgColor_hard);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(60, 50, 60, 50));

        for (int i = 0; i < name.length; i++) {
            inPanel[i] = new JPanel();
            button[i] = new RoundedButton("",20);
            button[i].setIcon(new ImageIcon(new ImageIcon(source[i]).getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH)));
            label[i] = new JLabel(name[i]);

            inPanel[i].setLayout(new BoxLayout(inPanel[i], BoxLayout.Y_AXIS));
            inPanel[i].setBackground(null);
            inPanel[i].setPreferredSize(new Dimension(180,225));
            button[i].setBackground(Config.primaryColor_base);
            button[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            button[i].addActionListener(this);
            label[i].setFont(Config.HEADER_3);
            label[i].setForeground(Color.WHITE);
            label[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            inPanel[i].add(button[i]);
            inPanel[i].add(Box.createVerticalStrut(15));
            inPanel[i].add(label[i]);
            bottomPanel.add(inPanel[i]);
        }

        frame.add(bottomPanel);
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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button[0])) {
            System.out.println("btn0");
        }else if (e.getSource().equals(button[1])) {
            System.out.println("btn1");
        }else if (e.getSource().equals(button[2])) {
            System.out.println("btn2");
        }else if (e.getSource().equals(button[3])) {
            System.out.println("btn3");
        }else if (e.getSource().equals(button[4])) {
            System.out.println("btn4");
        }else if (e.getSource().equals(button[5])) {
            System.out.println("btn5");
        }

    }
}
