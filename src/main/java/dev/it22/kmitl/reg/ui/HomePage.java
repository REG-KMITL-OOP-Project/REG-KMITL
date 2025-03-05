package dev.it22.kmitl.reg.ui;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.*;
import dev.it22.kmitl.reg.ui.profile.LoginFrame;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RealTimeClock;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage implements ActionListener {

    private JFrame frame;
    private JPanel upperPanel , innerUpperPanel;
    private RealTimeClock clock;
    private JTextArea clockLabel;

    private final User user = new User();
    private final Account acc = user.getUserAccount();
    private int border = 60;
    String name[];
    String source[];
    JPanel inPanel[];
    RoundedButton button[];
    JLabel label[];
    JPanel bottomPanel;

    public HomePage(JFrame frame) {

        this.frame = frame;
        frame.setLayout(new GridLayout(2,1));

        upperPanel = new JPanel();
        innerUpperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());

        innerUpperPanel.setLayout(new BorderLayout());
        innerUpperPanel.add(Config.createLogoAndTitle(Config.HEADER_SEMIBOLD[3],50), BorderLayout.NORTH);
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

        if (acc instanceof Student) {
            border = 60;
            name  = new String[]{"ตารางเรียน","ตารางสอบ","ดูคะแนน","ปฏิทินการศึกษา","ผลการเรียน","ตั้งค่า"};
            source = new String[]{"source/calendar.png", "source/book-open-check.png", "source/star.png", "source/scroll-text.png", "source/scroll-text-1.png", "source/settings.png"};
        }else if(acc instanceof Prof){
            border = 80;
            name  = new String[]{"Example 1","Example 2","Example 3","Example 4","Example 5"};
            source = new String[]{"source/calendar.png", "source/book-open-check.png", "source/scroll-text.png", "source/scroll-text-1.png", "source/settings.png"};
        }else if(acc instanceof Admin){
            border = 100;
            name  = new String[]{"Example 1","Example 2","Example 3","Example 4"};
            source = new String[]{"source/calendar.png", "source/book-open-check.png", "source/scroll-text.png", "source/settings.png"};
        }

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

            inPanel[i].setLayout(new BoxLayout(inPanel[i], BoxLayout.Y_AXIS));
            inPanel[i].setBackground(null);
            inPanel[i].setPreferredSize(new Dimension((frame.getWidth()-150)/ name.length,(frame.getHeight() / 2) - 120));


            button[i].setIcon(new ImageIcon(new ImageIcon(source[i]).getImage().getScaledInstance(inPanel[i].getPreferredSize().width-border,inPanel[i].getPreferredSize().width-border,Image.SCALE_SMOOTH)));

            button[i].setBackground(Config.primaryColor_base);
            button[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            button[i].addActionListener(this);

            label[i] = new JLabel(name[i]);
            label[i].setFont(Config.HEADER_SEMIBOLD[2]);
            label[i].setForeground(Color.WHITE);
            label[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            inPanel[i].add(button[i]);
            inPanel[i].add(Box.createVerticalStrut(15));
            inPanel[i].add(label[i]);

            bottomPanel.add(inPanel[i]);
        }

        frame.add(bottomPanel);
        frame.setVisible(true);
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

        if (acc instanceof Student) {
            JLabel welcome = new JLabel("ยินดีต้อนรับ ");
            welcome.setForeground(Color.WHITE);
            welcome.setFont(Config.HEADER_SEMIBOLD[1]);

            JLabel idLabel = new JLabel(((Student) acc).getStudentId());
            idLabel.setForeground(Config.primaryColor_base);
            idLabel.setFont(Config.HEADER_SEMIBOLD[1]);

            topPanel.add(welcome);
            topPanel.add(idLabel);

            JLabel nameLabel = new JLabel(" คุณ"+acc.getFirstName()+" "+acc.getLastName());
            nameLabel.setBackground(null);
            nameLabel.setForeground(Config.primaryColor_base);
            nameLabel.setFont(Config.HEADER_SEMIBOLD[1]);
            nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            panel.add(topPanel);
            panel.add(nameLabel);
        } else if (acc instanceof Prof || acc instanceof Admin) {
            JLabel welcome = new JLabel("ยินดีต้อนรับ ");
            welcome.setForeground(Color.WHITE);
            welcome.setFont(Config.HEADER_SEMIBOLD[1]);

            topPanel.add(welcome);

            JLabel nameLabel = new JLabel(" คุณ"+acc.getFirstName()+" "+acc.getLastName());
            nameLabel.setBackground(null);
            nameLabel.setForeground(Config.primaryColor_base);
            nameLabel.setFont(Config.HEADER_SEMIBOLD[1]);
            nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            panel.add(topPanel);
            panel.add(nameLabel);
        }
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        frame.getContentPane().removeAll();
//        frame.revalidate();
//        frame.repaint();
        if(acc instanceof Student) {
            if (e.getSource().equals(button[0])) {

            } else if (e.getSource().equals(button[1])) {
                System.out.println("Student2");
            } else if (e.getSource().equals(button[2])) {
                System.out.println("Student3");
            } else if (e.getSource().equals(button[3])) {
                System.out.println("Student4");
            } else if (e.getSource().equals(button[4])) {
                System.out.println("Student5");
            } else if (e.getSource().equals(button[5])) {
                System.out.println("Student6");
            }
        }else if(acc instanceof Prof) {
            if (e.getSource().equals(button[0])) {
                System.out.println("Prof1");
            } else if (e.getSource().equals(button[1])) {
                System.out.println("Prof2");
            } else if (e.getSource().equals(button[2])) {
                System.out.println("Prof3");
            } else if (e.getSource().equals(button[3])) {
                System.out.println("Prof4");
            } else if (e.getSource().equals(button[4])) {
                System.out.println("Prof5");
            }
        } else if(acc instanceof Admin) {
            if (e.getSource().equals(button[0])) {
                System.out.println("Admin1");
            } else if (e.getSource().equals(button[1])) {
                System.out.println("Admin2");
            } else if (e.getSource().equals(button[2])) {
                System.out.println("Admin3");
            } else if (e.getSource().equals(button[3])) {
                System.out.println("Admin4");
            }
        }
    }

    public static void main(String[] args) {
        JFrame config = Config.createAndShowGUI();

        try {
//            new Login("Student01","Student1234").loginWithUsernameAndPassword();
//            new Login("Prof01","Prof1234").loginWithUsernameAndPassword();
//            new Login("Admin01","Admin1234").loginWithUsernameAndPassword();
            System.out.println(new User().getUserAccount());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(new User().getUserAccount().getUsername());

        if (new User().getUserAccount() instanceof Student){
            System.out.println("Student");
        }
        new HomePage(config);
    }
}
