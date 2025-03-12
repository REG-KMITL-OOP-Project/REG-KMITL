package dev.it22.kmitl.reg.ui;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.*;
import dev.it22.kmitl.reg.ui.event.AdminCalendarPage;
import dev.it22.kmitl.reg.ui.event.ExamSchedulePage;
import dev.it22.kmitl.reg.ui.profile.LoginFrame;
import dev.it22.kmitl.reg.ui.profile.RegisterFrame;
//import dev.it22.kmitl.reg.ui.transcript.TranscriptController;
//import dev.it22.kmitl.reg.ui.transcript.TranscriptView;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RealTimeClock;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage implements ActionListener {

    private JFrame frame;
    private JDesktopPane mainPanel;
    private JInternalFrame settingFrame;
    private JPanel upperPanel, innerUpperPanel;
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
    JPanel contentPanel;

    public HomePage(JFrame frame) {

        this.frame = frame;

        // ใช้ JDesktopPane เป็นพื้นที่หลักสำหรับ MDI
        mainPanel = new JDesktopPane();
        mainPanel.setBackground(Config.bgColor_base);

        // สร้าง Panel หลักสำหรับเนื้อหา (ไม่ใช้ GridLayout)
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        contentPanel.setOpaque(false); // ทำให้โปร่งใสเพื่อเห็น background ของ JDesktopPane

        // สร้าง panel สำหรับส่วนบนและล่าง
        upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setBackground(Config.bgColor_base);
        upperPanel.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight() / 2));

        // ส่วน innerUpperPanel ยังคงเหมือนเดิม
        innerUpperPanel = new JPanel();
        innerUpperPanel.setLayout(new BorderLayout());
        innerUpperPanel.add(Config.createLogoAndTitle(Config.HEADER_SEMIBOLD[3], 50), BorderLayout.NORTH);
        innerUpperPanel.add(createWelcomePanel(), BorderLayout.CENTER);
        innerUpperPanel.setPreferredSize(new Dimension(frame.getWidth() * 2/3, upperPanel.getHeight()));
        innerUpperPanel.setBackground(null);

        clock = new RealTimeClock();
        clockLabel = clock.getClock();
        clockLabel.setPreferredSize(new Dimension(frame.getWidth()/3, frame.getHeight()/2));
        upperPanel.setBackground(Config.bgColor_base);
