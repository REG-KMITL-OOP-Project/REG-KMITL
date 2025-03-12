package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorModal implements ActionListener {

    private JDialog popup;
    private RoundedButton acceptButton;

    public ErrorModal(JFrame frame,String errorMessage) {
        popup = Config.openFrame(400,200);
        popup.setLayout(new BorderLayout());

        JPanel dialog = new JPanel();
        dialog.setSize(popup.getSize());
        dialog.setBackground(Config.bgColor_base);
        dialog.setSize(popup.getWidth(), popup.getHeight());
        dialog.setLayout(new BoxLayout(dialog, BoxLayout.Y_AXIS));
        dialog.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel title = new JLabel("เกิดข้อผิดพลาด");
        title.setFont(Config.HEADER_SEMIBOLD[1]);
        title.setForeground(Color.WHITE);
        titlePanel.add(title);
        titlePanel.setBackground(null);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPanel.setBackground(null);
        JLabel duocrossPic = new JLabel();
        duocrossPic.setIcon(new ImageIcon(new ImageIcon("source/cross-hand.png").getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
        duocrossPic.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        contentPanel.add(duocrossPic);

        JLabel errorLabel = new JLabel("<html><div style='width:220px;'>" + errorMessage + "</div></html>");
        errorLabel.setFont(Config.NORMAL_REGULAR);
        errorLabel.setForeground(Color.WHITE);
        contentPanel.add(errorLabel);

        RoundedButton errorIcon = new RoundedButton("" , 20);
        errorIcon.setBackground(Config.errorColor_hard);
        errorIcon.setIcon(new ImageIcon(new ImageIcon("source/shield-alert.png").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT)));
        titlePanel.add(errorIcon);

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
        popup.setUndecorated(false);
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

        new ErrorModal(frame,"ควย");
    }

}
