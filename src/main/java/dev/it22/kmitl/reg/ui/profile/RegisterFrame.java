package dev.it22.kmitl.reg.ui.profile;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame {

    private JPanel container;
    private  JLabel titleLabel;

    public RegisterFrame(JFrame frame) {
        frame.setTitle("Register");

        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.setBackground(null);
        frame.add(container);

        titleLabel = new JLabel("Register");
        titleLabel.setFont(Config.HEADER_SEMIBOLD[1]);
        titleLabel.setForeground(new Color(255,255,255));
        container.add(titleLabel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame config = Config.createAndShowGUI();
        new RegisterFrame(config);
    }
}
