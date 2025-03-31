package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuccessModal implements ActionListener {

    private JDialog popup;
    private RoundedButton acceptButton;

    public SuccessModal(JFrame frame, String errorMessage) {
        popup = Config.openFrame(400,200);
        popup.setLayout(new BorderLayout());

        JPanel dialog = new JPanel();
        dialog.setSize(popup.getSize());
        dialog.setBackground(Config.bgColor_harder);
        dialog.setSize(popup.getWidth(), popup.getHeight());
        dialog.setLayout(new BoxLayout(dialog, BoxLayout.Y_AXIS));
        dialog.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel title = new JLabel("สำเร็จ");
        title.setFont(Config.HEADER_SEMIBOLD[1]);
        title.setForeground(Color.WHITE);
        titlePanel.add(title);
        titlePanel.setBackground(null);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        RoundedButton errorIcon = new RoundedButton("" , 20);
        errorIcon.setBackground(new Color(0,210,80));
        errorIcon.setIcon(new ImageIcon(new ImageIcon("source/check.png").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT)));
        errorIcon.setEnabled(false);
        titlePanel.add(errorIcon);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPanel.setBackground(null);

        JLabel duocrossPic = new JLabel();
        duocrossPic.setIcon(new ImageIcon(new ImageIcon("source/duo.png").getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
        duocrossPic.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        contentPanel.add(duocrossPic);

        JTextArea errorLabel = new JTextArea(errorMessage,1,25);
        errorLabel.setEditable(false);
        errorLabel.setLineWrap(true);
        errorLabel.setBackground(null);
        errorLabel.setFont(Config.NORMAL_REGULAR);
        errorLabel.setForeground(Color.WHITE);
        errorLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

        contentPanel.add(errorLabel);

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        footerPanel.setBackground(null);

        acceptButton = new RoundedButton("รับทราบ",20);
        acceptButton.setBackground(Config.primaryColor_hard);
        acceptButton.setFont(Config.HEADER_SEMIBOLD[3]);
        acceptButton.setForeground(Color.WHITE);
        acceptButton.addActionListener(this);
        footerPanel.add(acceptButton);

        titlePanel.setSize(dialog.getWidth(), titlePanel.getHeight());
        titlePanel.setBackground(null);
        dialog.add(titlePanel);
        dialog.add(contentPanel);
        dialog.add(footerPanel);

        popup.add(dialog);
        popup.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == acceptButton){
            popup.dispose();
        }
    }

    public static void main(String[] args) {
        JFrame frame = Config.createAndShowGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new SuccessModal(frame,"32202");
    }

}
