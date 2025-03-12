package dev.it22.kmitl.reg.ui.transcript;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class TranscriptView {
    private JFrame frame;
    private JPanel mainPanel, transcriptPanel, centerPanel, topLeftPanel, topMidPanel, topRightPanel, topPanel, bottomPanel, textPanel1, textPanel2, unVisiblePanel1, buttonPanel;
    private JLabel transcHeader, transcSubHeader;
    private JButton homeButton;
    private RoundedButton download;
    private ImageIcon homeIcon;

    public TranscriptView(JFrame frame) {
        this.frame = frame;

        transcHeader = new JLabel("Transcript", SwingConstants.CENTER);
        transcHeader.setFont(Config.HEADER_SEMIBOLD[0]);
        transcHeader.setForeground(Config.primaryColor_hard);

        transcSubHeader = new JLabel("ทรานสคริปต์จำลอง (Unofficial Transcript)");
        transcSubHeader.setFont(Config.HEADER_SEMIBOLD[3]);
        transcSubHeader.setForeground(new Color(255, 255, 255));

        mainPanel = new JPanel();
        transcriptPanel = new JPanel();
        topPanel = new JPanel();
        topLeftPanel = new JPanel();
        topMidPanel = new JPanel();
        topRightPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();
        textPanel1 = new JPanel();
        textPanel2 = new JPanel();
        unVisiblePanel1 = new JPanel();
        buttonPanel = new JPanel();
        homeIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_home_re.png").getImage().getScaledInstance(frame.getWidth()/30, frame.getWidth()/30, Image.SCALE_SMOOTH));
        download = new RoundedButton("DOWNLOAD", 20);
        homeButton = new JButton(homeIcon);

        mainPanel.setBackground(null);
        topPanel.setBackground(null);
        topLeftPanel.setBackground(null);
        topMidPanel.setBackground(null);
        topRightPanel.setBackground(null);
        centerPanel.setBackground(null);
        bottomPanel.setBackground(null);
        textPanel1.setBackground(null);
        textPanel2.setBackground(null);
        unVisiblePanel1.setBackground(null);
        buttonPanel.setBackground(null);

        homeButton.setBackground(null);
        homeButton.setBounds(10,10,frame.getWidth()/30, frame.getWidth()/30);
        homeButton.setBorderPainted(false);
        homeButton.setFocusPainted(false);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(topPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(bottomPanel);

        topPanel.setLayout(new GridLayout(1,3));
        topPanel.add(topLeftPanel);
        topPanel.add(topMidPanel);
        topPanel.add(topRightPanel);
        topLeftPanel.setLayout(null);
        topLeftPanel.add(homeButton);
        topMidPanel.setLayout(new BoxLayout(topMidPanel, BoxLayout.Y_AXIS));
        topMidPanel.add(Box.createVerticalStrut(5));
        topMidPanel.add(textPanel1);
        topMidPanel.add(textPanel2);

        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        transcriptPanel.setPreferredSize(new Dimension((int) ((frame.getHeight()/1.368316831683168) / 1.414285714), (int)(frame.getHeight()/1.368316831683168) ));
        transcriptPanel.setSize(new Dimension((int) ((frame.getHeight()/1.368316831683168) / 1.414285714), (int)(frame.getHeight()/1.368316831683168) ));
        centerPanel.add(transcriptPanel);

        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setSize(frame.getWidth()/30, frame.getWidth()/30);
        bottomPanel.add(unVisiblePanel1);
        bottomPanel.add(buttonPanel);
        unVisiblePanel1.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()/300));

        buttonPanel.add(download);
        buttonPanel.setPreferredSize(new Dimension((frame.getWidth()),frame.getHeight()/10));
        download.setBackground(Config.primaryColor_hard);
        download.setForeground(new Color(255, 255, 255));
        download.setFont(Config.HEADER_SEMIBOLD[2]);
        download.setPreferredSize(new Dimension((int) ((frame.getHeight()/1.368316831683168) / 1.414285714),frame.getHeight()/12));

        textPanel1.add(transcHeader);
        textPanel1.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()/17));
        textPanel2.add(transcSubHeader);
        frame.getContentPane().add(mainPanel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println(bottomPanel.getWidth());
        System.out.println(bottomPanel.getHeight());
    }

    public RoundedButton getDownloadButton() {
        return download;
    }
    public JButton getHomeButton() {return homeButton;}
    public JFrame getFrame() {return frame;}

}
