package dev.it22.kmitl.reg.ui.profile;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.ErrorModal;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame implements ActionListener {
    private JFrame frame;
    private JPanel bigPanel , panel , loginPanel;
    private JLabel upper,lower,username,password;
    private JTextField userT;
    private JPasswordField passT;
    private RoundedButton loginButton;
    private JButton toggle;
    private boolean toggled = false;

    public LoginFrame(JFrame frame) {
        this.frame = frame;
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
        userT.setPreferredSize(new Dimension(loginPanel.getPreferredSize().width, 25));

        password = new JLabel("PASSWORD");
        password.setFont(Config.HEADER_REGULAR[2]);
        password.setForeground(Color.WHITE);
        password.setAlignmentX(Component.LEFT_ALIGNMENT);

        Box passBox = Box.createHorizontalBox();
        passBox.add(password);
        passBox.add(Box.createHorizontalGlue());

        JPanel passwordP = new JPanel();
        passwordP.setLayout(new FlowLayout(FlowLayout.LEFT,0,1));
        passwordP.setPreferredSize(new Dimension(loginPanel.getPreferredSize().width, 26));
        passwordP.setBackground(Config.bgColor_hard);
        passwordP.setBorder(BorderFactory.createLineBorder(Config.primaryColor_hard, 2));

        passT = new JPasswordField(27);
        passT.setFont(Config.NORMAL_REGULAR);
        passT.setBackground(null);
        passT.setForeground(Color.WHITE);
        passT.setBorder(BorderFactory.createLineBorder(null, 0));
        passwordP.add(passT);

        toggle = new JButton();
        toggle.setIcon(new ImageIcon(new ImageIcon("source/eye-closed.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
        toggle.setBackground(Config.bgColor_hard);
        toggle.setBorderPainted(false);
        toggle.setContentAreaFilled(false);
        toggle.setFocusPainted(false);
        toggle.setPreferredSize(new Dimension(20,passT.getPreferredSize().height));
        toggle.addActionListener(e -> {
            if (toggled){
                passT.setEchoChar('•');
                toggle.setIcon(new ImageIcon(new ImageIcon("source/eye-closed.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
            }else{
                passT.setEchoChar((char) 0);
                toggle.setIcon(new ImageIcon(new ImageIcon("source/eye.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
            }
            toggled = !toggled;
        });
        passwordP.add(toggle);

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
        loginPanel.add(passwordP);
        loginPanel.add(Box.createVerticalStrut(10));
        loginPanel.add(buttonBox);

        panel.add(loginPanel);

        bigPanel.add(panel);
        frame.getRootPane().setDefaultButton(loginButton);
        frame.add(bigPanel, BorderLayout.CENTER);
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
                new ErrorModal(frame,"Username หรือ Password ไม่ถูกต้อง");
            }
        }
    }
}

