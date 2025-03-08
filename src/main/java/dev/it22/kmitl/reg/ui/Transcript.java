package dev.it22.kmitl.reg.ui;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class Transcript {
    private JFrame frame;
    private JPanel mainPanel, transcriptPanel, westPanel, eastPanel, topPanel, bottomPanel, textPanel1, textPanel2, unVisiblePanel1, unVisiblePanel2, buttonPanel;
    private JLabel transcHeader, transcSubHeader;
    private RoundedButton download;

    public Transcript(JFrame frame) {
        this.frame = frame;

        transcHeader = new JLabel("Transcript", SwingConstants.CENTER);
        transcHeader.setFont(Config.HEADER_SEMIBOLD[0]);
        transcHeader.setForeground(Config.primaryColor_hard);

        transcSubHeader = new JLabel("ทรานสคริปต์จำลอง (Unofficial Transcript)");
        transcSubHeader.setFont(Config.HEADER_SEMIBOLD[3]);
        transcSubHeader.setForeground(new Color(255, 255, 255));

        mainPanel = new JPanel();
        transcriptPanel = new JPanel();
        westPanel = new JPanel();
        eastPanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        textPanel1 = new JPanel();
        textPanel2 = new JPanel();
        unVisiblePanel1 = new JPanel();
        unVisiblePanel2 = new JPanel();
        buttonPanel = new JPanel();
        download = new RoundedButton("Download", 20);

        westPanel.setPreferredSize(new Dimension((int)(frame.getWidth()/2.98),frame.getHeight()));
        eastPanel.setPreferredSize(new Dimension((int) (frame.getWidth()/3.02),frame.getHeight()));
        mainPanel.setBackground(null);
        eastPanel.setBackground(null);
        westPanel.setBackground(null);
        topPanel.setBackground(null);
        bottomPanel.setBackground(null);
        textPanel1.setBackground(null);
        textPanel2.setBackground(null);
        unVisiblePanel1.setBackground(null);
        unVisiblePanel2.setBackground(null);
        buttonPanel.setBackground(null);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(eastPanel, BorderLayout.EAST);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(transcriptPanel, BorderLayout.CENTER);

        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(Box.createVerticalStrut(5));
        topPanel.add(textPanel1);
        topPanel.add(textPanel2);

        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(unVisiblePanel1);
        bottomPanel.add(buttonPanel);
        unVisiblePanel1.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()/300));

        buttonPanel.add(unVisiblePanel2);
        unVisiblePanel2.setPreferredSize(new Dimension((frame.getWidth()/600),frame.getHeight()/12));

        buttonPanel.add(download);
        buttonPanel.setPreferredSize(new Dimension((frame.getWidth()),frame.getHeight()/10));
        download.setBackground(Config.primaryColor_hard);
        download.setForeground(new Color(255, 255, 255));
        download.setFont(Config.HEADER_SEMIBOLD[2]);
        download.setPreferredSize(new Dimension((int)(frame.getWidth()/3.5),frame.getHeight()/12));

        textPanel1.add(transcHeader);
        textPanel1.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()/17));
        textPanel2.add(transcSubHeader);

        frame.add(mainPanel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println(transcriptPanel.getHeight());
    }

    public static void main(String[] args) {
        new Transcript(Config.createAndShowGUI());
    }
}
