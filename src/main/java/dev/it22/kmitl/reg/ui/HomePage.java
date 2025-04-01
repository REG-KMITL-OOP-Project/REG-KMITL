package dev.it22.kmitl.reg.ui;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.*;
import dev.it22.kmitl.reg.ui.admin.UserManagement;
import dev.it22.kmitl.reg.ui.event.admin.*;
import dev.it22.kmitl.reg.ui.event.examSch.*;
import dev.it22.kmitl.reg.ui.profile.LoginFrame;
import dev.it22.kmitl.reg.ui.request.UserRequestView;
import dev.it22.kmitl.reg.ui.transcript.TranscriptController;
import dev.it22.kmitl.reg.ui.event.classSch.*;
import dev.it22.kmitl.reg.ui.event.calendar.*;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RealTimeClock;
import dev.it22.kmitl.reg.utils.RoundedButton;
import dev.it22.kmitl.reg.ui.Class_Management.SubjectHomepage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.formdev.flatlaf.FlatLightLaf;

public class HomePage implements ActionListener {

    private JFrame frame;
    private JPanel upperPanel, innerUpperPanel;
    private RealTimeClock clock;
    private JTextArea clockLabel;

    private final User user = new User();
    private final Account acc = user.getUserAccount();
    private int border = 60;
    String name[];
    String source[];
    JPanel inPanel[];
    RoundedButton button[], editButton;
    JLabel label[];
    JPanel bottomPanel;

    public HomePage(JFrame frame) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.frame = frame;
        frame.setLayout(new GridLayout(2, 1));

        upperPanel = new JPanel();
        innerUpperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());

        innerUpperPanel.setLayout(new BorderLayout());
        innerUpperPanel.add(Config.createLogoAndTitle(Config.HEADER_SEMIBOLD[3], 50), BorderLayout.NORTH);
        innerUpperPanel.add(createWelcomePanel(acc), BorderLayout.CENTER);
        innerUpperPanel.setPreferredSize(new Dimension(frame.getWidth() * 2 / 3, upperPanel.getHeight()));
        innerUpperPanel.setBackground(null);

        clock = new RealTimeClock();
        clockLabel = clock.getClock();
        clockLabel.setPreferredSize(new Dimension(frame.getWidth() / 3, frame.getHeight() / 2));
        upperPanel.setBackground(Config.bgColor_base);
