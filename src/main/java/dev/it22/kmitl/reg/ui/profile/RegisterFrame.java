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
        container.setLayout(new FlowLayout());
        container.setBackground(null);
        frame.add(container);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame config = Config.createAndShowGUI();
        new RegisterFrame(config);
    }
}
