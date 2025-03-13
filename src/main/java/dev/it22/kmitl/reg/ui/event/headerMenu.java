package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;

public class headerMenu extends JMenuBar {

    //head-menubar
    private JMenu ETC;
    private JMenuItem savePDF, saveJPG, share;
    private JLabel innerLabel;
    private JLabel outer_Label;
    private JButton home;
    private JPanel SchPanel;

    public headerMenu(JFrame frame) {
        this("No title", frame);
    }

    public headerMenu(String title, JFrame frame) {

        ETC = new JMenu("ETC");
        savePDF = new JMenuItem("Save PDF");
        saveJPG = new JMenuItem("Save JPG");
        share = new JMenuItem("Share");
        innerLabel = new JLabel(title);
        outer_Label = new JLabel(title);
        home = new JButton("Home");

        outer_Label.setForeground(Config.primaryColor_base);
        outer_Label.setFont(Config.HEADER_SEMIBOLD[1]);;

        //head-menubar
        SchPanel = new JPanel();

        innerLabel.setPreferredSize(new Dimension(110, 30));
        innerLabel.setSize(110, 30);
        innerLabel.setForeground(Config.primaryColor_base);
        SchPanel.add(innerLabel);
        SchPanel.setBackground(Config.bgColor_base);

        ImageIcon homeIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_home_re.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
        home = new JButton(homeIcon);

        ETC = new JMenu();
        ImageIcon originalIcon = new ImageIcon("source/icon_schedule/icon_etc.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        ETC.setIcon(scaledIcon);
        ETC.setBackground(Config.bgColor_base);
        ETC.getPopupMenu().setBorder(BorderFactory.createLineBorder(Config.bgColor_harder));
        ETC.setMenuLocation(-45, 38);

        ImageIcon savePDFIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_saveFile.png").getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH));
        savePDF = new JMenuItem("Save PDF",savePDFIcon);
        savePDF.setPreferredSize(new Dimension(30,40));
        savePDF.setBackground(Config.bgColor_base);
        savePDF.setForeground(Config.primaryColor_base);
        savePDF.setBorder(BorderFactory.createLineBorder(Config.bgColor_base));

        ImageIcon saveJPGIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_saveImage.png").getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH));
        saveJPG = new JMenuItem("Save JPG",saveJPGIcon);
        saveJPG.setPreferredSize(new Dimension(30,40));
        saveJPG.setBackground(Config.bgColor_base);
        saveJPG.setForeground(Config.primaryColor_base);
        saveJPG.setBorder(BorderFactory.createLineBorder(Config.bgColor_base));

        ImageIcon shareIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_share.png").getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH));
        share = new JMenuItem("Share",shareIcon);
        share.setPreferredSize(new Dimension(30,40));
        share.setBackground(Config.bgColor_base);
        share.setForeground(Config.primaryColor_base);
        share.setBorder(BorderFactory.createLineBorder(Config.bgColor_base));

        outer_Label.setForeground(Config.primaryColor_base);
        outer_Label.setFont(Config.HEADER_SEMIBOLD[1]);

        home.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 5));
        ETC.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        outer_Label.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));

        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setFocusPainted(false);

        this.setBackground(Config.bgColor_base);
        this.setBorderPainted(false);
        this.add(home);

        ETC.setForeground(Config.primaryColor_base);
        this.add(ETC);
        this.add(outer_Label);
        ETC.add(SchPanel);
        ETC.add(savePDF);
        ETC.add(saveJPG);
        ETC.add(share);

        //set event handler
        home.addActionListener(new HomeButtonHandler(frame));
    }

}
