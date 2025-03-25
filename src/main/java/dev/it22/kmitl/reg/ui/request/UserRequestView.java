package dev.it22.kmitl.reg.ui.request;

import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class UserRequestView {
    JFrame frame;
    JPanel upperPanel , eastPanel , lowerPanel;
    JLabel showLabel;
    RoundedButton returnBtn , approveBtn;
    JTable table;
    JScrollPane scrollPane;
    public UserRequestView(JFrame frame) {
        this.frame = frame;
        upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setBackground(null);
        upperPanel.add(Config.createLogoAndTitle(Config.HEADER_SEMIBOLD[3],50) , BorderLayout.WEST);

        eastPanel = new JPanel();
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

        lowerPanel = new JPanel();
        lowerPanel.setLayout(new BorderLayout());
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(0,50,30,50));
        lowerPanel.setBackground(null);

        showLabel = new JLabel("List of Request");
        showLabel.setFont(Config.HEADER_SEMIBOLD[0]);
        showLabel.setForeground(Color.WHITE);
        lowerPanel.add(showLabel, BorderLayout.NORTH);


        table = new JTable();
        table.setBackground(Config.bgColor_hard);
        table.setForeground(Color.WHITE);
        scrollPane = new JScrollPane(table);
        lowerPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        southPanel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        southPanel.setBackground(null);

        approveBtn = new RoundedButton("Aprrove",20);
        approveBtn.setFont(Config.HEADER_SEMIBOLD[3]);
        approveBtn.setPreferredSize(new Dimension(100,50));
        southPanel.add(approveBtn);


        lowerPanel.add(southPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(lowerPanel , BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new UserRequestView(Config.createAndShowGUI());
    }
}
