package dev.it22.kmitl.reg.ui.profile;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame implements ActionListener {
    private JFrame frame;
    private JPanel bigPanel , panel , loginPanel;
    private JLabel upper,lower,username,password;
    private JTextField userT , passT;
    private RoundedButton loginButton;

    public LoginFrame(JFrame frame) {
        this.frame = frame;
        frame.setTitle("Login");
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Config.bgColor_base);
        frame.add(Config.createLogoAndTitle(Config.HEADER_SEMIBOLD[3], 50), BorderLayout.NORTH);

        bigPanel = new JPanel();
        bigPanel.setBackground(null);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(null);

        upper = new JLabel("SIGN-IN");
        upper.setFont(Config.HEADER_SEMIBOLD[1]);
        upper.setForeground(Color.WHITE);
        upper.setAlignmentX(Component.CENTER_ALIGNMENT);

        lower = new JLabel("KMITL | REG");
        lower.setFont(Config.HEADER_SEMIBOLD[0]);
        lower.setForeground(Config.primaryColor_base);
        lower.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(50));
        panel.add(upper);
        panel.add(lower);
        panel.add(Box.createVerticalStrut(20));

        loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.PAGE_AXIS));
        loginPanel.setBackground(Config.bgColor_harder);
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        loginPanel.setPreferredSize(new Dimension(frame.getSize().width/3, frame.getSize().height/3));

        username = new JLabel("USERNAME");
        username.setFont(Config.HEADER_REGULAR[2]);
        username.setForeground(Color.WHITE);
        username.setAlignmentX(Component.LEFT_ALIGNMENT);

        Box userBox = Box.createHorizontalBox();
        userBox.add(username);
        userBox.add(Box.createHorizontalGlue());

        userT = new JTextField(20);
        userT.setFont(Config.NORMAL_REGULAR);
        userT.setBackground(Config.bgColor_hard);
        userT.setForeground(Color.WHITE);
        userT.setBorder(BorderFactory.createLineBorder(Config.primaryColor_hard, 2));

        password = new JLabel("PASSWORD");
        password.setFont(Config.HEADER_REGULAR[2]);
        password.setForeground(Color.WHITE);
        password.setAlignmentX(Component.LEFT_ALIGNMENT);

        Box passBox = Box.createHorizontalBox();
        passBox.add(password);
        passBox.add(Box.createHorizontalGlue());

        passT = new JPasswordField(20);
        passT.setFont(Config.NORMAL_REGULAR);
        passT.setBackground(Config.bgColor_hard);
        passT.setForeground(Color.WHITE);
        passT.setBorder(BorderFactory.createLineBorder(Config.primaryColor_hard, 2));

        loginButton = new RoundedButton("เข้าสู่ระบบ", 20);
        loginButton.setFont(Config.HEADER_REGULAR[1]);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Config.primaryColor_hard);

        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(this);

        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createHorizontalGlue());
        buttonBox.add(loginButton);
        buttonBox.add(Box.createHorizontalGlue());


        loginPanel.add(userBox);
        loginPanel.add(userT);
        loginPanel.add(Box.createVerticalStrut(10));
        loginPanel.add(passBox);
        loginPanel.add(passT);
        loginPanel.add(Box.createVerticalStrut(10));
        loginPanel.add(buttonBox);

        panel.add(loginPanel);

        bigPanel.add(panel);
        frame.add(bigPanel, BorderLayout.CENTER);
//        frame.setLocationRelativeTo(null
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame config = Config.createAndShowGUI();
        new LoginFrame(config);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
        if(e.getSource() == loginButton){
            System.out.println("Login");
            String username = userT.getText();
            String password = passT.getText();
            try{
                new Login(username,password).loginWithUsernameAndPassword();
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                new HomePage(frame);
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
                this.userorpassincorrect();
            }
        }
    }
    public void userorpassincorrect(){
        JDialog popup = Config.openFrame(frame.getWidth()/3,frame.getHeight()/3);
        popup.setLayout(new BorderLayout());
        JPanel dialog = new JPanel();
        dialog.setBackground(null);
        dialog.setSize(popup.getWidth(), popup.getHeight());
        dialog.setLayout(new BoxLayout(dialog, BoxLayout.Y_AXIS));

        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        upperPanel.setBackground(null);
        upperPanel.setSize(dialog.getWidth(), dialog.getHeight()/4);

        JLabel alertLabel = new JLabel("เกิดข้อผิดพลาด");
        alertLabel.setFont(Config.HEADER_SEMIBOLD[1]);
        alertLabel.setForeground(Color.WHITE);
        upperPanel.add(alertLabel);

        RoundedButton alertPic = new RoundedButton("",20);
        alertPic.setEnabled(false);
        alertPic.setIcon(new ImageIcon(new ImageIcon("source/shield-alert.png").getImage().getScaledInstance(upperPanel.getHeight()-30,upperPanel.getHeight()-30,Image.SCALE_SMOOTH)));
        alertPic.setSize(upperPanel.getHeight()-30,upperPanel.getHeight()-30);
        alertPic.setBackground(Config.errorColor_hard);
        upperPanel.add(alertPic);

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        middlePanel.setBackground(null);
        middlePanel.setSize(dialog.getWidth(), dialog.getHeight()/2);

        JLabel duocrossPic = new JLabel();
        duocrossPic.setIcon(new ImageIcon(new ImageIcon("source/cross-hand.png").getImage().getScaledInstance(middlePanel.getHeight()-30,middlePanel.getHeight()-30,Image.SCALE_SMOOTH)));
        middlePanel.add(duocrossPic);

        JLabel alert = new JLabel("Username หรือ Password ไม่ถูกต้อง");
        alert.setFont(Config.NORMAL_REGULAR.deriveFont(Float.parseFloat("18")));
        alert.setForeground(Color.WHITE);
        middlePanel.add(alert);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(null);
        bottomPanel.setSize(dialog.getWidth(), dialog.getHeight()/4);

        RoundedButton acceptButton = new RoundedButton("รับทราบ",20);
        acceptButton.setFont(Config.HEADER_REGULAR[2]);
        acceptButton.setBackground(Config.primaryColor_hard);
        acceptButton.setForeground(Color.WHITE);
        acceptButton.addActionListener(e -> popup.dispose());
        bottomPanel.add(acceptButton);

        dialog.add(upperPanel);
        dialog.add(middlePanel);
        dialog.add(bottomPanel);

        popup.add(dialog, BorderLayout.CENTER);
        popup.setVisible(true);
    }
}