//        lowerPanel.setBackground(Config.bgColor_hard);

        upperPanel.add(innerUpperPanel, BorderLayout.WEST);
        upperPanel.add(clockLabel, BorderLayout.EAST);

        // เตรียมข้อมูลเมนูตามประเภทผู้ใช้
        if (acc instanceof Student) {
            border = 60;
            name = new String[]{"ตารางเรียน","ตารางสอบ","ดูคะแนน","ปฏิทินการศึกษา","ผลการเรียน","ตั้งค่า"};
            source = new String[]{"source/sheet.png", "source/book-open-check.png", "source/book.png", "source/calendar-days.png", "source/scroll-text.png", "source/settings.png"};
        }else if(acc instanceof Prof){
            border = 80;
            name  = new String[]{"Example 1","Example 2","Example 3","Example 4","Example 5"};
            source = new String[]{"source/sheet.png", "source/book-open-check.png", "source/scroll-text.png", "source/scroll-text.png", "source/settings.png"};
        }else if(acc instanceof Admin){
            border = 100;
            name = new String[]{"จัดการผู้ใช้","จัดการชั้นเรียน","จัดการเหตุการณ์","ตั้งค่า"};
            source = new String[]{"source/user-round.png", "source/sheet.png", "source/calendar-days.png", "source/settings.png"};
        }

        // สร้าง panel สำหรับปุ่มเมนูด้านล่าง
        inPanel = new JPanel[name.length];
        button = new RoundedButton[name.length];
        label = new JLabel[name.length];
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.setBackground(Config.bgColor_hard);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(60, 50, 60, 50));

        // สร้างปุ่มและฉลากตามข้อมูลที่เตรียมไว้
        for (int i = 0; i < name.length; i++) {
            inPanel[i] = new JPanel();
            button[i] = new RoundedButton("", 20);

            inPanel[i].setLayout(new BoxLayout(inPanel[i], BoxLayout.Y_AXIS));
            inPanel[i].setBackground(null);
            inPanel[i].setPreferredSize(new Dimension((frame.getWidth()-150) / name.length, (frame.getHeight() / 2) - 120));

            button[i].setIcon(new ImageIcon(new ImageIcon(source[i]).getImage().getScaledInstance(inPanel[i].getPreferredSize().width-border, inPanel[i].getPreferredSize().width-border, Image.SCALE_SMOOTH)));

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

        // เพิ่ม panel บนและล่างเข้าใน contentPanel
        contentPanel.add(upperPanel, BorderLayout.NORTH);
        contentPanel.add(bottomPanel, BorderLayout.CENTER);

        // เพิ่ม contentPanel เข้าสู่ JDesktopPane
        mainPanel.add(contentPanel);

        // สร้าง JInternalFrame สำหรับการตั้งค่า
        // แต่ยังไม่แสดงตอนเริ่มต้น (default visible = false)
        settingFrame = new JInternalFrame("การตั้งค่า", true, true, true, true);
        settingFrame.setSize(400, 300);
        settingFrame.setLocation(frame.getWidth()/2 - 200, frame.getHeight()/2 - 150);

        // สร้างเนื้อหาตัวอย่างสำหรับหน้าต่างการตั้งค่า
        JPanel settingPanel = new JPanel();
        settingPanel.setLayout(new BorderLayout());
        JLabel settingLabel = new JLabel("หน้าการตั้งค่า", JLabel.CENTER);
        settingLabel.setFont(Config.HEADER_SEMIBOLD[2]);
        settingPanel.add(settingLabel, BorderLayout.CENTER);

        settingFrame.setContentPane(settingPanel);
        settingFrame.setVisible(false); // ซ่อนไว้ก่อน จะแสดงเมื่อกดปุ่มตั้งค่า

        // เพิ่ม JInternalFrame เข้าสู่ JDesktopPane
        mainPanel.add(settingFrame);

        // ตั้งค่า JDesktopPane เป็น contentPane ของ JFrame
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }


    public JPanel createWelcomePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 0));
        panel.setBackground(null);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(null);
        topPanel.setMaximumSize(new Dimension(1000, 40));
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
        // ปรับให้แสดงทางเลือกด้วย JInternalFrame แทนการเปลี่ยนแปลง contentPane
        frame.setContentPane(new JFrame().getContentPane());
        frame.getContentPane().setBackground(Config.bgColor_base);
        if(acc instanceof Student) { //"ตารางเรียน","ตารางสอบ","ดูคะแนน","ปฏิทินการศึกษา","ผลการเรียน","ตั้งค่า"
            if (e.getSource().equals(button[0])) {
                showInternalFrame("ตารางเรียน", 700, 500);
            } else if (e.getSource().equals(button[1])) {
                showInternalFrame("ตารางสอบ", 700, 500);
            } else if (e.getSource().equals(button[2])) {
                showInternalFrame("คะแนน", 700, 500);
            } else if (e.getSource().equals(button[3])) {
                showInternalFrame("ปฏิทินการศึกษา", 700, 500);
            } else if (e.getSource().equals(button[4])) {
                showInternalFrame("ผลการเรียน", 700, 500);
            } else if (e.getSource().equals(button[5])) {
                settingFrame.setVisible(true);
            }
        } else if(acc instanceof Prof) {
            if (e.getSource().equals(button[0])) {
                showInternalFrame("Example 1", 700, 500);
            } else if (e.getSource().equals(button[1])) {
                showInternalFrame("Example 2", 700, 500);
            } else if (e.getSource().equals(button[2])) {
                showInternalFrame("Example 3", 700, 500);
            } else if (e.getSource().equals(button[3])) {
                showInternalFrame("Example 4", 700, 500);
            } else if (e.getSource().equals(button[4])) {
                settingFrame.setVisible(true);
            }
        } else if(acc instanceof Admin) { //"จัดการผู้ใช้","จัดการชั้นเรียน","จัดการเหตุการณ์","ตั้งค่า"
            if (e.getSource().equals(button[0])) {
                showInternalFrame("จัดการผู้ใช้", 700, 500);
            } else if (e.getSource().equals(button[1])) {
                showInternalFrame("จัดการชั้นเรียน", 700, 500);
            } else if (e.getSource().equals(button[2])) {
                showInternalFrame("จัดการเหตุการณ์", 700, 500);
            } else if (e.getSource().equals(button[3])) {
                settingFrame.setVisible(true);
            }
        }
    }

    // เมธอดสำหรับสร้างและแสดง JInternalFrame
    private void showInternalFrame(String title, int width, int height) {
        // สร้าง JInternalFrame ใหม่
        JInternalFrame internalFrame = new JInternalFrame(title, true, true, true, true);
        internalFrame.setSize(width, height);

        // กำหนดตำแหน่งแบบสุ่มเล็กน้อยเพื่อไม่ให้ทับซ้อนกันทั้งหมด
        int x = 50 + (int)(Math.random() * 100);
        int y = 50 + (int)(Math.random() * 100);
        internalFrame.setLocation(x, y);

        // สร้างเนื้อหาตัวอย่าง
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("เนื้อหาของ " + title, JLabel.CENTER);
        label.setFont(Config.HEADER_SEMIBOLD[2]);
        panel.add(label, BorderLayout.CENTER);

        internalFrame.setContentPane(panel);
        internalFrame.setVisible(true);

        // เพิ่มเข้าสู่ JDesktopPane
        mainPanel.add(internalFrame);

        // ทำให้หน้าต่างนี้อยู่ด้านหน้าสุด
        try {
            internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame config = Config.createAndShowGUI();

        try {
//            new Login("Student01","Student1234").loginWithUsernameAndPassword();
//            new Login("Prof01","Prof1234").loginWithUsernameAndPassword();
            new Login("Admin01","Admin1234").loginWithUsernameAndPassword();
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