//        lowerPanel.setBackground(Config.bgColor_hard);

        upperPanel.add(innerUpperPanel, BorderLayout.WEST);
        upperPanel.add(clockLabel, BorderLayout.EAST);
        frame.getContentPane().add(upperPanel);

        if (acc instanceof Student) {
            border = 60;
            name = new String[]{"ตารางเรียน", "ตารางสอบ", "ดูคะแนน", "ปฏิทินการศึกษา", "ผลการเรียน", "ออกจากระบบ"};
            source = new String[]{"source/sheet.png", "source/book-open-check.png", "source/book.png", "source/calendar-days.png", "source/scroll-text.png", "source/log-out.png"};
        }else if(acc instanceof Prof){
            border = 40;
            name  = new String[]{"ตารางสอน","ตารางสอบ","กรอกคะแนน","กรอกเกรด","ปฏิทินการศึกษา","ออกจากระบบ"};
            source = new String[]{"source/sheet.png", "source/book-open-check.png", "source/clipboard-pen-line.png", "source/file-pen-line.png", "source/calendar-days.png", "source/log-out.png"};
        }else if(acc instanceof Admin){
            border = 100;
            name = new String[]{"จัดการผู้ใช้", "จัดการชั้นเรียน", "จัดการเหตุการณ์", "ออกจากระบบ"};
            source = new String[]{"source/user-round.png", "source/sheet.png", "source/calendar-days.png", "source/log-out.png"};
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
            button[i] = new RoundedButton("", 20);

            inPanel[i].setLayout(new BoxLayout(inPanel[i], BoxLayout.Y_AXIS));
            inPanel[i].setBackground(null);
            inPanel[i].setPreferredSize(new Dimension((frame.getWidth() - 150) / name.length, (frame.getHeight() / 2) - 120));

            button[i].setIcon(new ImageIcon(new ImageIcon(source[i]).getImage().getScaledInstance(inPanel[i].getPreferredSize().width - border, inPanel[i].getPreferredSize().width - border, Image.SCALE_SMOOTH)));

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

        frame.getContentPane().add(bottomPanel);
        frame.setVisible(true);
    }


    public JPanel createWelcomePanel(Account account) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//        panel.setAlignmentY(Component.CENTER_ALIGNMENT);
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 0));
        panel.setBackground(null);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(null);
        topPanel.setMaximumSize(new Dimension(1000, 40));
        topPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        if (account instanceof Student) {
            JLabel welcome = new JLabel("ยินดีต้อนรับ ");
            welcome.setForeground(Color.WHITE);
            welcome.setFont(Config.HEADER_SEMIBOLD[1]);

            JLabel idLabel = new JLabel(((Student) account).getStudentId());
            idLabel.setForeground(Config.primaryColor_base);
            idLabel.setFont(Config.HEADER_SEMIBOLD[1]);

            editButton = new RoundedButton("", 10);
            editButton.setBackground(Config.primaryColor_base);
            editButton.setPreferredSize(new Dimension(30, 30));
            editButton.setIcon(new ImageIcon(new ImageIcon("source/square-pen.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
            editButton.addActionListener(this);

            topPanel.add(welcome);
            topPanel.add(idLabel);
            topPanel.add(editButton);

            JLabel nameLabel = new JLabel(" คุณ" + account.getFirstName() + " " + account.getLastName());
            nameLabel.setBackground(null);
            nameLabel.setForeground(Config.primaryColor_base);
            nameLabel.setFont(Config.HEADER_SEMIBOLD[1]);
            nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            panel.add(topPanel);
            panel.add(nameLabel);
        } else if (account instanceof Prof) {
            JLabel welcome = new JLabel("ยินดีต้อนรับ ");
            welcome.setForeground(Color.WHITE);
            welcome.setFont(Config.HEADER_SEMIBOLD[1]);

            JLabel idLabel = new JLabel(((Prof) account).getProf_id());
            idLabel.setForeground(Config.primaryColor_base);
            idLabel.setFont(Config.HEADER_SEMIBOLD[1]);

            editButton = new RoundedButton("", 10);
            editButton.setBackground(Config.primaryColor_base);
            editButton.setPreferredSize(new Dimension(30, 30));
            editButton.setIcon(new ImageIcon(new ImageIcon("source/square-pen.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
            editButton.addActionListener(this);

            topPanel.add(welcome);
            topPanel.add(idLabel);
            topPanel.add(editButton);

            JLabel nameLabel = new JLabel(" คุณ" + account.getFirstName() + " " + account.getLastName());
            nameLabel.setBackground(null);
            nameLabel.setForeground(Config.primaryColor_base);
            nameLabel.setFont(Config.HEADER_SEMIBOLD[1]);
            nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            panel.add(topPanel);
            panel.add(nameLabel);
        } else if (account instanceof Admin) {
            JLabel welcome = new JLabel("ยินดีต้อนรับ ");
            welcome.setForeground(Color.WHITE);
            welcome.setFont(Config.HEADER_SEMIBOLD[1]);

            topPanel.add(welcome);

            JLabel nameLabel = new JLabel(" คุณ" + account.getFirstName() + " " + account.getLastName());
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
        if (!e.getSource().equals(editButton)) {
            JLayeredPane newLayeredPane = new JLayeredPane();
            newLayeredPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
            frame.setLayeredPane(newLayeredPane);
            frame.setContentPane(new JFrame().getContentPane());
            frame.getContentPane().setBackground(Config.bgColor_base);
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
        }
        if (acc instanceof Student) { //"ตารางเรียน","ตารางสอบ","ดูคะแนน","ปฏิทินการศึกษา","ผลการเรียน","ตั้งค่า"
            if (e.getSource().equals(button[0])) {
                new ClassSchedulePage(frame);
            } else if (e.getSource().equals(button[1])) {
                new ExamSchedulePage(frame);
            } else if (e.getSource().equals(button[2])) {
                System.out.println("Student3");
            } else if (e.getSource().equals(button[3])) {
                new CalendarPage(frame);
            } else if (e.getSource().equals(button[4])) {
                new TranscriptController(frame);
            } else if (e.getSource().equals(button[5])) {
                user.logout();
                new LoginFrame(frame);
            } else if (e.getSource().equals(editButton)) {
                new RequestEditDataView(frame);
            }
        } else if (acc instanceof Prof) {
            if (e.getSource().equals(button[0])) {
                new TeacherClassSchedulePage(frame);
            } else if (e.getSource().equals(button[1])) {
                new TeacherExamSchedulePage(frame);
            } else if (e.getSource().equals(button[2])) {
                System.out.println("Prof3");
            } else if (e.getSource().equals(button[3])) {
                System.out.println("Prof4");
            } else if (e.getSource().equals(button[4])){
                new CalendarPage(frame);
            } else if (e.getSource().equals(button[5])) {
                user.logout();
                new LoginFrame(frame);
            } else if (e.getSource().equals(editButton)) {
                new RequestEditDataView(frame);
            }
        } else if (acc instanceof Admin) { //"จัดการผู้ใช้","จัดการชั้นเรียน","จัดการเหตุการณ์","ตั้งค่า"
            if (e.getSource().equals(button[0])) {
                new UserManagement(frame);
            } else if (e.getSource().equals(button[1])) {
                new SubjectHomepage(frame);
            } else if (e.getSource().equals(button[2])) {
                new AdminCalendarPage(frame);
            } else if (e.getSource().equals(button[3])) {
                user.logout();
                new LoginFrame(frame);
            }
        }
    }


    public static void main(String[] args) {
        JFrame config = Config.createAndShowGUI();

        try {
//            new Login("Student01","Student1234").loginWithUsernameAndPassword();
            //new Login("Prof01","Prof1234").loginWithUsernameAndPassword();
            new Login("Admin01","Admin1234").loginWithUsernameAndPassword();
            System.out.println(new User().getUserAccount());
        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
        System.out.println(new User().getUserAccount().getUsername());

        if (new User().getUserAccount() instanceof Student) {
            System.out.println("Student");
        }
        new HomePage(config);
    }
}
