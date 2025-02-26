package dev.it22.kmitl.reg.ui.profile;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;

public class LoginFrame {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final JButton registerButton;

    public LoginFrame(JFrame config) {
        config.setTitle("Login");
        config.setLayout(new GridLayout(3, 2));

        config.add(new JLabel("Username:"));
        usernameField = new JTextField();
        config.add(usernameField);

        config.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        config.add(passwordField);

        loginButton = new JButton("Login");
        config.add(loginButton);

        registerButton = new JButton("Register");
        config.add(registerButton);

        config.setVisible(true);
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }


    public static void main(String[] args) {
        JFrame config = Config.createAndShowGUI();
        new LoginFrame(config);
    }
}

