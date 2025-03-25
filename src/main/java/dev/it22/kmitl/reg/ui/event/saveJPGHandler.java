package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class saveJPGHandler implements ActionListener {
    private JPanel table;
    private JFrame frame;
    public saveJPGHandler(JPanel panel, JFrame frame) {
        this.table = panel;
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            BufferedImage image = new BufferedImage(table.getWidth(), table.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            table.printAll(g2d);
            g2d.dispose();

            //test fileChooser
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Image");
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("JPG Image", "jpg"));

            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (!file.getName().toLowerCase().endsWith(".jpg")) {
                    file = new File(file.getAbsolutePath() + ".jpg");
                }
                ImageIO.write(image, "jpg", file);
                JLabel l = new JLabel("Image Saved Successfully", SwingConstants.CENTER);
                l.setBackground(Config.primaryColor_hard);
                l.setForeground(Color.WHITE);
                l.setFont(Config.HEADER_SEMIBOLD[3]);

                JDialog success = new JDialog();
                success.setResizable(false);
                success.getContentPane().setBackground(Config.primaryColor_hard);
                success.add(l);
                success.setSize(280, 100);
                success.setLocation(frame.getX() + 500,frame.getY() + 500);
                success.setResizable(false);
                success.setVisible(true);
            }
            else{
                JLabel l = new JLabel("Image Saved Unsuccessful", SwingConstants.CENTER);
                l.setBackground(Config.primaryColor_hard);
                l.setForeground(Color.WHITE);
                l.setFont(Config.HEADER_SEMIBOLD[3]);

                JDialog success = new JDialog();
                success.setResizable(false);
                success.getContentPane().setBackground(Config.primaryColor_hard);
                success.add(l);
                success.setSize(280, 100);
                success.setLocation(frame.getX() + 500,frame.getY() + 500);
                success.setResizable(false);
                success.setVisible(true);
            }

        }catch(Exception ex){
            JLabel l = new JLabel("Image Saved Unsuccessful", SwingConstants.CENTER);
            l.setBackground(Config.primaryColor_hard);
            l.setForeground(Color.WHITE);
            l.setFont(Config.HEADER_SEMIBOLD[3]);

            JDialog success = new JDialog();
            success.setResizable(false);
            success.getContentPane().setBackground(Config.primaryColor_hard);
            success.add(l);
            success.setSize(280, 100);
            success.setLocation(frame.getX() + 500,frame.getY() + 500);
            success.setResizable(false);
            success.setVisible(true);
        }
    }
}
