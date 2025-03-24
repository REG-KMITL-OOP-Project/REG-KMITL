package dev.it22.kmitl.reg.ui.request;

import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class UserRequestView {
    JFrame frame;
    JPanel upperPanel;
    RoundedButton returnBtn;
    public UserRequestView(JFrame frame) {
        this.frame = frame;
        upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setBackground(null);
        upperPanel.add(Config.createLogoAndTitle(Config.HEADER_SEMIBOLD[3],50) , BorderLayout.WEST);

        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new FlowLayout(FlowLayout.CENTER,40,40));
        eastPanel.setBackground(null);

        returnBtn = new RoundedButton("",20);
        returnBtn.setIcon(new ImageIcon(new ImageIcon("source/undo.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        returnBtn.setPreferredSize(new Dimension(50,50));
        returnBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnBtn.setAlignmentY(Component.CENTER_ALIGNMENT);
        returnBtn.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new HomePage(frame);
        });
        eastPanel.add(returnBtn);
        upperPanel.add(eastPanel , BorderLayout.EAST);

        frame.getContentPane().add(upperPanel , BorderLayout.NORTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new UserRequestView(Config.createAndShowGUI());
    }
}
